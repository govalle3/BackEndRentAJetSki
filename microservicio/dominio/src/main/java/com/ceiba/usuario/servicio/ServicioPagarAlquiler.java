package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;

import java.time.Duration;
import java.time.LocalTime;

public class ServicioPagarAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;

    double multaMinuto = 0.8;

    public ServicioPagarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public double pagarAlquiler(Alquiler alquiler) {
        double valorMinuto = validarValorMinuto(alquiler);
        double totalMulta = calcularSiHayMultaYPagoParcial(alquiler, valorMinuto);
        double totalAPagar = sumaPagoParcialYPagoTotal(alquiler, valorMinuto, totalMulta);
        ejecutarPago(alquiler);
        return totalAPagar;

    }


    private double validarValorMinuto(Alquiler alquiler) {

        String idJetSki = alquiler.getIdJetSki();
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

    private double calcularSiHayMultaYPagoParcial(Alquiler alquiler, double valorMinuto) { // separar metodos en 2

        double totalMulta = 0;

        Integer tiempoRentado = alquiler.getRentTime();
        LocalTime fechaYHoraRentaUsuario = alquiler.getDateAndTimeRent().toLocalTime();
        LocalTime localTime = LocalTime.now();
        Integer duracion = Long.valueOf(Duration.between(fechaYHoraRentaUsuario, localTime).toMinutes()).intValue();

        if (duracion > tiempoRentado) {

            int minutosPasados = duracion - tiempoRentado;
            totalMulta = minutosPasados * multaMinuto * valorMinuto;
        }

        return totalMulta;
    }

    private double sumaPagoParcialYPagoTotal(Alquiler alquiler, double valorMinuto, double totalMulta){

        double totalAPagar = 0;
        double totalParcial = 0;
        Integer tiempoRentado = alquiler.getRentTime();
        totalParcial = valorMinuto * tiempoRentado;
        totalAPagar = totalParcial + totalMulta;
        return totalAPagar;
    }

    private boolean ejecutarPago(Alquiler alquiler) {
        return repositorioAlquiler.crearPago(alquiler);
    }

}
