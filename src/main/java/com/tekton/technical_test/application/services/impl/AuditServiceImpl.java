package com.tekton.technical_test.application.services.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.tekton.technical_test.application.dtos.in.AuditDTO;
import com.tekton.technical_test.application.ports.IAuditRepository;
import com.tekton.technical_test.application.services.IAuditService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuditServiceImpl implements IAuditService {

    private final IAuditRepository auditRepository;

    @Override
    public Mono<Void> auditAction(Object payload, String endpoint, Object response) {
        String payloadJson = new Gson().toJson(payload);
        String responseJson = new Gson().toJson(response);
        AuditDTO auditDTO = AuditDTO.builder()
                .timestamp(new Date())
                .endpoint(endpoint)
                .payload(payloadJson)
                .response(responseJson)
                .build();
        return auditRepository.saveAudit(auditDTO);
    }

}
