package com.bootcampjava.Finalproject.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AffiliationTypeModelTest {

    AffiliationTypeModel affiliationTypeModel;

    @BeforeEach
    void iniciandoMetodo(){
        System.out.println("Iniciando Metodo");
        affiliationTypeModel = new AffiliationTypeModel(1L,"HABITAT");
    }
    @Test
    void testDatos() {

        Assertions.assertNotNull(affiliationTypeModel.getName());
    }
}