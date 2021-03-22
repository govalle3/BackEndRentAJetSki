package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Alquiler;

public interface RepositorioAlquiler {


    /**
     * Permite validar si el alquiler eligió minimo 10 minutos de alquiler
     * @param alquiler
     * @return si eligió minimo 10 minutos o no
     */
    boolean crearAlquiler(Alquiler alquiler);

    /**
     * Permite crear un pago
     * @param alquiler
     * @return un valor bool para mostrar mostrar mensaje en vista pagado
     */
    boolean crearPago(Alquiler alquiler);





}
