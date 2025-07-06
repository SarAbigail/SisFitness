/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.dao;

import java.util.List;
import sisfitness.models.OrdenVentaModel;

/**
 *
 * 
 */
public interface OrdenVentaDao {
    int setGuardar(OrdenVentaModel ordenVentaModel);
    List<OrdenVentaModel> BuscarByClienteAndFechaVenta(int idcliente, String sFechaVenta);
}
