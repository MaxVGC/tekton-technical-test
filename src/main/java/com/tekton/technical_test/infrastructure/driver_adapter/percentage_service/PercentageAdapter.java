package com.tekton.technical_test.infrastructure.driver_adapter.percentage_service;

import org.springframework.stereotype.Component;

import com.tekton.technical_test.application.dtos.out.PercentageDTO;
import com.tekton.technical_test.application.ports.IPercentageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Component
public class PercentageAdapter implements IPercentageService {
    @Override
    public Mono<PercentageDTO> getPercentage() {
        log.info("Getting percentage from Percentage Service");
        PercentageDTO percentageDTO = new PercentageDTO();
        percentageDTO.setPercentage(12.0);
        return Mono.just(percentageDTO);
    }

}
