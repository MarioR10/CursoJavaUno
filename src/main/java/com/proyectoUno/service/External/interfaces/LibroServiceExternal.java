package com.proyectoUno.service.External.interfaces;

import com.proyectoUno.dto.reponse.LibroResponseDTO;
import com.proyectoUno.dto.request.libro.LibroActualizarRequestDTO;
import com.proyectoUno.dto.request.libro.LibroCrearRequestDTO;

import java.util.List;
import java.util.UUID;

public interface LibroServiceExternal {

    //CRUD para Libro
    List<LibroResponseDTO> encontrarLibros ();
    LibroResponseDTO encontrarLibroPorId (UUID theid);
    void eliminarLibroPorId (UUID theid);
    LibroResponseDTO actualizarLibro(UUID id, LibroActualizarRequestDTO libroActualizar);
    void guardarLibro(LibroCrearRequestDTO libroCrearRequestDTO);

    //metodos adicionales

    List<LibroResponseDTO> encontrarLibroPorTitulo(String titulo);

    List<LibroResponseDTO> encontrarLibroPorAutor(String autor);

    List<LibroResponseDTO> encontrarLibroPorIsbn(String isbn);

    List<LibroResponseDTO> encontrarLibroPorCategoria(String categoria);

    List<LibroResponseDTO> encontrarLibroPorEstado(String estado);




}
