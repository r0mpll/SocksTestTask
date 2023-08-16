package com.example.sockstesttask.controllers;


import com.example.sockstesttask.services.SocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/socks")
public class SocksController {

    private final SocksService socksService;
    @Autowired
    public SocksController(SocksService socksService){
        this.socksService=socksService;
    }

    @GetMapping
    public ResponseEntity<Long> getSocksQuantity(@RequestParam String color, @RequestParam String operation, @RequestParam Short cottonPart){
            return new ResponseEntity<>(socksService.getSocksQuantity(color,operation,cottonPart), HttpStatus.OK);
    }
}
