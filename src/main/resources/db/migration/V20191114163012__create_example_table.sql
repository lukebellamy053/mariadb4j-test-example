CREATE DATABASE IF NOT EXISTS exampledb;

CREATE TABLE `example_table`
(
    `customer_id` INT AUTO_INCREMENT,
    `first_name`  varchar(50) NOT NULL,
    `last_name`   VARCHAR(50) NOT NULL,
    PRIMARY KEY (`customer_id`)
);
