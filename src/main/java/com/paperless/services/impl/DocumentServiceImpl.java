package com.paperless.services.impl;

import com.paperless.persistence.entities.Document;
import com.paperless.persistence.repositories.DocumentRepository;
import com.paperless.services.dto.DocumentDTO;
import com.paperless.services.dto.okresponse.GetDocument200Response;
import com.paperless.services.dto.okresponse.GetDocuments200Response;
import com.paperless.services.mapper.DocumentMapper;
import com.paperless.services.mapper.GetDocument200ResponseMapper;
import org.hibernate.type.OffsetDateTimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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
        Document foundEntity =  documentRepository.getReferenceById(id);
        return getDocument200ResponseMapper.entityToDto(foundEntity);
    }


    @Override
    public void uploadDocument(DocumentDTO documentDTO, List<MultipartFile> document) {
        // TODO: document variable is unused yet

        documentDTO.setCreated(OffsetDateTime.now());
        documentDTO.setAdded(OffsetDateTime.now());
        documentDTO.setModified(OffsetDateTime.now());
        documentDTO.content("");
        documentDTO.setAdded(OffsetDateTime.now());


        Document documentToBeSaved = documentMapper.dtoToEntity(documentDTO);

        documentToBeSaved.setChecksum("checksum");
        documentToBeSaved.setStorageType("pdf");
        documentToBeSaved.setMimeType("pdf");

        documentRepository.save(documentToBeSaved);
    }


    @Override
    public ResponseEntity<GetDocuments200Response> getDocuments(Integer page, Integer pageSize, String query, String ordering, List<Integer> tagsIdAll, Integer documentTypeId, Integer storagePathIdIn, Integer correspondentId, Boolean truncateContent) {
        List<DocumentDTO> documentDTOS = new ArrayList<>();
        for (Document document : documentRepository.findAll()) {
            documentDTOS.add(documentMapper.entityToDto(document));
        }


        GetDocuments200Response sampleResponse = new GetDocuments200Response();
        // We will need GetDocuments200ResponseResultsInner dtos here....
        // sampleResponse.addResultsItem()
        return ResponseEntity.ok(sampleResponse);
    }



//    @Override
//    public DocumentsDocument uploadDocument(String title, OffsetDateTime created, Integer documentType, List<Integer> tags, Integer correspondent, List<MultipartFile> document) {
//        return documentRepository.save();
//    }

}
