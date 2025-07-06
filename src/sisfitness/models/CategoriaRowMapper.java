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
public class CategoriaRowMapper {
     public List<CategoriaModel> mapRow(ResultSet resultSet) throws SQLException
    {
        List<CategoriaModel> lista=new ArrayList<>();
        while (resultSet.next()) {
            CategoriaModel item=new CategoriaModel();
            
            item.setId((Integer)resultSet.getInt("idcategoria"));
            item.setNombre(resultSet.getString("nombre"));            
            item.setDescripcion(resultSet.getString("descripcion"));
            // Crear un objeto Usuario y agregarlo a la lista
            lista.add(item);
        }
         
        return lista;
    }
}
