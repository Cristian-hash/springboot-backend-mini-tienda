package com.tienda.backend.service;

import com.tienda.backend.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class CarritoService {
    private List<Producto> carrito;

    public CarritoService(){
        this.carrito =new ArrayList<>;
    }

    public void agregar(Producto producto) {
        carrito.add(producto);
    }
}
