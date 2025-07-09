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
public class ProductoRowMapper {

    public List<ProductoModel> mapRow(ResultSet resultSet) throws SQLException {
        List<ProductoModel> listaProductos = new ArrayList<>();

        while (resultSet.next()) {
            ProductoModel producto = new ProductoModel.Builder()
                    .id(resultSet.getInt("idproducto"))
                    .nombre(resultSet.getString("nombre"))
                    .descripcion(resultSet.getString("descripcion"))
                    .serie(resultSet.getString("serie"))
                    .precio(resultSet.getDouble("precio"))
                    .stock(resultSet.getDouble("stock"))
                    .categoria(new CategoriaModel(
                            resultSet.getInt("idcategoria"),
                            resultSet.getString("categoria")))
                    .build();

            listaProductos.add(producto);
        }

        return listaProductos;
    }
}
