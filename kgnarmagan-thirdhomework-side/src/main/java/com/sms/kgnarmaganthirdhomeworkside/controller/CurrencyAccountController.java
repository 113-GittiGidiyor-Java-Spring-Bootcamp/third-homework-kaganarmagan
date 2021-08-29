package com.sms.kgnarmaganthirdhomeworkside.controller;

import com.sms.kgnarmaganthirdhomeworkside.currency.CurrencyConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurrencyAccountController {

    @GetMapping("/dollar/{lira}")
    public ResponseEntity<String> changeTryToDollar(@PathVariable double lira){
        String response = ""+(lira * CurrencyConfig.LIRA.getCost());
        return new ResponseEntity<>(response, HttpStatus.OK );
    }
    @GetMapping("/lira/{dollar}")
    public ResponseEntity<String> changeDollarToTry(@PathVariable double dollar){
        String response = ""+(dollar * CurrencyConfig.DOLLAR.getCost());
        return new ResponseEntity<>(response, HttpStatus.OK );
    }
}
