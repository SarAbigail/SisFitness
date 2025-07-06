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
public class ClienteRowMapper {
    public List<ClienteModel> mapRow(ResultSet resultSet) throws SQLException
    {
        List<ClienteModel> lista=new ArrayList<>();
        while (resultSet.next()) {
            ClienteModel item=new ClienteModel();
            
            item.setIdcliente((Integer)resultSet.getInt("idcliente"));
             item.setDni(resultSet.getString("dni"));
            item.setApellidos(resultSet.getString("apellidos"));
            item.setNombres(resultSet.getString("nombres"));
            item.setDireccion(resultSet.getString("direccion"));
            item.setDistrito(resultSet.getString("distrito"));
            item.setCorreo(resultSet.getString("correo"));
            item.setCeluar(resultSet.getString("celular"));
            // Crear un objeto Usuario y agregarlo a la lista
            lista.add(item);
        }
         
        return lista;
    }
}
