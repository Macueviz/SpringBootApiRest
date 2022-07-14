package com.prueba.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gadgets")
public class Gadgets {

    //Atributos
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String brand;
    private Integer size;
    private Double price;
    private Boolean online;

    //Constructores

    public Gadgets() {    }

    public Gadgets(Long id, String name, String brand, Integer size, Double price, Boolean online) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.online = online;
    }

    //Getter y Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
