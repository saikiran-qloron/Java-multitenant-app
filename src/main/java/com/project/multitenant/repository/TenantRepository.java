package com.project.multitenant.repository;

import com.project.multitenant.Enities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, String> {
}
