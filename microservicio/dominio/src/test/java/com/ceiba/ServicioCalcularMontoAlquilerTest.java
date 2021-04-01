package com.ceiba;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.servicio.ServicioCalcularMontoAlquiler;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class ServicioCalcularMontoAlquilerTest {

    @Test
    public void montoAlquilerJetSkiPrecio1SinMulta20Minutos() {
        // Arrange
        LocalDateTime checkout = LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 50, 0);
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC001").conTiempoRenta(20).
                conFechaYHoraRenta(LocalDateTime.of(2021, Month.MARCH, 18,
                        13, 30, 0)).build();
        ServicioCalcularMontoAlquiler servicioCalcularMontoAlquiler = new ServicioCalcularMontoAlquiler();
        // Act
        double result = servicioCalcularMontoAlquiler.calcularMontoAlquiler(alquiler, checkout);
        // Assert
        assertEquals(result, 100000, 0);
    }

    @Test
    public void montoAlquilerJetSkiPrecio2SinMulta20Minutos() {
        // Arrange
        LocalDateTime checkout = LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 50, 0);
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC002").conTiempoRenta(20).
                conFechaYHoraRenta(LocalDateTime.of(2021, Month.MARCH, 18,
                        13, 30, 0)).build();
        ServicioCalcularMontoAlquiler servicioCalcularMontoAlquiler = new ServicioCalcularMontoAlquiler();
        // Act
        double result = servicioCalcularMontoAlquiler.calcularMontoAlquiler(alquiler, checkout);
        // Assert
        assertEquals(result, 140000, 0);
    }

    @Test
    public void montoAlquilerJetSkiPrecio3SinMulta20Minutos() {
        // Arrange
        LocalDateTime checkout = LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 50, 0);
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC003").conTiempoRenta(20).
                conFechaYHoraRenta(LocalDateTime.of(2021, Month.MARCH, 18,
                        13, 30, 0)).build();
        ServicioCalcularMontoAlquiler servicioCalcularMontoAlquiler = new ServicioCalcularMontoAlquiler();
        // Act
        double result = servicioCalcularMontoAlquiler.calcularMontoAlquiler(alquiler, checkout);
        // Assert
        assertEquals(result, 180000, 0);
    }

    @Test
    public void montoAlquilerJetSkiPrecio1ConMulta20MinutosMas3MinutosDeMulta() {
        // Arrange
        LocalDateTime checkout = LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 53, 0);
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC001").conTiempoRenta(20).
                conFechaYHoraRenta(LocalDateTime.of(2021, Month.MARCH, 18,
                        13, 30, 0)).build();
        ServicioCalcularMontoAlquiler servicioCalcularMontoAlquiler = new ServicioCalcularMontoAlquiler();
        // Act
        double result = servicioCalcularMontoAlquiler.calcularMontoAlquiler(alquiler, checkout);
        // Assert
        assertEquals(result, 118000, 0);
    }
}
