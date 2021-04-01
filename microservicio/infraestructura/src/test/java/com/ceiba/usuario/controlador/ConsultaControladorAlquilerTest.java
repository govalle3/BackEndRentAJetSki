package com.ceiba.usuario.controlador;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorAlquiler.class)
public class ConsultaControladorAlquilerTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarTodosLosAlquileres() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/gestionar-alquiler/alquiler")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))));
    }

    @Test
    public void listarAlquileresPagados() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/gestionar-alquiler/alquiler/pagados")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[0].cedula", is(51658)));
    }

    @Test
    public void listarAlquileresPorPago() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/gestionar-alquiler/alquiler/por-pago")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[0].cedula", is(1234)));
    }
}



