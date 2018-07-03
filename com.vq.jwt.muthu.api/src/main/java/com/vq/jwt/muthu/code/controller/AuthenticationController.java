package com.vq.jwt.muthu.code.controller;

import com.vq.jwt.muthu.code.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class AuthenticationController {

    @RequestMapping(value = "api/v1/auth", method = RequestMethod.GET)
    @ResponseBody
    public String authenticationCheck(){

        return "HelloWorld Muthu";

    }


}
