package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.DocumentsPaperlesstask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsPaperlesstaskRepository extends JpaRepository<DocumentsPaperlesstask, Integer> {
}
