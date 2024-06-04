package com.example.practice.controller;


import com.example.practice.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/users")
public class RestTemplateController {


    @GetMapping
    public void send() throws URISyntaxException {
        UserDTO user = new UserDTO();
        user.setId(1L);
        user.setName("Md Rana");
        user.setLastName("Rana");


        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("http://localhost:8081/users/");


        ResponseEntity<UserDTO> result = restTemplate.postForEntity(uri, user, UserDTO.class);
        System.out.println(result);
//        Assertions.assertEquals(201, result.getStatusCodeValue());
//        Assertions.assertNotNull(result.getBody().getId());

    }
}
