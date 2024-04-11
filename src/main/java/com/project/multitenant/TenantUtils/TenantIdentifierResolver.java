package com.project.multitenant.TenantUtils;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {
    public static final String DEFAULT_SCHEMA = "public";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContext.getCurrentTenant() != null
                ? TenantContext.getCurrentTenant()
                : DEFAULT_SCHEMA;

        System.out.println("TenantIdentifierResolver 22: " + tenant);

        return tenant;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}