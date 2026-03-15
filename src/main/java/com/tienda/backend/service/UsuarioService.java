package com.tienda.backend.service;

import com.tienda.backend.model.Usuario;
import com.tienda.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UserRepository repo;

    public UsuarioService(UserRepository repo) {
        this.repo = repo;
    }

    public Usuario crear(Usuario u) {
        return repo.save(u);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }
}