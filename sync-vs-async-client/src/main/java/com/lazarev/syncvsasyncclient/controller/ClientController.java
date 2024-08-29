package com.lazarev.syncvsasyncclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @GetMapping
    public String getTestString() {
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject("http://localhost:8080/api/test", String.class);
        //logic
        result = result.toUpperCase();

        return result;
    }
}
