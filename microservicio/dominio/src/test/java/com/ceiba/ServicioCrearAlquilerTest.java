package com.ceiba;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoRentAJetSki;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;
import com.ceiba.usuario.servicio.ServicioCrearAlquiler;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import static org.mockito.Mockito.*;


public class ServicioCrearAlquilerTest {


    @Test
    public void crearAlquilerConValidacionesCorrectas() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.existeUsuarioPorNationalId(alquiler.getCedula())).thenReturn(false);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioRentAJetSki, daoRentAJetSki);
        // Act
        servicioCrearAlquiler.crearAlquiler(alquiler);
        // Assert
        verify(daoRentAJetSki, times(1)).existeUsuarioPorNationalId(alquiler.getCedula());
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
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionValorInvalido.class,
                ServicioCrearAlquiler.EL_USUARIO_DEBE_SELECCIONAR_MINIMO_10_MINUTOS_DE_ALQUILER);

    }

    @Test
    public void crearAlquilerConExcepcionLanzadaPorSerMenorDeEdad() {

        // Arrange
        Usuario usuario = new UsuarioTestDataBuilder().conFechaNacido(LocalDate.of(2010, Month.MARCH, 26)).build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioRentAJetSki, daoRentAJetSki);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.crearUsuario(usuario), ExcepcionDuplicidad.class,
                ServicioCrearAlquiler.SOLO_SE_PRESTA_SERVICIO_A_MAYORES_DE_EDAD);

    }

    @Test
    public void validarExistenciaPreviaDeMotoAlquilada() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.existeAlquilerMoto(alquiler.getIdJetSki())).thenReturn(true);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(anyObject(), daoRentAJetSki);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionDuplicidad.class,
                ServicioCrearAlquiler.LA_MOTO_SOLICITADA_SE_ENCUENTRA_ALQUILADA);
    }

    @Test
    public void crearAlquilerConExcepcionPorExistenciaPreviaDeUsuario() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        when(daoRentAJetSki.existeUsuarioPorNationalId(alquiler.getCedula())).thenReturn(true);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioRentAJetSki, daoRentAJetSki);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionDuplicidad.class,
                ServicioCrearAlquiler.EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void crearAlquilerConExcepcionLanzadaPorSerMiercoles2() {

        // Arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioRentAJetSki repositorioRentAJetSki = mock(RepositorioRentAJetSki.class);
        DaoRentAJetSki daoRentAJetSki = mock(DaoRentAJetSki.class);
        LocalDate localDateTime = LocalDate.from(mock(LocalDate.class).getDayOfWeek());
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioRentAJetSki, daoRentAJetSki);
        // Act - Assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.crearAlquiler(alquiler), ExcepcionValorInvalido.class,
                ServicioCrearAlquiler.LOS_DIAS_MIERCOLES_NO_SE_PRESTA_SERVICIO);

    }
}
