package com.proyectoUno.service.Internal.implementaciones;

import com.proyectoUno.entity.Libro;
import com.proyectoUno.exception.EntidadNoEncontradaException;
import com.proyectoUno.repository.LibroRepository;
import com.proyectoUno.service.Internal.interfaces.LibroServiceInternal;
import com.proyectoUno.service.validation.interfaces.LibroValidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LibroServiceInternalImpl implements LibroServiceInternal {

    private LibroRepository libroRepository;
    private LibroValidacionService libroValidacionService;

    @Autowired
    public LibroServiceInternalImpl(LibroRepository libroRepository, LibroValidacionService libroValidacionService){

        this.libroRepository=libroRepository;
        this.libroValidacionService=libroValidacionService;
    }

    @Override
    public List<Libro> encontrarLibros() {

        //Buscamos Libros en el repository
        List<Libro> librosEncontrados= libroRepository.findAll();

        //Llamamos la servicio de validaciones
        libroValidacionService.validarListaDeLibrosNoVacia(librosEncontrados);

        return librosEncontrados;
    }

    @Override
    public Libro encontrarLibroPorId(UUID id) {

        //Encontrar El Optional en la base de datos
        Optional<Libro> libroOptional = libroRepository.findById(id);

        //Validar si existe o no
        Libro libro = libroValidacionService.validarLibroExistencia(libroOptional);

        return libro;
    }

    @Override
    @Transactional
    public void eliminarLibroPorId(UUID id) {

        try {

            libroRepository.deleteById(id);

        } catch(EntidadNoEncontradaException e){

            throw new EntidadNoEncontradaException("Libro no encontrado, no puede ser eliminado");
        }

    }

    @Override
    @Transactional
    public Libro actualizarLibro(UUID id, Libro datosActualizacion) {

        //Obtenemos y validamos los campos de la entidad parcial (estos datos asignaremos a la entidad existente)
        libroValidacionService.validarDatosActualizacion(datosActualizacion);

        //Encontramos (buscamos) la entidad que si esta presente en la base de datos con todos sus campos
        Libro libroExistente= encontrarLibroPorId(id);

        //Actualizar la entidad existente con la entidad parcial
        libroExistente.setTitulo(datosActualizacion.getTitulo());
        libroExistente.setAutor(datosActualizacion.getAutor());
        libroExistente.setCategoria(datosActualizacion.getCategoria());
        libroExistente.setAnioDePublicacion(datosActualizacion.getAnioDePublicacion());


        return libroExistente;
    }

    @Override
    @Transactional
    public void guardarLibro(Libro libro) {

        //Guardamos el libro
        libroRepository.save(libro);

    }

    @Override
    public List<Libro> encontrarLibroPorTitulo(String titulo) {

        //Encontrar la lista de libros
        List <Libro> libros = libroRepository.findLibroByTituloContaining(titulo);

        //Validar la lista
        libroValidacionService.validarListaDeLibrosNoVacia(libros);

        return libros;
    }

    @Override
    public List<Libro> encontrarLibroPorAutor(String autor) {

        //Encontrar la lista de libros
        List <Libro> libros = libroRepository.findAllByAutorContaining(autor);

        //Validar la lista
        libroValidacionService.validarListaDeLibrosNoVacia(libros);

        return libros;
    }

    @Override
    public List<Libro> encontrarLibroPorIsbn(String isbn) {

        //Encontrar la lista de libros
        List<Libro> libros =libroRepository.findLibroByIsbn(isbn);

        //verificacion que exista libro
        libroValidacionService.validarListaDeLibrosNoVacia(libros);

        return libros;
    }

    @Override
    public List<Libro> encontrarLibroPorCategoria(String categoria) {

        //Encontrar la lista de libros
        List <Libro> libros = libroRepository.findLibroByCategoriaContaining(categoria);

        //Validamos la lista

        libroValidacionService.validarListaDeLibrosNoVacia(libros);

        return libros;

    }
    @Override
    public List<Libro> encontrarLibroPorEstado(String estado) {

        //Encontrar la lista de libros
        List <Libro> libros = libroRepository.findByEstado(estado);

        //Validamos la lista
        libroValidacionService.validarListaDeLibrosNoVacia(libros);

        return libros;
    }

    @Override
    @Transactional
    public void marcarLibroComoPrestado(Libro libro){

        //Asiganmos que el libro ha sido prestado
        libro.setEstado("reservado");

    }

    @Override
    @Transactional
    public void marcarLibroComoDisponible(Libro libro){

        //Asignamos disponible
        libro.setEstado("disponible");

    }
}
