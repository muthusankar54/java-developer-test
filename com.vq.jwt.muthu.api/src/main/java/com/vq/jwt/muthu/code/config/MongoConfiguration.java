package com.vq.jwt.muthu.code.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

//
//@Configuration
//public class MongoConfiguration extends AbstractMongoConfiguration{
//
//    @Bean
//    public MongoClient createConnection() {
//        return new MongoClient("localhost:27017");
//    }
//
//    @Override
//    public MongoClient mongoClient() {
//        return new MongoClient("localhost", 27017);
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return "test";
//    }
//}