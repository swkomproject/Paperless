package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.PaperlessMailMailruleAssignTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperlessMailMailruleAssignTagsRepository extends JpaRepository<PaperlessMailMailruleAssignTags, Integer> {
}
