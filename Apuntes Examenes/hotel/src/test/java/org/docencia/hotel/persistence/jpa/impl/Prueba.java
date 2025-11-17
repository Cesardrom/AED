package org.docencia.hotel.persistence.jpa.impl;

import java.sql.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Prueba {
    private Date date1;
    private Date date2;

    @Test 
    void fechaTest(){
        date1= java.sql.Date.valueOf("2025-09-11");
        date2= java.sql.Date.valueOf("2025-09-11");
        System.out.println(date1);
        Assertions.assertEquals(date1 ,date2);
    }
}