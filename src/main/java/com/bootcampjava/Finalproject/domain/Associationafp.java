package com.bootcampjava.Finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Associationafp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String dni = null;

    private Double amountAvailable = null;

    private Timestamp DateWithdrawal = null;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Customer customer = null;



}
