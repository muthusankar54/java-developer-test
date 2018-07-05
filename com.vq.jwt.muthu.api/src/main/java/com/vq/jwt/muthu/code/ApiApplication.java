package com.vq.jwt.muthu.code;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.net.UnknownHostException;
@ComponentScan
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableAutoConfiguration
@EnableWebMvc
public class ApiApplication {

    public static void main(String [] args){

        SpringApplication.run(ApiApplication.class, args);
    }
}
