/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.models;

import java.util.List;

/**
 *
 * 
 */
public class OrdenVentaModel {

       private int idorden;
    private ClienteModel cliente;
    private String fechaventa;
    private double totalventa;    
    private List<OrdenVentaDetalleModel> ordenVentaDetalles;
    private String fecharegistro;    
    
 /**
     * @return the fecharegistro
     */
    public String getFecharegistro() {
        return fecharegistro;
    }

    /**
     * @param fecharegistro the fecharegistro to set
     */
    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    
    /**
     * @return the idorden
     */
    public int getIdorden() {
        return idorden;
    }

    /**
     * @param idorden the idorden to set
     */
    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    /**
     * @return the cliente
     */
    public ClienteModel getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the fechaventa
     */
    public String getFechaventa() {
        return fechaventa;
    }

    /**
     * @param fechaventa the fechaventa to set
     */
    public void setFechaventa(String fechaventa) {
        this.fechaventa = fechaventa;
    }

    /**
     * @return the totalventa
     */
    public double getTotalventa() {
        return totalventa;
    }

    /**
     * @param totalventa the totalventa to set
     */
    public void setTotalventa(double totalventa) {
        this.totalventa = totalventa;
    }
    
  /**
     * @return the ordenVentaDetalles
     */
    public List<OrdenVentaDetalleModel> getOrdenVentaDetalles() {
        return ordenVentaDetalles;
    }

    /**
     * @param ordenVentaDetalles the ordenVentaDetalles to set
     */
    public void setOrdenVentaDetalles(List<OrdenVentaDetalleModel> ordenVentaDetalles) {
        this.ordenVentaDetalles = ordenVentaDetalles;
    }

}
