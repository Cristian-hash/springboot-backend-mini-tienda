package com.tienda.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda.backend.model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito,Long> {
}
