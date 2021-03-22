package com.ceiba.usuario.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Alquiler;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;

@Component
public class DaoAlquilerMysql implements DaoAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="usuario", value="buscarPorNationalId")
    private static String sqlbuscarPorNationalId;

    @SqlStatement(namespace="usuario", value="existePorIdJetSki")
    private static String sqlbuscarPorIdJetSki;

    @SqlStatement(namespace = "usuario", value = "existeUsuarioPorNationalId")
    private static String sqlexisteUsuarioPorNationalId;

    public DaoAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoAlquiler> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAlquiler());
    }

    @Override
    public DtoAlquiler buscarPorNationalId(Long nationalId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);
        return (DtoAlquiler) this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlbuscarPorNationalId, paramSource, new MapeoAlquiler());
    }

    @Override
    public boolean existeAlquilerMoto(String idJetSki) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idJetSki", idJetSki);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlbuscarPorIdJetSki,paramSource,Boolean.class);
    }

    @Override
    public boolean existeUsuarioPorNationalId(Long nationalId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlexisteUsuarioPorNationalId, paramSource, Boolean.class);
    }
}
