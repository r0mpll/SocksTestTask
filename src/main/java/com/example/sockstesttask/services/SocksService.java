package com.example.sockstesttask.services;

import com.example.sockstesttask.exceptions.InvalidValuesException;
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

    public void income(Socks socks){
        if(socks.getQuantity()<=0){
            throw new InvalidValuesException("Quantity value must be a positive number");
        }
        if(socks.getCottonPart()<0 || socks.getCottonPart()>100){
            throw new InvalidValuesException("cottonPart value must be between 0 and 100");
        }
        if(socksRepository.findSocksByColorAndCottonPart(socks.getColor(), socks.getCottonPart()).isEmpty()){
            socksRepository.save(socks);
        } else{
            Socks existingSocks = socksRepository.findSocksByColorAndCottonPart(socks.getColor(), socks.getCottonPart()).get(0);
            existingSocks.setQuantity(existingSocks.getQuantity()+socks.getQuantity());
            socksRepository.save(existingSocks);
        }

    }

}
