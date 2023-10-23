package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthGroupRepository extends JpaRepository<Group, Integer> {
}
