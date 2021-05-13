package com.test.userpassword;

import com.test.userpassword.models.Compliance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@PropertySources({@PropertySource(value = "classpath:application.properties"),
        @PropertySource(value = "classpath:datasource.properties", ignoreResourceNotFound = true)})
public class UserPasswordApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserPasswordApplication.class, args);
    }


}
