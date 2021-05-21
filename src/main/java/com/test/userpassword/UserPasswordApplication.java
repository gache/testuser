package com.test.userpassword;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@PropertySources({@PropertySource(value = "classpath:application.properties"),
        @PropertySource(value = "classpath:datasource.properties", ignoreResourceNotFound = true)})
public class UserPasswordApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserPasswordApplication.class, args);
    }


}
