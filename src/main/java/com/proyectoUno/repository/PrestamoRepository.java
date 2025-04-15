package com.proyectoUno.repository;

import com.proyectoUno.entity.Prestamo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PrestamoRepository extends JpaRepository<Prestamo, UUID> {


    // Metodo para encontrar los préstamos activos por usuario
    List<Prestamo> findPrestamoByUsuarioIdAndEstado(UUID theid, String estado);

    // Metodo para encontrar el histórico de préstamos de un usuario
    List<Prestamo> findByUsuarioId(UUID usuarioId);

    // Metodo para encontrar préstamos activos
    List<Prestamo> findByEstado(String estado);



    //Metodos paginados
    Page<Prestamo> findAll(Pageable pageable);
    Page<Prestamo> findPrestamoByUsuarioIdAndEstado(UUID usuarioId, String estado, Pageable pageable);
    Page<Prestamo> findByUsuarioId( UUID id, Pageable pageable);
    Page<Prestamo> findByEstado( String estado, Pageable pageable);
}
