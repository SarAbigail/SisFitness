/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.business;

import java.util.List;
import sisfitness.common.exception.AccesoDenegadoException;
import sisfitness.dao.OrdenVentaDao;
import sisfitness.dao.OrdenVentaDaoImpl;
import sisfitness.models.OrdenVentaModel;

/**
 *
 * 
 */
public class BOrdenVenta implements OrdenVentaDao {
    OrdenVentaDaoImpl ordenVentaDaoImpl;
    private String perfilUsuario;

    public BOrdenVenta(String perfilUsuario)
    {
        ordenVentaDaoImpl=new OrdenVentaDaoImpl();
        this.perfilUsuario = perfilUsuario;
    }
    
    private boolean validaPermisoVenta() {
        return "vendedor".equalsIgnoreCase(perfilUsuario);
    }   
 
    @Override
    public int setGuardar(OrdenVentaModel ordenVentaModel) {
         if (validaPermisoVenta()) {
            return ordenVentaDaoImpl.setGuardar(ordenVentaModel);
        } else {
            throw new AccesoDenegadoException("No cuenta con permisos para guardar ventas.");
        }
    }

    @Override
    public List<OrdenVentaModel> BuscarByClienteAndFechaVenta(int idcliente, String sFechaVenta) {
       return ordenVentaDaoImpl.BuscarByClienteAndFechaVenta(idcliente, sFechaVenta);
    }
}
