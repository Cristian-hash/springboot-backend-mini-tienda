package com.tienda.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrito {
    @Id
    @GeneratedValue ( strategy   = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();

    public Long getId(){
        return id;
    }
    public List <Producto> getProductos(){
        return productos;
    }

    public void agregarProducto(Producto producto){

        this.productos.add(producto);
    }

    public void vaciar(){

        this.productos.clear();
    }

    public void eliminarProducto(Long id){

        this.productos.removeIf(p -> p.getId().equals(id));
    }
}