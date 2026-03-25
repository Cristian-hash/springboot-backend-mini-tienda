package com.tienda.backend.controller;

import com.tienda.backend.model.Usuario;
import com.tienda.backend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="http://localhost:4200")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {

        return service.crearUsuario(usuario);
    }

    @GetMapping
    public List<Usuario>listar(){
        return service.listar();
    }
}