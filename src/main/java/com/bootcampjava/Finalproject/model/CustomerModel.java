package com.bootcampjava.Finalproject.model;

import com.bootcampjava.Finalproject.domain.AffiliationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {

    @JsonProperty("customerID")
    @Builder.Default
    private Long id= null;

    @Builder.Default
    private String name = null;

    @Builder.Default
    private String surnames = null;

    @Builder.Default
    private Integer dni = null;

    @Builder.Default
    private Integer telephone = null;

    private String mail = null;

    private AffiliationTypeModel affiliationType = null;
}
