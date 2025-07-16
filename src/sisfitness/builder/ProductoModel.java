/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.builder;

//Se importa el modelo de categoria
import sisfitness.models.CategoriaModel;

public class ProductoModel {

    //Atributos del producto
    private final int id;
    private final String nombre;
    private final String descripcion;
    private final String serie;
    private final double stock;
    private final double precio;
    private final CategoriaModel categoria;

    //Constructor, solo se instancia a traves del ProductoBuilder
    private ProductoModel(ProductoBuilder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.serie = builder.serie;
        this.stock = builder.stock;
        this.precio = builder.precio;
        this.categoria = builder.categoria;
    }

    // Getters para acceder a los atributos
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

    // Clase interna que pemite construir objetos ProductoModel
    public static class ProductoBuilder {

        //Atributos del builder
        private int id;
        private String nombre;
        private String descripcion;
        private String serie;
        private double stock;
        private double precio;
        private CategoriaModel categoria;

        //Métodos para establecer valores
        public ProductoBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ProductoBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public ProductoBuilder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public ProductoBuilder serie(String serie) {
            this.serie = serie;
            return this;
        }

        public ProductoBuilder stock(double stock) {
            this.stock = stock;
            return this;
        }

        public ProductoBuilder precio(double precio) {
            this.precio = precio;
            return this;
        }

        public ProductoBuilder categoria(CategoriaModel categoria) {
            this.categoria = categoria;
            return this;
        }

        //Método que construye y devuelve una instancia de ProductoModel
        public ProductoModel build() {
            return new ProductoModel(this);
        }
    }
}
