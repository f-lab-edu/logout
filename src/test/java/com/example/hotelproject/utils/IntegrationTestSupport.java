package com.example.hotelproject.utils;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IntegrationTestSupport {

    @Autowired
    private DatabaseCleanup databaseCleanup;

    @BeforeEach
    public void cleanUp() {
        databaseCleanup.execute();
    }
}