package com.ceiba.usuario.excepcion;

public class ExcepcionUsuarioExistente  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionUsuarioExistente(String mensaje) {
        super(mensaje);
    }
}
