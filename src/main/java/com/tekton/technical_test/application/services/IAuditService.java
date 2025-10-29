package com.tekton.technical_test.application.services;

import reactor.core.publisher.Mono;

public interface IAuditService {
    Mono<Void> auditAction(Object payload, String endpoint, Object response);
}
