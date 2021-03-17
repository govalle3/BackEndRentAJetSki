package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import java.time.Duration;
import java.time.LocalTime;

public class ServicioPagarAlquiler {

    private final RepositorioUsuario repositorioUsuario;
    double multaMinuto = 0.8;

    public ServicioPagarAlquiler(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public double pagarAlquiler(Usuario usuario) {

        //this.repositorioUsuario.pagarAlquiler(usuario)
        return calcularSiHayMultaYTotal(usuario, validarValorMinuto(usuario));
    }

    private double validarValorMinuto(Usuario usuario) {

        String idJetSki = usuario.getIdJetSki();
        double valorMinuto = 0;

        if (idJetSki.toString() == "BC01") {
            valorMinuto = 5000;
        }
        if (idJetSki.toString() == "BC02") {
            valorMinuto = 7000;
        }
        if (idJetSki.toString() == "BC03") {
            valorMinuto = 9000;
        }
        return valorMinuto;
    }

    private double calcularSiHayMultaYTotal(Usuario usuario, double valorMinuto) { // separar metodos en 2

        double totalAPagar = 0;
        double totalParcial = 0;
        double totalMulta = 0;

        Integer tiempoRentado = usuario.getRentTime();
        LocalTime fechaYHoraRentaUsuario = usuario.getDateAndTimeRent().toLocalTime();
        LocalTime localTime = LocalTime.now();
        Integer duracion = Long.valueOf(Duration.between(fechaYHoraRentaUsuario, localTime).toMinutes()).intValue();

        if (duracion > tiempoRentado) {

            int minutosPasados = duracion - tiempoRentado;
            totalMulta = minutosPasados * multaMinuto * valorMinuto;
        }
        totalParcial = valorMinuto * tiempoRentado;
        totalAPagar = totalParcial + totalMulta;
        return totalAPagar;
    }

}
