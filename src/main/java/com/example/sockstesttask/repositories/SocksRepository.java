package com.example.sockstesttask.repositories;

import com.example.sockstesttask.entities.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocksRepository extends JpaRepository<Socks, Long> {
    List<Socks> findSocksByColorAndCottonPart(String color, Short cottonPart);
    List<Socks> findSocksByColorAndAndCottonPartGreaterThan(String color, Short cottonPart);
    List<Socks> findSocksByColorAndAndCottonPartLessThan(String color, Short cottonPart);
}
