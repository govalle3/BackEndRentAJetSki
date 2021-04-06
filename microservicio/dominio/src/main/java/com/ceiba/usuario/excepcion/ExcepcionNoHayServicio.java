package com.ceiba.usuario.excepcion;

public class ExcepcionNoHayServicio extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionNoHayServicio(String mensaje) {
        super(mensaje);
    }
}
