package com.paperless.persistence.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Permission {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 100)
    private String contentType;

    @Column(nullable = false, length = 100)
    private String codename;

    @OneToMany(mappedBy = "permission")
    private Set<GroupPermissions> permissionGroupPermissions;

    @OneToMany(mappedBy = "permission")
    private Set<UserPermissions> permissionUserPermissions;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(final String codename) {
        this.codename = codename;
    }

    public Set<GroupPermissions> getPermissionAuthGroupPermissionses() {
        return permissionGroupPermissions;
    }

    public void setPermissionAuthGroupPermissionses(
            final Set<GroupPermissions> permissionGroupPermissions) {
        this.permissionGroupPermissions = permissionGroupPermissions;
    }

    public Set<UserPermissions> getPermissionAuthUserUserPermissionses() {
        return permissionUserPermissions;
    }

    public void setPermissionAuthUserUserPermissionses(
            final Set<UserPermissions> permissionUserPermissions) {
        this.permissionUserPermissions = permissionUserPermissions;
    }

}