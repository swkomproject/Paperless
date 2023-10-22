package com.paperless.services.impl;

import com.paperless.persistence.entities.DocumentsDocument;
import com.paperless.services.dto.GetDocument200Response;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.List;

public interface DocumentService {
    GetDocument200Response getDocument(Integer id, Integer page, Boolean fullPerms);

//    DocumentsDocument uploadDocument(String title, OffsetDateTime created, Integer documentType, List<Integer> tags, Integer correspondent, List<MultipartFile> document);
}
