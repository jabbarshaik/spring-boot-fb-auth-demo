package com.codewithjabbar.controller;


import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class BasicController {

    @GetMapping("/")
    public String home(Principal principal){

        Map<String, Object> authenticationDetails = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication().getDetails();

        String userName = (String) authenticationDetails.get("name");

        return "Hey  " + userName + " , Welcome to Spring OAuth ";
    }
}
