package com.bootcampjava.Finalproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RequestsModel {
    @JsonProperty("requestsId")
    @Builder.Default
    private Long id = null;

    @Builder.Default
    private Integer dni = null;

    @Builder.Default
    private Double amount = null;

    @Builder.Default
    private AffiliationTypeModel affiliationType = null;

    @Builder.Default
    private CustomerModel customer = null;
}
