/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.business;

import java.util.List;
import sisfitness.dao.OrdenVentaDaoImpl;
import sisfitness.models.OrdenVentaModel;

/**
 *
 * 
 */
public class BOrdenVenta {
    OrdenVentaDaoImpl ordenVentaDaoImpl;

    public BOrdenVenta()
    {
        ordenVentaDaoImpl=new OrdenVentaDaoImpl();
    }
    
    public int GuardarVenta(OrdenVentaModel ordenVentaModel)
    {
        return ordenVentaDaoImpl.setGuardar(ordenVentaModel);
    }
    
    public List<OrdenVentaModel> BuscarByClienteAndFechaVenta(int idcliente, String sFechaVenta)
    {
        return ordenVentaDaoImpl.BuscarByClienteAndFechaVenta(idcliente, sFechaVenta);
    }
}
