package com.ceiba.usuario.excepcion;

public class ExcepcionUsuarioMenorDeEdad extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionUsuarioMenorDeEdad(String mensaje) {
        super(mensaje);
    }
}
