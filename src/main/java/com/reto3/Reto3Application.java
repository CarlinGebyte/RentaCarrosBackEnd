package com.reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author CarlinGebyte
 */
@EntityScan(basePackages = {"com.reto3.modelo"})
@SpringBootApplication
public class Reto3Application {

    /**
     * Método main
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Reto3Application.class, args);
    }

}
