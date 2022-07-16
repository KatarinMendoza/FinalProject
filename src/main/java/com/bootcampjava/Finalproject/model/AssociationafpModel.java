package com.bootcampjava.Finalproject.model;

import com.bootcampjava.Finalproject.domain.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssociationafpModel {

    @JsonProperty("associationafpId")
    @Builder.Default
    private Long id = null;

    @Builder.Default
    private Integer dni = null;

    @Builder.Default
    private Double amountAvailable = null;

    @JsonProperty("Date")
    @Builder.Default
    private Timestamp DateWithdrawal = null;

    @Builder.Default
    private CustomerModel customer = null;
}
