package com.bootcampjava.Finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AffiliationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id = null;

    private String name = null;
}
