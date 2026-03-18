package com.tienda.backend.service;

import com.tienda.backend.model.Carrito;
import com.tienda.backend.model.Producto;
import com.tienda.backend.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;//id UNICO

@Service
public class CarritoService {
    //2-Se guarda en una List<Producto>
    private List<Producto> carrito;
    private AtomicLong contador = new AtomicLong(1);//id UNICO
    private final CarritoRepository carritoRepository;

    public CarritoService(CarritoRepository carritoRepository){

        this.carritoRepository=carritoRepository;
        //1-El carrito vive en memoria
        this.carrito =new ArrayList<>();
    }
    //7-Service backend: decide si se puede agregar
    public void agregarProducto(Producto producto) {
        //8-Response: devuelve éxito o error.
        int MAX_ITEMS = 5;
        if(carrito.size()>=MAX_ITEMS){
            throw new RuntimeException("Maximo 5 productos");
        }
        producto.setId(contador.getAndIncrement());//id UNICO
        carrito.add(producto);
    }
    public double calcularTotal() {
        double total = 0;
        for (Producto p : carrito) {
            total += p.getPrice();
        }
        return total;
    }
    public List<Producto> obtenerProductos(){
        return carrito;
    }

    public void vaciarCarrito(){
        carrito.clear();
    }

    public void eliminarProductoPorId(Long id) {
        carrito.forEach(p ->
                System.out.println("Producto en carrito ID: " + p.getId())
        );
        System.out.println("ID a eliminar: " + id);
        carrito.removeIf(p -> p.getId().equals(id));}

    public Carrito guardar(Carrito carrito){
       return carritoRepository.save(carrito);
    }

    public List<Carrito> obtenerTodos(){
        return carritoRepository.findAll();
    }

}