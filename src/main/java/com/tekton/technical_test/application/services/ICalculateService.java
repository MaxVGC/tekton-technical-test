package com.tekton.technical_test.application.services;

import com.tekton.technical_test.application.dtos.in.NumsDTO;
import com.tekton.technical_test.application.dtos.out.ResultDTO;

import reactor.core.publisher.Mono;

public interface ICalculateService {
    public Mono<ResultDTO> calculatePercentage(NumsDTO numsDTO);
}
