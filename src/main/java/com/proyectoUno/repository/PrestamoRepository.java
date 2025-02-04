package com.proyectoUno.repository;

import com.proyectoUno.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrestamoRepository extends JpaRepository<Prestamo, UUID> {

    //Ya vienen los CRUD basicos, si necesitamos metodos adicionales se agregan aqui
}


