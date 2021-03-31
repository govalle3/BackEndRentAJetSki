package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioRentAJetSki;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioRentAJetSkiMysql implements RepositorioRentAJetSki {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    @SqlStatement(namespace = "usuario", value = "crearAlquiler")
    private static String sqlCrearAlquiler;

    @SqlStatement(namespace = "usuario", value = "pagarAlquiler")
    private static String sqlPagarAlquiler;

    @SqlStatement(namespace = "usuario", value = "crearUsuario")
    private static String sqlCrearUsuario;

    public RepositorioRentAJetSkiMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public void crearAlquiler(Alquiler alquiler) {
        this.customNamedParameterJdbcTemplate.crear(alquiler, sqlCrearAlquiler);
    }

    @Override
    public void pagarAlquiler(Alquiler alquiler) {
        this.customNamedParameterJdbcTemplate.actualizar(alquiler, sqlPagarAlquiler);
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        this.customNamedParameterJdbcTemplate.crear(usuario, sqlCrearUsuario);
    }

}
