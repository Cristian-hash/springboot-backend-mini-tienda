package com.tienda.backend.controller;

import com.tienda.backend.dto.LoginRequest;
import com.tienda.backend.model.Usuario;
import com.tienda.backend.service.UsuarioService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {

        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping
    public List<Usuario>listar(){
        return usuarioService.listar();
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return usuarioService.login(request.getEmail());
    }

    @GetMapping("/perfil")
    public String perfil(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}