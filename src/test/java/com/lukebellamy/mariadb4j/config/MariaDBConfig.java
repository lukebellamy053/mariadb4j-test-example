package com.lukebellamy.mariadb4j.config;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Profile("integrationTest")
@Configuration
public class MariaDBConfig {

    @Bean
    public CustomMariaDB4jSpringService mariaDB4jSpringService() {
        return new CustomMariaDB4jSpringService();
    }

    @Bean
    @Primary
    public DataSource dataSource(CustomMariaDB4jSpringService mariaDB4jSpringService) throws ManagedProcessException {
        //Create our database with default root user and no password
        mariaDB4jSpringService.getDB().createDB("exampledb");

        DBConfigurationBuilder config = mariaDB4jSpringService.getConfiguration();
        return DataSourceBuilder
                .create()
                .username("root")
                .password("password")
                .url(config.getURL("exampledb"))
                .driverClassName("org.mariadb.jdbc.Driver")
                .build();
    }
}
