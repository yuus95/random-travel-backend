package com.yscp.randomtravel.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VworldServiceTest {

    @Autowired
    private VworldService vworldService;


    @Test
    void getSiGungu() {
        vworldService.getSiGungu();
    }
}
