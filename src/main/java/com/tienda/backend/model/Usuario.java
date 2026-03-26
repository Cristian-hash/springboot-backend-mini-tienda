package com.tienda.backend.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    //“Un Usuario tiene exactamente un Carrito, y ese carrito le pertenece”.
    //“cascade-Lo que le pase al Usuario, también le pasa al Carrito”
    @OneToOne(cascade = CascadeType.ALL)
    private Carrito carrito;

    public Usuario() {}

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(Long id, String nombre, String email){
        this.id=id;
        this.nombre=nombre;
        this.email=email;
    }

    public void setCarrito(Carrito carrito){
        this.carrito=carrito;
    }

    public Carrito getCarrito(){
        return carrito;
    }
}