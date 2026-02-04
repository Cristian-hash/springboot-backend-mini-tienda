package com.tienda.backend.controller;

import com.tienda.backend.model.Producto;
import com.tienda.backend.service.CarritoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarritoController {
    private CarritoService carritoService;

    public CarritoController(CarritoService carritoService){
        this.carritoService=carritoService;
    }

    @PostMapping("/carrito/productos")
    public void agregarProductoAlCarrito(@RequestBody Producto producto){
        carritoService.agregarProducto(producto);
    }

    @GetMapping("/carrito")
    public List<Producto> listarProductosDelCarrito(){
        return carritoService.obtenerProducto();
    }

    @DeleteMapping("/carrito")
    public void vaciarProductosDelCarrito(){
        carritoService.vaciarCarrito();
    }

    @DeleteMapping("/carrito/{id}")
    public void eliminarProductoUsandoId(@PathVariable Long id){
        carritoService.eliminarProductoPorId(id);
    }
}