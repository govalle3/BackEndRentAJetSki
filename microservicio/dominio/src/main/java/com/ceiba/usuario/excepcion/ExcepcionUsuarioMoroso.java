package com.ceiba.usuario.excepcion;

public class ExcepcionUsuarioMoroso extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionUsuarioMoroso(String mensaje) {
        super(mensaje);
    }
}
