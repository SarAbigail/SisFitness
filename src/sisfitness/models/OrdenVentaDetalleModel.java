/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.models;

import sisfitness.builder.ProductoModel;

/**
 *
 * 
 */
public class OrdenVentaDetalleModel {

    private int idordendetalle;
    private int item;    
    private OrdenVentaModel ordenventa;    
    private ProductoModel producto;
    private double cantidad;
    private double precio;
    private double total;
    
    /**
     * @return the item
     */
    public int getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(int item) {
        this.item = item;
    }    
    
    /**
     * @return the idordendetalle
     */
    public int getIdordendetalle() {
        return idordendetalle;
    }

    /**
     * @param idordendetalle the idordendetalle to set
     */
    public void setIdordendetalle(int idordendetalle) {
        this.idordendetalle = idordendetalle;
    }

    /**
     * @return the ordenventa
     */
    public OrdenVentaModel getOrdenventa() {
        return ordenventa;
    }

    /**
     * @param ordenventa the ordenventa to set
     */
    public void setOrdenventa(OrdenVentaModel ordenventa) {
        this.ordenventa = ordenventa;
    }

    /**
     * @return the producto
     */
    public ProductoModel getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

}
