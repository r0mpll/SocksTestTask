package com.example.sockstesttask.services;

import com.example.sockstesttask.exceptions.UnknownOperationException;
import com.example.sockstesttask.entities.Socks;
import com.example.sockstesttask.repositories.SocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocksService {
    private final SocksRepository socksRepository;
    @Autowired
    public SocksService(SocksRepository socksRepository){
        this.socksRepository=socksRepository;
    }
    private Long getSum(List<Socks> socksList){
        Long quantity=0L;
        for(Socks s: socksList){
            quantity+=s.getQuantity();
        }
        return quantity;
    }
    public Long getSocksQuantity(String color, String operation, Short cottonPart){
        switch (operation){
            case "moreThan":
                return getSum(socksRepository.findSocksByColorAndAndCottonPartGreaterThan(color,cottonPart));
            case "lessThan":
                return getSum(socksRepository.findSocksByColorAndAndCottonPartLessThan(color,cottonPart));
            case "equals":
                return getSum(socksRepository.findSocksByColorAndCottonPart(color,cottonPart));
            default:
                throw new UnknownOperationException("Unknown operation: "+operation);
        }
    }

}
