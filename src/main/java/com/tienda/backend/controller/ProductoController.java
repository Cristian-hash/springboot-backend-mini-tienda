package com.tienda.backend.controller;

import com.tienda.backend.model.Producto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

        @GetMapping("/productos")
        public List<Producto>getProductos(){
            return List.of(
                    new Producto(1,"Laptop",10.00),
                    new Producto(2,"Impresora",20.00),
                    new Producto(3,"Teclado",30.00)
            );

        }
}