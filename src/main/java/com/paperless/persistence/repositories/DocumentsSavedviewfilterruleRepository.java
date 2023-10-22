package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.DocumentsSavedviewfilterrule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsSavedviewfilterruleRepository extends JpaRepository<DocumentsSavedviewfilterrule, Integer> {
}
