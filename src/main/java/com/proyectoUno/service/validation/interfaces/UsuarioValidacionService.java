package com.proyectoUno.service.validation.interfaces;

import com.proyectoUno.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioValidacionService {

    void validarListaDeUsuariossNoVacia(List<Usuario> usuarios);

    Usuario validarUsuarioExistencia(Optional<Usuario>usuario);

    void validarDatosActualizacion(Usuario datosActualizacion);

    void validarDuplicadosListaEntrada( List<String> emailsNuevos);
    void validarDuplicadosBaseDeDatos(List<Usuario> usuarios);




}
