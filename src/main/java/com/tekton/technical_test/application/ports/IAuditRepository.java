package com.tekton.technical_test.application.ports;

import com.tekton.technical_test.application.dtos.in.AuditDTO;

import reactor.core.publisher.Mono;

public interface IAuditRepository {
    Mono<Void> saveAudit(AuditDTO audit);
}
