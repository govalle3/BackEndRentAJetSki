package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ServicioCalcularMontoAlquiler {

    public static final double PRECIO_MOTO_1_5000 = 5000;
    public static final double PRECIO_MOTO_2_7000 = 7000;
    public static final double PRECIO_MOTO_3_9000 = 9000;
    public static final double MULTA_MINUTO_1_2 = 1.2;
    private double valorMinutoRenta = 0;
    private double totalMultaRenta = 0;

    public double calcularMontoAlquiler(Alquiler alquiler, LocalDateTime horaYFechaEntrada) {
        valorMinutoRenta = calcularValorMinutoRenta(alquiler);
        totalMultaRenta = calcularSiHayMultaYMontoParcial(alquiler, valorMinutoRenta, horaYFechaEntrada);
        return sumaMontoParcialYMontoTotal(alquiler, valorMinutoRenta, totalMultaRenta);

    }

    public double calcularValorMinutoRenta(Alquiler alquiler) {

        String idJetSki = alquiler.getIdJetSki();
        if ("BC001".equals(idJetSki)) {
            valorMinutoRenta = PRECIO_MOTO_1_5000;
        }
        if ("BC002".equals(idJetSki)) {
            valorMinutoRenta = PRECIO_MOTO_2_7000;
        }
        if ("BC003".equals(idJetSki)) {
            valorMinutoRenta = PRECIO_MOTO_3_9000;
        }
        return valorMinutoRenta;
    }

    public double calcularSiHayMultaYMontoParcial(Alquiler alquiler, double valorMinuto, LocalDateTime dateAndTimeCheckout) { // separar methods en 2

        Integer tiempoRentado = alquiler.getTiempoRenta();
        LocalTime fechaYHoraRentaUsuario = alquiler.getFechaYHoraRenta().toLocalTime();
        LocalTime localTime = dateAndTimeCheckout.toLocalTime();
        Long duracion = Duration.between(fechaYHoraRentaUsuario, localTime).toMinutes();

        if (duracion > tiempoRentado) {
            long minutosPasados = duracion - tiempoRentado;
            totalMultaRenta = minutosPasados * MULTA_MINUTO_1_2 * valorMinuto;

        }

        return totalMultaRenta;

    }

    public double sumaMontoParcialYMontoTotal(Alquiler alquiler, double valorMinuto, double totalMulta) {

        Integer tiempoRentado = alquiler.getTiempoRenta();
        double totalParcial = valorMinuto * tiempoRentado;
        return totalParcial + totalMulta;

    }



}
