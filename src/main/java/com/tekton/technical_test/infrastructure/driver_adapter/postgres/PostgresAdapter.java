package com.tekton.technical_test.infrastructure.driver_adapter.postgres;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.tekton.technical_test.application.dtos.in.AuditDTO;
import com.tekton.technical_test.application.ports.IAuditRepository;
import com.tekton.technical_test.infrastructure.driver_adapter.postgres.entities.AuditEntity;
import com.tekton.technical_test.infrastructure.driver_adapter.postgres.mappers.AuditMapper;
import com.tekton.technical_test.infrastructure.driver_adapter.postgres.repository.AuditRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Component
public class PostgresAdapter implements IAuditRepository {

    private final AuditRepository auditRepository;
    private final AuditMapper auditMapper = Mappers.getMapper(AuditMapper.class);

    @Override
    public Mono<Void> saveAudit(AuditDTO audit) {
        AuditEntity auditEntity = auditMapper.toEntity(audit);
        return Mono.fromCallable(() -> auditRepository.save(auditEntity))
                   .then();
    }

}
