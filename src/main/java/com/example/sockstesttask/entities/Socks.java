package com.example.sockstesttask.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    private Long quantity;

    private Short cottonPart;

    public Socks(String color, Long quantity, Short cottonPart) {
        this.color = color;
        this.quantity = quantity;
        this.cottonPart = cottonPart;
    }

    public Socks() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Short getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(Short cottonPart) {
        this.cottonPart = cottonPart;
    }
}
