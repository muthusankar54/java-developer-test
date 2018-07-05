package com.vq.jwt.muthu.code.controller;

import com.vq.jwt.muthu.code.domain.CustomUserDetails;
import com.vq.jwt.muthu.code.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AuthenticationController {

    @RequestMapping(value = "/api/v1/auth", method = RequestMethod.GET)
    @ResponseBody
    //@RequestBody CustomUserDetails customUserDetails
    public String authenticationCheck(){
     System.out.println("test controller called==>");
        return "Hello Muthu";

    }


}
