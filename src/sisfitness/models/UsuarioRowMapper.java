/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class UsuarioRowMapper {

    public List<UsuarioModel> mapRow(ResultSet resultSet) throws SQLException {
        List<UsuarioModel> items = new ArrayList<>();
        while (resultSet.next()) {
            UsuarioModel item = new UsuarioModel();

            item.setIdusuario((Integer) resultSet.getInt("idusuario"));
            item.setLogin(resultSet.getString("login"));
            item.setIdusuario((Integer) resultSet.getInt("idempleado"));
            item.setPerfil(resultSet.getString("perfil"));
            // Crear un objeto Usuario y agregarlo a la lista
            items.add(item);
        }

        return items;
    }
}
