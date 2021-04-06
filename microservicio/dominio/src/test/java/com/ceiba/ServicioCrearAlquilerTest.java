package com.ceiba;

import com.ceiba.usuario.excepcion.ExcepcionMotoAlquilada;
import com.ceiba.usuario.excepcion.ExcepcionTiempoAlquilerMenosDiezMinutos;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ServicioCrearAlquilerTest {


    @Test
    public void crearAlquilerConValidacionesCorrectas() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.existeAlquilerMoto(alquiler.getIdJetSki())).thenReturn(false);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioRentAJetSki, daoRentAJetSki);
        // Act
        servicioCrearAlquiler.crearAlquiler(alquiler);
        // Assert
        verify(daoRentAJetSki, times(1)).existeAlquilerMoto(alquiler.getIdJetSki());
        verify(repositorioRentAJetSki, times(1)).crearAlquiler(alquiler);
    }

    @Test
    public void crearAlquilerConExcepcionLanzadaPorElegirMenosDe10MinutosDeRenta() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conTiempoRenta(9).build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioRentAJetSki, daoRentAJetSki);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionTiempoAlquilerMenosDiezMinutos.class,
                ServicioCrearAlquiler.EL_USUARIO_DEBE_SELECCIONAR_MINIMO_10_MINUTOS_DE_ALQUILER);

    }

    @Test
    public void validarExistenciaPreviaDeMotoAlquilada() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.existeAlquilerMoto(alquiler.getIdJetSki())).thenReturn(true);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(anyObject(), daoRentAJetSki);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionMotoAlquilada.class,
                ServicioCrearAlquiler.LA_MOTO_SOLICITADA_SE_ENCUENTRA_ALQUILADA);
    }

}
