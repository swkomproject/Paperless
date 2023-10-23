package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsDocumenttypeRepository extends JpaRepository<DocumentType, Integer> {
}
