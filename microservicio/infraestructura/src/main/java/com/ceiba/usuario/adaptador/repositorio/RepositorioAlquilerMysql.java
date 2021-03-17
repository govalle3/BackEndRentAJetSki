package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.repositorio.RepositorioAlquiler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAlquilerMysql implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="usuario", value="crearAlquiler")
    private static String sqlCrearAlquiler;

    public RepositorioAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public boolean existe(Long nationalId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean crearAlquiler(Alquiler alquiler) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", alquiler.getNationalId());
        paramSource.addValue("idJetSki", alquiler.getIdJetSki());
        paramSource.addValue("rentTime", alquiler.getRentTime());
        paramSource.addValue("dateAndTimeRent", alquiler.getDateAndTimeRent());
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCrearAlquiler,paramSource, Boolean.class);
    }

}
