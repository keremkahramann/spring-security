package com.security.BasicAuth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping
    public String helloWorldPriv(){
        return "Hello from Private";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String helloWorldUserPriv(){
        return "hello from user private";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String helloWorldAdminPriv(){
        return "hello from admin private";
    }
}
