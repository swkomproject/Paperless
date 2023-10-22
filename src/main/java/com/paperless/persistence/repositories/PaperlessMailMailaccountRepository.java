package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.PaperlessMailMailaccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailMailaccountRepository extends JpaRepository<PaperlessMailMailaccount, Integer> {
}
