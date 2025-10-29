package com.tekton.technical_test.infrastructure.driver_adapter.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekton.technical_test.infrastructure.driver_adapter.postgres.entities.AuditEntity;

public interface AuditRepository extends JpaRepository<AuditEntity, Long> {
    
}
