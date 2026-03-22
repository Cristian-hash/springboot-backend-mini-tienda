package com.tienda.backend.service;

import com.tienda.backend.model.Carrito;
import com.tienda.backend.model.Producto;
import com.tienda.backend.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;//id UNICO

@Service
public class CarritoService {
    private final CarritoRepository carritoRepository;
    public CarritoService(CarritoRepository carritoRepository){
        this.carritoRepository=carritoRepository;
    }

    public Carrito crearCarrito(){
        return carritoRepository.save(new Carrito());
    }

    public Carrito agregarProducto(Long carritoId,Producto producto){
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        if(carrito.getProductos().size()>5){
            throw new RuntimeException("exceso de productos");
        }

        carrito.agregarProductos();
        return carritoRepository.save(carrito);
    }

    public List<Producto> obtenerProductos(Long carritoId){
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        return carrito.getProductos();
    }



    public void vaciarCarrito(){
        carrito.clear();
    }

    public void eliminarProductoPorId(Long id) {
        carrito.forEach(p ->
                System.out.println("Producto en carrito ID: " + p.getId())
        );
        System.out.println("ID a eliminar: " + id);
        carrito.removeIf(p -> p.getId().equals(id));}

    public Carrito guardar(Carrito carrito){
       return carritoRepository.save(carrito);
    }

    public List<Carrito> obtenerTodos(){
        return carritoRepository.findAll();
    }

//METODOS QUE ESTA USANDO EL FRONT
    /* 1-
    public double calcularTotal() {
        double total = 0;
        for (Producto p : carrito) {
            total += p.getPrice();
        }
        return total;
    }
    */
}