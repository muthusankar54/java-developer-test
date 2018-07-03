package com.vq.jwt.muthu.code;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.net.UnknownHostException;

@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class ApiApplication {

    public static void main(String [] args){

        SpringApplication.run(ApiApplication.class, args);
    }
}
