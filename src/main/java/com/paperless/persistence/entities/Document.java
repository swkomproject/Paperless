package com.paperless.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;


@Getter
@Setter
@Entity
public class Document {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false, length = 128)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Column(nullable = false)
    private OffsetDateTime created;

    @Column(nullable = false)
    private OffsetDateTime modified;

    @Column(nullable = false, length = 32)
    private String checksum;

    @Column(nullable = false)
    private OffsetDateTime added;

    @Column(nullable = false, length = 11)
    private String storageType;

    @Column(length = 1024)
    private String filename;

    @Column
    private Integer archiveSerialNumber;

    @Column(nullable = false, length = 256)
    private String mimeType;

    @Column(length = 32)
    private String archiveChecksum;

    @Column(length = 1024)
    private String archiveFilename;

    @Column(length = 1024)
    private String originalFilename;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "correspondent_id")
    private Correspondent correspondent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_path_id")
    private StoragePath storagePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "document")
    private Set<DocumentsNote> documentDocumentsNotes;

    @OneToMany(mappedBy = "document")
    private Set<DocumentTags> documentDocumentTags;

    public void setDocumentDocumentsNotes(final Set<DocumentsNote> documentDocumentsNotes) {
        this.documentDocumentsNotes = documentDocumentsNotes;
    }

    public void setDocumentDocumentTags(
            final Set<DocumentTags> documentDocumentTags) {
        this.documentDocumentTags = documentDocumentTags;
    }

}
