package com.example.diffenvprofiles.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
@Getter
@Setter
public class DBConfiguration {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDatabaseConnection(){
        System.out.println("DB connection for DEV");
        System.out.println(driverClassName);
        System.out.println(url);

        return "DB connection for DEV";
    }

    @Profile("test")
    @Bean
    public String testDatabaseConnection(){
        System.out.println("DB connection for TEST");
        System.out.println(driverClassName);
        System.out.println(url);

        return "DB connection for TEST";

    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection(){
        System.out.println("DB connection for PROD");
        System.out.println(driverClassName);
        System.out.println(url);

        return "DB connection for PROD";

    }
}
