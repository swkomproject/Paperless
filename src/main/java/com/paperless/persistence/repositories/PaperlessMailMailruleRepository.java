package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.PaperlessMailMailrule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailMailruleRepository extends JpaRepository<PaperlessMailMailrule, Integer> {
}
