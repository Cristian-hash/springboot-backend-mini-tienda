package com.tienda.backend.controller;

import com.tienda.backend.model.Producto;
import com.tienda.backend.service.CarritoService;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@RequestMapping("/carrito")
@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class CarritoController {
    private CarritoService carritoService;

    public CarritoController(CarritoService carritoService){
        this.carritoService=carritoService;
    }
    //6-Controller: recibe y enruta
    @PostMapping("/productos")
    public void agregarProductoAlCarrito(@RequestBody Producto producto){
        carritoService.agregarProducto(producto);
    }

    @GetMapping
    public List<Producto> listarProductosDelCarrito(){
        return carritoService.obtenerProducto();}

    @DeleteMapping
    public void vaciarProductosDelCarrito(){
        carritoService.vaciarCarrito();
    }

    @DeleteMapping("/{id}")
    public void eliminarProductoUsandoId(@PathVariable Long id){
        carritoService.eliminarProductoPorId(id);
    }
    @GetMapping("/total")
    public double obtenerTotal() {
        return carritoService.calcularTotal();
    }
}