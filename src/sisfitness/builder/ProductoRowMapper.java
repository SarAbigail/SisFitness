/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sisfitness.models.CategoriaModel;

public class ProductoRowMapper {

    public List<ProductoModel> mapRow(ResultSet resultSet) throws SQLException {
        // Se crea una lista vacía para almacenar los productos mapeados
        List<ProductoModel> listaProductos = new ArrayList<>();
        //Se itera por cada fila del ResultSet
        while (resultSet.next()) {
            //Se construye un objeto ProductoModel usando el patrón Builder
            ProductoModel producto = new ProductoModel.ProductoBuilder()
                    .id(resultSet.getInt("idproducto"))
                    .nombre(resultSet.getString("nombre"))
                    .descripcion(resultSet.getString("descripcion"))
                    .serie(resultSet.getString("serie"))
                    .precio(resultSet.getDouble("precio"))
                    .stock(resultSet.getDouble("stock"))
                    .categoria(new CategoriaModel(
                            resultSet.getInt("idcategoria"),
                            resultSet.getString("categoria")))
                    // Se construye el producto final
                    .build();
            // Se agrega el producto a la lista
            listaProductos.add(producto);
        }
        // Se retorna la lista completa de productos
        return listaProductos;
    }
}
