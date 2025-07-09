/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.models;

public class ProductoModel {

    private final int id;
    private final String nombre;
    private final String descripcion;
    private final String serie;
    private final double stock;
    private final double precio;
    private final CategoriaModel categoria;

    private ProductoModel(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.serie = builder.serie;
        this.stock = builder.stock;
        this.precio = builder.precio;
        this.categoria = builder.categoria;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSerie() {
        return serie;
    }

    public double getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    // Builder interno
    public static class Builder {

        private int id;
        private String nombre;
        private String descripcion;
        private String serie;
        private double stock;
        private double precio;
        private CategoriaModel categoria;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder serie(String serie) {
            this.serie = serie;
            return this;
        }

        public Builder stock(double stock) {
            this.stock = stock;
            return this;
        }

        public Builder precio(double precio) {
            this.precio = precio;
            return this;
        }

        public Builder categoria(CategoriaModel categoria) {
            this.categoria = categoria;
            return this;
        }

        public ProductoModel build() {
            return new ProductoModel(this);
        }
    }
}
