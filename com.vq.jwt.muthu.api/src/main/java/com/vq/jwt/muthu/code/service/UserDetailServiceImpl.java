package com.vq.jwt.muthu.code.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.vq.jwt.muthu.code.domain.CustomUserDetails;
import com.vq.jwt.muthu.code.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class UserDetailServiceImpl  implements UserDetailsService {

//    @Autowired
//    private MongoClient mongoClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Inside loadUser method");
        Mongo mongo = new Mongo("localhost", 27017);
        DB db = mongo.getDB("auth");
        System.out.println("db==>"+db.getName());
        DBCollection collection = db.getCollection("users");
        System.out.println("collection==>"+collection.getFullName());
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("userEmail", email);
        System.out.println("searchQuery"+searchQuery.toJson());
        DBObject doc = collection.findOne();
        CustomUserDetails customUserDetails = new CustomUserDetails();
            String userEmail = email;
            String password = (String) doc.get("password");
            customUserDetails.setEmail(email);
            customUserDetails.setPassword(password);

        return customUserDetails;
    }

}


