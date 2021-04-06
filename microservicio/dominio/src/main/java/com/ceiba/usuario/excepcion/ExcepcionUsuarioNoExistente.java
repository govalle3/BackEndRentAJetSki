package com.ceiba.usuario.excepcion;

public class ExcepcionUsuarioNoExistente extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionUsuarioNoExistente(String mensaje) {
        super(mensaje);
    }
}
