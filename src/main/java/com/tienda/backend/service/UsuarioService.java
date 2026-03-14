package com.tienda.backend.service;

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