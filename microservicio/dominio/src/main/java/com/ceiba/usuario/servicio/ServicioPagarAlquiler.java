package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ServicioPagarAlquiler {

    public static final double PRECIOMOTO1 = 5000;
    public static final double PRECIOMOTO2 = 7000;
    public static final double PRECIOMOTO3 = 9000;
    public static final double MULTAMINUTO = 1.2;
    private double VALORMINUTO = 0;
    private double TOTALMULTA = 0;

    private final RepositorioAlquiler repositorioAlquiler;


    public ServicioPagarAlquiler(RepositorioAlquiler repositorioAlquiler) {


        this.repositorioAlquiler = repositorioAlquiler;
    }

    public double pagarAlquiler(Alquiler alquiler, LocalDateTime dateAndTimeCheckout) {

        VALORMINUTO = validarValorMinuto(alquiler);
        TOTALMULTA = calcularSiHayMultaYPagoParcial(alquiler, VALORMINUTO, dateAndTimeCheckout);
        return sumaPagoParcialYPagoTotal(alquiler, VALORMINUTO, TOTALMULTA);

    }

    public double validarValorMinuto(Alquiler alquiler) {

        String idJetSki = alquiler.getIdJetSki();


        if ("BC001".equals(idJetSki)) {
            VALORMINUTO = PRECIOMOTO1;
        }

        if ("BC002".equals(idJetSki)) {
            VALORMINUTO = PRECIOMOTO2;
        }

        if ("BC003".equals(idJetSki)) {
            VALORMINUTO = PRECIOMOTO3;
        }

        return VALORMINUTO;

    }

    public double calcularSiHayMultaYPagoParcial(Alquiler alquiler, double valorMinuto, LocalDateTime dateAndTimeCheckout) { // separar metodos en 2

        Integer tiempoRentado = alquiler.getRentTime();

        LocalTime fechaYHoraRentaUsuario = alquiler.getDateAndTimeRent().toLocalTime();

        LocalTime localTime = dateAndTimeCheckout.toLocalTime();

        Integer duracion = Long.valueOf(Duration.between(fechaYHoraRentaUsuario, localTime).toMinutes()).intValue();

        if (duracion > tiempoRentado) {

            int minutosPasados = duracion - tiempoRentado;

            TOTALMULTA = minutosPasados * MULTAMINUTO * valorMinuto;

        }

        return TOTALMULTA;

    }

    public double sumaPagoParcialYPagoTotal(Alquiler alquiler, double valorMinuto, double totalMulta) {

        Integer tiempoRentado = alquiler.getRentTime();
        double totalParcial = valorMinuto * tiempoRentado;
        return totalParcial + totalMulta;

    }

}
