package com.example.practice.OnlineTest.controller;

import org.springframework.http.MediaType;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class TestController {

//    @PreAuthorize("hasRole('ADMIN' and 'USER')")
//    @PreAuthorize("hasRole('ADMIN' or 'USER')")
//    @PreAuthorize("hasRole('ADMIN' || 'USER')")
//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public static void send(){

    }
}
