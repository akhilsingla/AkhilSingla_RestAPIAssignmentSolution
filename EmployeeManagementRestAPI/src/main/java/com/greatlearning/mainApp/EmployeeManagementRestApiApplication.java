package com.greatlearning.mainApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.greatlearning.entity"})
@EnableJpaRepositories(basePackages = "com.greatlearning.dao")
@SpringBootApplication(scanBasePackages = {"com.greatlearning.*"})
public class EmployeeManagementRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementRestApiApplication.class, args);
    }

}
