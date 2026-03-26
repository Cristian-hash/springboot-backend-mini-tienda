package com.tienda.backend.service;

import com.tienda.backend.model.Carrito;
import com.tienda.backend.model.Usuario;
import com.tienda.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UserRepository usuarioRepository;

    public UsuarioService(UserRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario usuario) {
        Carrito carrito = new Carrito();
        usuario.setCarrito(carrito);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
}