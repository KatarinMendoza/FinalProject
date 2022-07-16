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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id= null;

    private String name = null;

    private String surnames = null;

    private String dni = null;

    private Integer telephone = null;

    private String mail = null;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AffiliationType affiliationType = null;
}
