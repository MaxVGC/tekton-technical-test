package com.tekton.technical_test.infrastructure.driver_adapter.postgres.mappers;

import org.mapstruct.Mapper;

import com.tekton.technical_test.application.dtos.in.AuditDTO;
import com.tekton.technical_test.infrastructure.driver_adapter.postgres.entities.AuditEntity;

@Mapper
public interface AuditMapper {
    AuditEntity toEntity(AuditDTO audit);
}
