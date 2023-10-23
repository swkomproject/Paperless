package com.paperless.persistence.repositories;

import com.paperless.persistence.entities.AuthUserUserPermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionsRepository extends JpaRepository<AuthUserUserPermissions, Integer> {
}
