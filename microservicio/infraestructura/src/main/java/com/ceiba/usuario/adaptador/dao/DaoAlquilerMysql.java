package com.ceiba.usuario.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.puerto.dao.DaoAlquiler;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoAlquiler;

@Component
public class DaoAlquilerMysql implements DaoAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="usuario", value="listarPorPagar")
    private static String sqlListarPorPagar;

    @SqlStatement(namespace="usuario", value="listarPagados")
    private static String sqlListarPagados;

    @SqlStatement(namespace="usuario", value="buscarPorNationalId")
    private static String sqlBuscarPorNationalId;

    @SqlStatement(namespace="usuario", value="existePorIdJetSki")
    private static String sqlBuscarPorIdJetSki;

    @SqlStatement(namespace = "usuario", value = "existeUsuarioPorNationalId")
    private static String sqlExisteUsuarioPorNationalId;

    @SqlStatement(namespace = "usuario", value = "buscarAlquilerNoPagadoAun")
    private static String sqlBuscarAlquilerNoPagadoAun;

    @SqlStatement(namespace = "usuario", value = "buscarMontoPorNationalId")
    private static String sqlBuscarMontoPorNationalId;

    public DaoAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoAlquiler> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAlquiler());
    }

    @Override
    public List<DtoAlquiler> listarPorPagar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorPagar, new MapeoAlquiler());
    }

    @Override
    public List<DtoAlquiler> listarPagados() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPagados, new MapeoAlquiler());
    }

    @Override
    public DtoAlquiler buscarPorNationalId(Long nationalId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);
        return (DtoAlquiler) this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorNationalId, paramSource, new MapeoAlquiler());
    }

    @Override
    public boolean existeAlquilerMoto(String idJetSki) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idJetSki", idJetSki);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorIdJetSki,paramSource,Boolean.class);
    }

    @Override
    public boolean existeUsuarioPorNationalId(Long nationalId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteUsuarioPorNationalId, paramSource, Boolean.class);
    }

    @Override
    public DtoAlquiler buscarAlquilerNoPagadoAun(Long nationalId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);
        return (DtoAlquiler)  this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarAlquilerNoPagadoAun, paramSource, new MapeoAlquiler());
    }

    @Override
    public DtoAlquiler buscarMontoPorNationalId(long nationalId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);
        return (DtoAlquiler) this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarMontoPorNationalId, paramSource, new MapeoAlquiler());
    }
}
