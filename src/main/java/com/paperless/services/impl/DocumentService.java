package com.paperless.services.impl;

import com.paperless.services.dto.okresponse.GetDocument200Response;

public interface DocumentService {
    GetDocument200Response getDocument(Integer id, Integer page, Boolean fullPerms);

//    DocumentsDocument uploadDocument(String title, OffsetDateTime created, Integer documentType, List<Integer> tags, Integer correspondent, List<MultipartFile> document);
}
