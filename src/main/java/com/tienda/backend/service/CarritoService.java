package com.tienda.backend.service;

import com.tienda.backend.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarritoService {
    private List<Producto> carrito;

    public CarritoService(){
        this.carrito =new ArrayList();
    }

    public void agregarProducto(Producto producto) {
        if(carrito.size()>=10){
            throw new RuntimeException("Maximo 3 productos");
        }
        // para duplicados
        // for (Producto p : carrito) {
        //  if (p.getId() == producto.getId()) return;
        // }
        carrito.add(producto);
    }
    public double calcularTotal() {
        double total = 0;
        for (Producto p : carrito) {
            total += p.getPrice();
        }
        return total;
    }
    public List<Producto> obtenerProducto(){
        return carrito;
    }

    public void vaciarCarrito(){
        carrito.clear();
    }

    public void eliminarProductoPorId(Long id) { carrito.removeIf(p -> p.getId().equals(id));}
}