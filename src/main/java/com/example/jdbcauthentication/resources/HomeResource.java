package com.example.jdbcauthentication.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeResource {



    @GetMapping()
    public String getWelcomeMessage(){
        return "Hello World";
    }

    @GetMapping("/user")
    public String getGreeting(){
        return "Hello User";
    }

    @GetMapping("/admin")
    public String adminWelcomeMessage(){
        return "Hello Admin Welcome.....";
    }
}
