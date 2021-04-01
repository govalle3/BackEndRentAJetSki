package com.ceiba;

import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;
import com.ceiba.usuario.servicio.ServicioPagarAlquiler;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.*;

public class ServicioPagarAlquilerTest {

    @Test
    public void pagarAlquilerJetSkiPrecio1SinMulta20Minutos() {
        // Arrange
        LocalDateTime checkout = LocalDateTime.of(2021,
                Month.MARCH, 18, 13, 50, 0);
        Alquiler alquiler = new AlquilerTestDataBuilder().conIdJetSki("BC001").conTiempoRenta(20).
                conFechaYHoraRenta(LocalDateTime.of(2021, Month.MARCH, 18,
                        13, 30, 0)).build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        ServicioPagarAlquiler servicioPagarAlquiler = new ServicioPagarAlquiler(repositorioRentAJetSki);
        // Act
        servicioPagarAlquiler.pagarAlquiler(alquiler);
        // Assert
        verify(repositorioRentAJetSki, times(1)).pagarAlquiler(alquiler);
    }


}
