package com.paperless.services.impl;

import com.paperless.persistence.repositories.DocumentRepository;
import com.paperless.services.dto.okresponse.GetDocument200Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    @Autowired
    private DocumentMapper documentMapper;
    @Autowired
    private GetDocument200ResponseMapper getDocument200ResponseMapper;


    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public GetDocument200Response getDocument(Integer id, Integer page, Boolean fullPerms) {
        //TODO: Map entity obtained from repository to DTO
        //return documentRepository.getReferenceById(id);

        GetDocument200Response sampleResponse = new GetDocument200Response();
        sampleResponse.id(1)
                .correspondent(1001)
                .documentType(2)
                .storagePath(3)
                .title("Sample Document")
                .content("This is the content of the sample document.")
                .tags(new ArrayList<>())
                .created("2023-10-22")
                .createdDate("2023-10-22T12:00:00Z")
                .modified("2023-10-22T13:30:00Z")
                .added("2023-10-22T14:45:00Z")
                .archiveSerialNumber(7)
                .originalFileName("sample_document.pdf")
                .archivedFileName("archived_sample_document.pdf")
                .owner(1002);

        return sampleResponse;
    }

//    @Override
//    public DocumentsDocument uploadDocument(String title, OffsetDateTime created, Integer documentType, List<Integer> tags, Integer correspondent, List<MultipartFile> document) {
//        return documentRepository.save();
//    }

}
