/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.models;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * 
 */
public class ProductoRowMapper {
    public List<ProductoModel> mapRow(ResultSet resultSet) throws SQLException
    {
        List<ProductoModel> listproucto=new ArrayList<>();
        while (resultSet.next()) {
            ProductoModel prdmodel=new ProductoModel();
            
            prdmodel.setId((Integer)resultSet.getInt("idproducto"));
            prdmodel.setNombre(resultSet.getString("nombre"));
            prdmodel.setDescripcion(resultSet.getString("descripcion"));
            prdmodel.setSerie(resultSet.getString("serie"));
            prdmodel.setPrecio((Double)resultSet.getDouble("precio"));
            prdmodel.setStock((Double)resultSet.getDouble("stock"));
            prdmodel.setCategoria(new CategoriaModel((Integer)resultSet.getInt("idcategoria"), resultSet.getString("categoria")));
            // Crear un objeto Usuario y agregarlo a la lista
            listproucto.add(prdmodel);
        }
         
        return listproucto;
    }
}
