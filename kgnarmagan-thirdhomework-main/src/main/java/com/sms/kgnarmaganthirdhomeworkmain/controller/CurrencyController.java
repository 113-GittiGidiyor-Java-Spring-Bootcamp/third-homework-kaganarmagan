package com.sms.kgnarmaganthirdhomeworkmain.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    //Specialized rest controll for currency change
    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/dollar/{lira}")// try to usd
    public ResponseEntity<String>changeTryToDollar(@PathVariable Double lira){
        String salary=restTemplate.getForObject("http://localhost:8081/api/dollar/"+lira.toString(),String.class);

        return new ResponseEntity<>(lira+" ₺ : "+salary+" $", HttpStatus.OK);
    }
    @GetMapping("/lira/{dollar}") //usd to try
    public ResponseEntity<String> changeDollarToTry(@PathVariable Double dollar){
        String salary=restTemplate.getForObject("http://localhost:8081/api/lira/"+dollar.toString(),String.class);
        return new ResponseEntity<>(dollar+" $ : "+salary+" ₺", HttpStatus.OK);// getting json as Salary object
    }
}
