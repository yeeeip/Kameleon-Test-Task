package com.nuzhd.techtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Security is used only for the Password Encoder Bean and is excluded
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class TechTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechTaskApplication.class, args);
    }

}
