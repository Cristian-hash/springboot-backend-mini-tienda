package com.tienda.backend.service;

import com.tienda.backend.model.Carrito;
import com.tienda.backend.model.Usuario;
import com.tienda.backend.repository.UsuarioRepository;
import com.tienda.backend.security.JwtService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    public UsuarioService(UsuarioRepository usuarioRepository,JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService =  jwtService;
    }



    public Usuario crearUsuario(Usuario usuario) {
        Carrito carrito = new Carrito();
        usuario.setCarrito(carrito);
        return usuarioRepository.save(usuario);
    }


    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public String login(String email){
         Usuario usuario =usuarioRepository.findAll().stream()
                .filter(u ->u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
         return jwtService.generarToken(usuario.getEmail());
    }
}