package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoAlquiler;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException{
        Long cedula = resultSet.getLong("cedula");
        String nombre = resultSet.getString("nombre");
        LocalDate fechaNacido = extraerLocalDate(resultSet, "fechaNacido");
        return new DtoUsuario(cedula,nombre,fechaNacido);
    }
}
