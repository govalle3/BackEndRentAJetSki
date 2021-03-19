package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Statement;


@Repository
public class RepositorioAlquilerMysql implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "usuario", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "usuario", value = "crearAlquiler")
    private static String sqlCrearAlquiler;

    public RepositorioAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public boolean existe(Long nationalId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().execute(sqlExiste, paramSource, Statement::getMoreResults);
    }

    @Override
    public boolean crearAlquiler(Alquiler alquiler) {
        return this.customNamedParameterJdbcTemplate.crear(alquiler, sqlCrearAlquiler);
    }
}
