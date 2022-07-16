package com.bootcampjava.Finalproject.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String dni = null;

    private Double amount = null;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AffiliationType affiliationType = null;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Customer customer = null;
}
