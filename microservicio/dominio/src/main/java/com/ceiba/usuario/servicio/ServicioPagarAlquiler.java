package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;

import java.time.Duration;
import java.time.LocalTime;

public class ServicioPagarAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;

    double multaMinuto = 1.2;

    public ServicioPagarAlquiler(RepositorioAlquiler repositorioAlquiler) {

        this.repositorioAlquiler = repositorioAlquiler;

    }

    public double pagarAlquiler(DtoAlquiler dtoAlquiler) {

        double valorMinuto = validarValorMinuto(dtoAlquiler);
        double totalMulta = calcularSiHayMultaYPagoParcial(dtoAlquiler, valorMinuto);
        double totalAPagar = sumaPagoParcialYPagoTotal(dtoAlquiler, valorMinuto, totalMulta);
        return totalAPagar;

    }

    private double validarValorMinuto(DtoAlquiler alquiler) {

        String idJetSki = alquiler.getIdJetSki();

        double valorMinuto = 0;

        if (idJetSki.equals("BC001")) {

            valorMinuto = 5000;

        }

        if (idJetSki.equals("BC002")) {

            valorMinuto = 7000;

        }

        if (idJetSki.equals("BC003")) {

            valorMinuto = 9000;

        }

        return valorMinuto;

    }

    private double calcularSiHayMultaYPagoParcial(DtoAlquiler alquiler, double valorMinuto) { // separar metodos en 2

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

    private double sumaPagoParcialYPagoTotal(DtoAlquiler alquiler, double valorMinuto, double totalMulta){

        double totalAPagar = 0;

        double totalParcial = 0;

        Integer tiempoRentado = alquiler.getRentTime();

        totalParcial = valorMinuto * tiempoRentado;

        totalAPagar = totalParcial + totalMulta;

        return totalAPagar;

    }

}
