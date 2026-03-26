package com.tienda.backend.service;

import com.tienda.backend.model.Carrito;
import com.tienda.backend.model.Producto;
import com.tienda.backend.model.Usuario;
import com.tienda.backend.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;//id UNICO
import com.tienda.backend.repository.UserRepository;
@Service
public class CarritoService {
    private final CarritoRepository carritoRepository;
    private final UserRepository userRepository;

    public CarritoService(CarritoRepository carritoRepository,UserRepository userRepository){
        this.carritoRepository=carritoRepository;
        this.userRepository=userRepository;
    }

    public Carrito crearCarrito(){
        return carritoRepository.save(new Carrito());
    }

    public Carrito agregarProducto(Long usuarioId,Producto producto){
        Usuario usuario = userRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Carrito carrito= usuario.getCarrito();

        if(carrito.getProductos().size()>5){
            throw new RuntimeException("exceso de productos");
        }

        carrito.agregarProductos(producto);
        return carritoRepository.save(carrito);
    }

    public List<Producto> obtenerProductos(Long carritoId){
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        return carrito.getProductos();
    }

    public void vaciarCarrito(Long carritoId){
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(()->new RuntimeException("Carrito no encontrado"));

        carrito.vaciar();
        carritoRepository.save(carrito);
    }

    public void eliminarProductoPorId(Long carritoId,Long ProductoId){
        Carrito carrito = carritoRepository.findById(carritoId)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        carrito.eliminarProducto(ProductoId);
        carritoRepository.save(carrito);
    }
}





//METODOS QUE ESTA USANDO EL FRONT
    /* 1-
    public double calcularTotal() {
        double total = 0;
        for (Producto p : carrito) {
            total += p.getPrice();
        }
        return total;
    }
    *2
    public void eliminarProductoPorId(Long id) {
    carrito.forEach(p ->
            System.out.println("Producto en carrito ID: " + p.getId())
    );
    System.out.println("ID a eliminar: " + id);
    carrito.removeIf(p -> p.getId().equals(id));}

    *3
    public Carrito guardar(Carrito carrito){
       return carritoRepository.save(carrito);
    }

    *4
    public List<Carrito> obtenerTodos(){
        return carritoRepository.findAll();
    }
    */
