package com.proyectoUno.service.Internal.interfaces;

import com.proyectoUno.entity.Libro;
import com.proyectoUno.entity.Prestamo;
import com.proyectoUno.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface PrestamoServiceIternal {

    //Metodos actuales
    void crearPrestamo(Libro libro, Usuario usuario);
    List<Prestamo> encontrarPrestamosActivosPorIdUsuario(UUID id);
    Prestamo encontrarPrestamoPorId(UUID id);
    List<Prestamo> encontrarPrestamosPorIdUsuario(UUID id);
    void marcarPrestamoComoDevuelto(Prestamo prestamo);

    //metodos paginados

    Page<Prestamo> encontrarPrestamos(Pageable pageable);
    Page<Prestamo> encontrarPrestamosPorIdUsuario(UUID id, Pageable pageable);
    Page<Prestamo> encontrarPrestamosActivosPorIdUsuario(UUID id, Pageable pageable);
    Page<Prestamo> encontrarPrestamosActivos(Pageable pageable);

}
