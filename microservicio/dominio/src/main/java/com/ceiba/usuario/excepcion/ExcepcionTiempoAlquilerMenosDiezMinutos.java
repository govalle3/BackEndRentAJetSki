package com.ceiba.usuario.excepcion;

public class ExcepcionTiempoAlquilerMenosDiezMinutos extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionTiempoAlquilerMenosDiezMinutos(String mensaje) {
        super(mensaje);
    }
}
