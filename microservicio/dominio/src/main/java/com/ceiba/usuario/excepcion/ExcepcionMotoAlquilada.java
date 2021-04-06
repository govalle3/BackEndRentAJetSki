package com.ceiba.usuario.excepcion;

public class ExcepcionMotoAlquilada extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionMotoAlquilada(String mensaje) {
        super(mensaje);
    }
}
