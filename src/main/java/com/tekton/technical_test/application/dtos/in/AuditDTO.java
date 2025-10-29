package com.tekton.technical_test.application.dtos.in;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditDTO {
    private Date timestamp;
    private String endpoint;
    private String payload;
    private String response;
}
