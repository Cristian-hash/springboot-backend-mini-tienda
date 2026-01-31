package com.tienda.backend.controller;

import com.tienda.backend.model.Producto;
import com.tienda.backend.service.CarritoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
