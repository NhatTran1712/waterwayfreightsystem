package org.apptopia.waterwayfreightsystem.api.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
 
@SpringBootApplication
@ComponentScan(basePackages = "org.apptopia.waterwayfreightsystem.api.api")
public class WaterwayFreightSystemApp {
 
    public static void main(String[] args) {
        SpringApplication.run(WaterwayFreightSystemApp.class, args);
    }
}