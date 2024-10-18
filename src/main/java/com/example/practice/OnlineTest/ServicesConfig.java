//package com.example.practice.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Service;
//
////@Service
//@Configuration
//public class ServicesConfig {
//
//    @Autowired
//    @Qualifier("validatorShort")
//    private UsernameValidator validatorShort = new UsernameValidator(3);
//
//    @Autowired
//    @Qualifier("validatorLong")
//    private UsernameValidator validatorLong = new UsernameValidator(8);
//
//    public ServicesConfig(UsernameValidator validatorShort, UsernameValidator validatorLong) {
//        this.validatorShort = validatorShort;
//        this.validatorLong = validatorLong;
//    }
//}
//
//
//
////@Service
//@Service("validatorLong")
//class UsernameValidator {
//
//
//    private int minLength;
//
//    public UsernameValidator() {
//    }
//
//    public UsernameValidator(int minLength) {
//        this.minLength = minLength;
//    }
//
//    public boolean isUsernameValid(String username) {
//        return username.length() >= minLength;
//    }
//}
