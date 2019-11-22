package com.lukebellamy.mariadb4j.service;

import com.lukebellamy.mariadb4j.entity.ExampleTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("integrationTest")
@SpringBootTest
class ExampleServiceTest {

    @Autowired
    private ExampleService exampleService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void shouldAddANewEntryToTable() {

        assertEquals(0, this.exampleService.getAll().size());

        ExampleTable exampleTable = ExampleTable
                .builder()
                .customerId(123L)
                .firstName("John")
                .lastName("Doe")
                .build();
        this.exampleService.addNew(exampleTable);

        assertEquals(1, this.exampleService.getAll().size());
    }

}