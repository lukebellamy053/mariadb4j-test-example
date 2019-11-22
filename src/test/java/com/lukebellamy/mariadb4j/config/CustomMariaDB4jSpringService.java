package com.lukebellamy.mariadb4j.config;

import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;

public class CustomMariaDB4jSpringService extends MariaDB4jSpringService {

    @Override
    public void start() {
        getConfiguration().addArg("--user=root");
        super.start();
    }

}
