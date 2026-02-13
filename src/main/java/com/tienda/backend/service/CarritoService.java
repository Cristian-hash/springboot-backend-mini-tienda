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

        //para duplicados
        //for (Producto p : carrito) {
          //  if (p.getId() == producto.getId()) return;
        //}
        carrito.add(producto);

    }
    public List<Producto> obtenerProducto(){
        return carrito;
    }

    public void vaciarCarrito(){
        carrito.clear();
    }

    public void eliminarProductoPorId(Long id) { carrito.removeIf(p -> p.getId().equals(id));}
}