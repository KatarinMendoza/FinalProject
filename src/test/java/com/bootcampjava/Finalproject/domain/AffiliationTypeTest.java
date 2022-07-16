package com.bootcampjava.Finalproject.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AffiliationTypeTest {

    AffiliationType affiliationType;
    @BeforeEach
    void iniciandoMetodo(){
        System.out.println("Iniciando Metodo");
        affiliationType = new AffiliationType(1L,"PRIMA");
    }

    @Test
    void testNombre() {

        String codigoEsperado= "2";
        Long codigoReal= affiliationType.getId();

        Assertions.assertEquals(codigoEsperado,codigoReal);
    }


}