package com.lukebellamy.mariadb4j.service;

import com.lukebellamy.mariadb4j.entity.ExampleTable;
import com.lukebellamy.mariadb4j.repository.ExampleTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {

    private ExampleTableRepository exampleTableRepository;

    ExampleService(ExampleTableRepository exampleTableRepository) {
        this.exampleTableRepository = exampleTableRepository;
    }

    public List<ExampleTable> getAll() {
        return this.exampleTableRepository.findAll();
    }

    public void addNew(ExampleTable exampleTable) {
        this.exampleTableRepository.save(exampleTable);
    }

}
