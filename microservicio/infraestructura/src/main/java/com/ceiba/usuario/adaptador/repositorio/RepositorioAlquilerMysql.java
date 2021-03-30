package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioAlquilerMysql implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;


    @SqlStatement(namespace = "usuario", value = "crearAlquiler")
    private static String sqlCrearAlquiler;

    @SqlStatement(namespace = "usuario", value = "updateCrearAlquiler")
    private static String sqlUpdateCrearAlquiler;

    public RepositorioAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public boolean crearAlquiler(Alquiler alquiler) {
        return this.customNamedParameterJdbcTemplate.crear(alquiler, sqlCrearAlquiler);
    }

    @Override
    public void actualizarEstadoPagadoAlquiler(Alquiler alquiler) {
        this.customNamedParameterJdbcTemplate.actualizar(alquiler, sqlUpdateCrearAlquiler);
    }

}
