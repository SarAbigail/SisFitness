/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.models;

/**
 *
 * 
 */
public class CategoriaModel {


    private int id;
    private String nombre;
    private String descripcion;
    
    public CategoriaModel(){
            
    }
    
    public CategoriaModel(int id,String nombre ){
        this.id=id;
        this.nombre=nombre;
    }
    
   /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
    @Override
    public String toString()
    {
        return  this.nombre;
    }
    
}
