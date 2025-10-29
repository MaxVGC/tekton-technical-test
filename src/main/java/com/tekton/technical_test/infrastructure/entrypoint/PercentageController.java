package com.tekton.technical_test.infrastructure.entrypoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekton.technical_test.application.dtos.in.NumsDTO;
import com.tekton.technical_test.application.dtos.out.ResultDTO;
import com.tekton.technical_test.application.services.IAuditService;
import com.tekton.technical_test.application.services.ICalculateService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/calculator")
@RequiredArgsConstructor
public class PercentageController {
    private final ICalculateService calculateService;
    private final IAuditService auditService;

    @PostMapping("/sum-and-apply-percentage")
    public Mono<ResultDTO> sumApplyPercentage(@RequestBody @Valid NumsDTO numsDTO) {
        return calculateService.calculatePercentage(numsDTO).map(
                result -> {
                    auditService
                            .auditAction(numsDTO, "/api/v1/calculator/sum-and-apply-percentage", result)
                            .subscribeOn(Schedulers.boundedElastic())
                            .subscribe();
                    return result;
                });
    }

}
