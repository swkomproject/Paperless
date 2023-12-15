import pika
from PIL import Image
import pytesseract
from minio import Minio
from urllib.parse import urlparse
from pdf2image import convert_from_bytes
import psycopg2
import time

print("Sleeping for 20 seconds to allow other containers to start...")
time.sleep(20)

from elastic_search_service import ElasticSearchService

print("Starting OCR service...")

connection = None


es_service = ElasticSearchService()

def add_to_elasticsearch(text, file_id):
    es_service.index_document({
        "id": file_id,
        "content": text
    })

try:
    # Connect to RabbitMQ
    connection_params = pika.ConnectionParameters(
        host='paperless-rabbitmq',  # Replace 'localhost' with your RabbitMQ server's endpoint
        credentials=pika.PlainCredentials('paperless', 'paperless'),  # Replace with your RabbitMQ username and password
        connection_attempts=1,
        socket_timeout=2.0,
        stack_timeout=2.0
    )
    connection = pika.BlockingConnection(connection_params)
    print("Connected to paperless-rabbitmq")
except Exception as e:
    print("Connection to paperless-rabbitmq failed, trying paperless-rabbitmq-standalone")
    # Connect to RabbitMQ
    connection_params = pika.ConnectionParameters(
        host='paperless-rabbitmq-standalone',  # Replace 'localhost' with your RabbitMQ server's endpoint
        credentials=pika.PlainCredentials('paperless', 'paperless')  # Replace with your RabbitMQ username and password
    )
    connection = pika.BlockingConnection(connection_params)
    print("Connected to paperless-rabbitmq-standalone")

if(connection == None):
    print("Error: Could not connect to RabbitMQ")
    exit(1)

connection = pika.BlockingConnection(connection_params)
channel = connection.channel()
channel.queue_declare(queue='ORC_DOCUMENT_IN')

# MinIO configuration
minio_endpoint = 'paperless-minio:9000'
access_key = 'paperless'
secret_key = 'paperless'
bucket_name = 'paperless-files'

minio_client = None
try:
    minio_client = Minio(minio_endpoint, access_key=access_key, secret_key=secret_key, secure=False)
    if not minio_client.bucket_exists("nonexistingbucket"):
        print("Connected to paperless-minio:9000")
except Exception as e:
    print("Connection to paperless-minio:9000 failed, trying paperless-minio-standalone:9000")
    minio_endpoint = 'paperless-minio-standalone:9000'
    minio_client = Minio(minio_endpoint, access_key=access_key, secret_key=secret_key, secure=False)
    if not minio_client.bucket_exists("nonexistingbucket"):
        print("Connected to paperless-minio-standalone:9000")
    else:
        print("Connected to minio failed!")

if(minio_client == None):
    print("Error: Could not connect to MinIO")
    exit(1)

conn = None

try:
    # Postgres connection
    conn = psycopg2.connect(
        dbname="paperless",
        user="paperless",
        password="paperless",
        host="paperless-postgres",
        port="5432"
    )
    print("Connected to paperless-postgres")
except Exception as e:
    print("Connection to paperless-postgres failed, trying paperless-postgres-standalone")
    # Postgres connection
    conn = psycopg2.connect(
        dbname="paperless",
        user="paperless",
        password="paperless",
        host="paperless-postgres-standalone",
        port="5432"
    )
    print("Connected to paperless-postgres-standalone")

if(conn == None):
    print("Error: Could not connect to PostgreSQL")
    exit(1)

# Function to add text to database
def addToDatabase(text, fileId):
    cur = conn.cursor()

    sql = "UPDATE document SET content = %s WHERE id = %s;"

    cur.execute(sql, (text,fileId))

    # Commit the transaction
    conn.commit()

    # Close communication with the PostgreSQL database
    cur.close()

# Callback function (is run when new rabbitmq message is received)
def callback(ch, method, properties, body):
    try:
        file_url = body.decode('utf-8')  # Get file path from the message
        print(file_url)

        bucket_name = file_url.split('/')[0]
        object_path = file_url.split('/')[1]
        file_id = object_path.split('.')[0]

        print(bucket_name)
        print(object_path)
        print(file_id)

        # Download the entire file
        file_data = minio_client.get_object(bucket_name, object_path)
        # minio_client.fget_object(bucket_name, file_name, download_path)

        doc = convert_from_bytes(file_data.data)
        allText = ""
        for page_number, page_data in enumerate(doc):
            txt = pytesseract.image_to_string(page_data, lang="deu")
            print(txt)
            allText += txt + "\n"

        print(allText)

        addToDatabase(allText, file_id)
        add_to_elasticsearch(allText, file_id)
    except Exception as e:
        print(e)
        print("Error: Could not process file")
        return

# Tell RabbitMQ to call the callback function when a new message is received
channel.basic_consume(queue='ORC_DOCUMENT_IN', on_message_callback=callback, auto_ack=True)

print("Service started!")

channel.start_consuming()