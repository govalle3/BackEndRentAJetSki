package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;

public class ServicioPagarAlquiler {

    private final RepositorioRentAJetSki repositorioRentAJetSki;

    public ServicioPagarAlquiler(RepositorioRentAJetSki repositorioRentAJetSki) {
        this.repositorioRentAJetSki = repositorioRentAJetSki;
    }

    public void pagarAlquiler(Alquiler alquiler) {
        this.repositorioRentAJetSki.pagarAlquiler(alquiler);
    }

}
