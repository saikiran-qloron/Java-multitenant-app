package com.project.multitenant.Enities;

import com.project.multitenant.TenantUtils.TenantIdentifierResolver;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tenant", schema = TenantIdentifierResolver.DEFAULT_SCHEMA)
public class Tenant {
    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "schema_name", nullable = false, unique = true)
    private String schemaName;

    @Column(name = "issuer", nullable = false, unique = true)
    private String issuer;
}