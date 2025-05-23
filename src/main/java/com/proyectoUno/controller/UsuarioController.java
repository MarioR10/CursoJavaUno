package com.proyectoUno.controller;

import com.proyectoUno.dto.reponse.UsuarioResponseDTO;
import com.proyectoUno.dto.request.usuario.UsuarioActualizarDTO;
import com.proyectoUno.dto.request.usuario.UsuarioCrearRequestDTO;
import com.proyectoUno.service.External.interfaces.UsuarioServiceExternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServiceExternal usuarioServiceExternal;

    @Autowired
    public UsuarioController(UsuarioServiceExternal usuarioServiceExternal){

        this.usuarioServiceExternal=usuarioServiceExternal;
    }



    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuarioPorId(@PathVariable UUID id){
        UsuarioResponseDTO usuario= usuarioServiceExternal.encontrarUsuarioPorId(id);
        return  ResponseEntity.ok(usuario);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarUsuarioPorId(@PathVariable UUID id){
        usuarioServiceExternal.eliminarUsuarioPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> actualizarUsuario(@PathVariable UUID id, @Valid @RequestBody UsuarioActualizarDTO request){
        UsuarioResponseDTO usuarioActualizado = usuarioServiceExternal.actualizarUsuario(id,request);
        return  ResponseEntity.ok(usuarioActualizado);

    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void crearUsuario(@Valid @RequestBody List<UsuarioCrearRequestDTO> requests){
        usuarioServiceExternal.crearUsuario(requests);
    }

    @GetMapping()
    public ResponseEntity<Page< UsuarioResponseDTO>> encontrarUsuarios(
            @PageableDefault(page = 0, size = 8) Pageable pageable
            ){

         Page<UsuarioResponseDTO> usuarios = usuarioServiceExternal.encontrarUsuarios(pageable);
         return  ResponseEntity.ok(usuarios);

    }

}
