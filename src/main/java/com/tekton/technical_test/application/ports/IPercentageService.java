package com.tekton.technical_test.application.ports;

import com.tekton.technical_test.application.dtos.out.PercentageDTO;

import reactor.core.publisher.Mono;

public interface IPercentageService {
    public Mono<PercentageDTO> getPercentage();
}
