package com.tekton.technical_test.application.services.impl;

import org.springframework.stereotype.Service;

import com.tekton.technical_test.application.dtos.in.NumsDTO;
import com.tekton.technical_test.application.dtos.out.PercentageDTO;
import com.tekton.technical_test.application.dtos.out.ResultDTO;
import com.tekton.technical_test.application.ports.IPercentageService;
import com.tekton.technical_test.application.services.ICalculateService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class CalculateServiceImpl implements ICalculateService{
    private final IPercentageService percentageService;

    @Override
    public Mono<ResultDTO> calculatePercentage(NumsDTO numsDTO) {
        Mono<PercentageDTO> percentageDTOMono = percentageService.getPercentage();
        return percentageDTOMono.map(percentageDTO -> {
            Integer sum = numsDTO.getNum1() + numsDTO.getNum2();
            Double percentage = percentageDTO.getPercentage();
            Integer result = (int) Math.round((sum * percentage) / 100);
            log.info("Calculated result: {}", result);
            return ResultDTO.builder().result(result).build();
        });
    }

}
