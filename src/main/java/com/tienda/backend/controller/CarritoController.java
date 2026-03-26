package com.tienda.backend.controller;

import com.tienda.backend.model.Carrito;
import com.tienda.backend.model.Producto;
import com.tienda.backend.service.CarritoService;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


//EXPLICACION DE LOS CORS ,EXITE EN EL DIA 5 DE CORS.
@RestController
@RequestMapping("/carrito")
@CrossOrigin(origins = "http://localhost:4200")

public class CarritoController {
    private CarritoService carritoService;

    public CarritoController(CarritoService carritoService){
        this.carritoService=carritoService;
    }
    //6-Controller: recibe y enruta
    @PostMapping
    public Carrito crearCarrito(){
        return carritoService.crearCarrito();
    }

    @PostMapping("/{id}/productos")
    public Carrito agregarProductoAlCarrito(@PathVariable Long id,@RequestBody Producto producto){
        return carritoService.agregarProducto(id,producto);
    }

    @GetMapping("/{id}")
    public List<Producto> listarProductosDelCarrito(@PathVariable Long id){
        return carritoService.obtenerProductos(id);
    }

    @DeleteMapping("/{id}")
    public void vaciarProductosDelCarrito(@PathVariable Long id){
        carritoService.vaciarCarrito(id);
    }

    @DeleteMapping("/{id}/producto/{productoId}")
    public void eliminarProducto(@PathVariable Long id,@PathVariable Long productoId ){
        carritoService.eliminarProductoPorId(id,productoId);
    }
}

/*
@GetMapping("/total")
public double obtenerTotal() {
    return carritoService.calcularTotal();
}*/
