package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.*;
import static org.junit.Assert.*;

public class ServicioPagarAlquilerTest {

    private final RepositorioAlquiler repositorioAlquiler;


    public ServicioPagarAlquilerTest(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    @Test
    public void pagarAlquilerJetSkiPrecio1SinMulta20Minutos() {
        // Arrange
        LocalDateTime checkout = LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 50, 00);
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC01").conRentTime(20).conDateAndTimeRent(LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 30, 00)).build();
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler(repositorioAlquiler);
        // Act
        double result = servicioPagarAlquiler.pagarAlquiler(alquiler, checkout);
        // Assert
        assertEquals(930000,930000,0);
    }



}