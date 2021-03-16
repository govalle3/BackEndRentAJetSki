package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioUsuarioMysql implements RepositorioUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="usuario", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="usuario", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="usuario", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="usuario", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="usuario", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace="alquiler", value="crearAlquiler")
    private static String sqlCrearAlquiler;

    public RepositorioUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Usuario usuario) {
        return this.customNamedParameterJdbcTemplate.crear(usuario, sqlCrear);
    }

    @Override
    public void eliminar(Long nationalId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long nationalId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Usuario usuario) {
        this.customNamedParameterJdbcTemplate.actualizar(usuario, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long nationalId, String name) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", nationalId);
        paramSource.addValue("name", name);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }

    @Override
    public boolean crearAlquiler(Usuario usuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nationalId", usuario.getNationalId());
        paramSource.addValue("idJetSki", usuario.getIdJetSki());
        paramSource.addValue("rentTime", usuario.getRentTime());
        paramSource.addValue("dateAndTimeRent", usuario.getDateAndTimeRent());
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCrearAlquiler,paramSource, Boolean.class);
    }
}
