package com.proyectoUno.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.ls.LSException;

import java.util.List;

public class SolicitudConDuplicadosException extends RuntimeException {

    //Loggers permiten registrar mensajes en consola, nos ayuda a la depuracion y monitoreo
    private final Logger logger = LoggerFactory.getLogger(SolicitudConDuplicadosException.class);

    //ID para saber el tipo de excepcion lanzada
    private final String internalCode = "SOLICITUD_CON_DUPLICADOS";

    //campos que proporciona detalles sobre la excepcion lanzada
    private  final String nombreCampo; //El campo duplicado
    private final List<String> valoresDuplicados; // valores del campo que estan duplciados en la lista de entrada;

    public SolicitudConDuplicadosException(String nombreCampo, List<String> valoresDuplicados){

        super(String.format("La solicitud tiene valores duplicados para el campo '%s': %s",nombreCampo,valoresDuplicados.toString()));
        this.nombreCampo=nombreCampo;
        this.valoresDuplicados=valoresDuplicados;

        //Registra la excepcion una vez lanzada
        logger.warn("La solicitud tiene valores duplicados para el campo {}: {}",nombreCampo,valoresDuplicados);

    }

    //getter para acceder a los detalles de la excepcion


    public String getInternalCode() {
        return internalCode;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public List<String> getValoresDuplicados() {
        return valoresDuplicados;
    }
}
