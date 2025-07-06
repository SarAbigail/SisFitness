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
public class OrdenVentaRowMapper {
 public List<OrdenVentaModel> mapRow(ResultSet resultSet) throws SQLException
    {
        List<OrdenVentaModel> lista=new ArrayList<>();
        while (resultSet.next()) {
            OrdenVentaModel item=new OrdenVentaModel();
            
            item.setIdorden((Integer)resultSet.getInt("idorden"));
            ClienteModel clienteModel=new ClienteModel();
            clienteModel.setIdcliente((Integer)resultSet.getInt("idcliente"));
             clienteModel.setApellidos(resultSet.getString("apellidos"));
             clienteModel.setNombres(resultSet.getString("nombres"));
            item.setCliente(clienteModel);
            item.setFechaventa(resultSet.getString("fechaventa"));
            item.setTotalventa((Double)resultSet.getDouble("total"));
            item.setFecharegistro(resultSet.getString("fecharegistro"));
            lista.add(item);
        }
         
        return lista;
    }
}
