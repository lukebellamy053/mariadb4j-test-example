package com.lukebellamy.mariadb4j.repository;

import com.lukebellamy.mariadb4j.entity.ExampleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleTableRepository extends JpaRepository<ExampleTable, Long> {
}
