package com.nextgate.assesment;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * The entry point for our Spring Boot application
 * 
 * @author nextgate.employee
 */
@SpringBootApplication
public class AssesmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssesmentApplication.class, args);
//        System.out.println("Ran second");
    }


}
