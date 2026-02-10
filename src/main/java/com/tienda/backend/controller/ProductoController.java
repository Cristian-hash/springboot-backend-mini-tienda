package com.tienda.backend.controller;

import com.tienda.backend.model.Producto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductoController {

        @GetMapping("/productos")
        public List<Producto>getProductos(){
            return List.of(
                    new Producto(1L,"Laptop-probado",10.00),
                    new Producto(2L,"Impresora",20.00),
                    new Producto(3L,"Teclado",30.00)
            );
        }
}