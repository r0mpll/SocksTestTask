package com.example.sockstesttask.controllers;


import com.example.sockstesttask.entities.Socks;
import com.example.sockstesttask.services.SocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("income")
    public ResponseEntity<String> setIncome(@RequestBody Socks socks){
        socksService.income(socks);
        return new ResponseEntity<>("Socks were added",HttpStatus.OK);
    }

}
