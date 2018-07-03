package com.vq.jwt.muthu.code.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("customuserdetails")
public class MongoConfiguration {

    @Bean
    public MongoClient createConnection() {
        return new MongoClient("172.17.0.2:27017");
    }
}