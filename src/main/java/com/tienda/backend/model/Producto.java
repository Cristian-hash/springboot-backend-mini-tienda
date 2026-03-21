package com.tienda.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    public Producto() {
        // constructor vacío para Jackson
    }
    public Producto(Long id,String name,Double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public Long getId(){
        return id;
    }

    public Double getPrice(){
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
