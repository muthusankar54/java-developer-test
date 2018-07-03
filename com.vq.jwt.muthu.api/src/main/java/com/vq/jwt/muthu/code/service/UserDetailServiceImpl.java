package com.vq.jwt.muthu.code.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.vq.jwt.muthu.code.domain.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl  implements UserDetailsService {

    @Autowired
    private MongoClient mongoClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Inside loadUser method");
        MongoDatabase database = mongoClient.getDatabase("springsecurity");
        MongoCollection<org.bson.Document> collection = database.getCollection("users");
        org.bson.Document document = collection.find(Filters.eq("email",email)).first();
        if(document!=null) {
            String userEmail = document.getString("userEmail");
            String password = document.getString("password");
            CustomUserDetails mongoUserDetails = new CustomUserDetails(userEmail,password);
            return mongoUserDetails;
        }
        return null;
    }

}


