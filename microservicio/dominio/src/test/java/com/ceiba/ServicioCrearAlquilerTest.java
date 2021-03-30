package com.ceiba;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.WEDNESDAY;
import static org.mockito.Mockito.*;


public class ServicioCrearAlquilerTest {


    @Test
    public void crearAlquilerConValidacionesCorrectas() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = mock(RepositorioAlquiler.class);
        DaoAlquiler daoAlquiler = mock(DaoAlquiler.class);
        when(daoAlquiler.existeUsuarioPorNationalId(alquiler.getNationalId())).thenReturn(false);
        when(repositorioAlquiler.crearAlquiler(alquiler)).thenReturn(true);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler, daoAlquiler);
        // Act
        servicioCrearAlquiler.crearAlquiler(alquiler);
        // Assert
        verify(daoAlquiler, times(1)).existeUsuarioPorNationalId(alquiler.getNationalId());
        verify(repositorioAlquiler, times(1)).crearAlquiler(alquiler);
    }

    @Test
    public void crearAlquilerConExcepcionLanzadaPorElegirMenosDe10MinutosDeRenta() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conRentTime(9).build();
        RepositorioAlquiler repositorioAlquiler = mock(RepositorioAlquiler.class);
        DaoAlquiler daoAlquiler = mock(DaoAlquiler.class);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler, daoAlquiler);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionValorInvalido.class,
                ServicioCrearAlquiler.EL_USUARIO_DEBE_SELECCIONAR_MINIMO_10_MINUTOS_DE_ALQUILER);

    }

    @Test
    public void crearAlquilerConExcepcionLanzadaPorSerMenorDeEdad() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conDob(LocalDate.of(2010, Month.MARCH, 26)).build();
        RepositorioAlquiler repositorioAlquiler = mock(RepositorioAlquiler.class);
        DaoAlquiler daoAlquiler = mock(DaoAlquiler.class);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler, daoAlquiler);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionDuplicidad.class,
                ServicioCrearAlquiler.SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD);

    }

    @Test
    public void validarExistenciaPreviaDeMotoAlquilada() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        DaoAlquiler daoAlquiler = mock(DaoAlquiler.class);
        when(daoAlquiler.existeAlquilerMoto(alquiler.getIdJetSki())).thenReturn(true);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(anyObject(), daoAlquiler);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionDuplicidad.class,
                ServicioCrearAlquiler.LA_MOTO_SOLICITADA_SE_ENCUENTRA_ALQUILADA);
    }

    @Test
    public void crearAlquilerConExcepcionPorExistenciaPreviaDeUsuario() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = mock(RepositorioAlquiler.class);
        DaoAlquiler daoAlquiler = mock(DaoAlquiler.class);
        when(daoAlquiler.existeUsuarioPorNationalId(alquiler.getNationalId())).thenReturn(true);
        when(repositorioAlquiler.crearAlquiler(alquiler)).thenReturn(false);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler, daoAlquiler);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionDuplicidad.class,
                ServicioCrearAlquiler.EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void crearAlquilerConExcepcionLanzadaPorSerMiercoles() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = mock(RepositorioAlquiler.class);
        DaoAlquiler daoAlquiler = mock(DaoAlquiler.class);
        LocalDate localDateTime = LocalDate.from(mock(LocalDate.class).getDayOfWeek());
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler, daoAlquiler);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionValorInvalido.class,
                ServicioCrearAlquiler.LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO);

    }
}
