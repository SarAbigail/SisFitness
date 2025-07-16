/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisfitness.factories;

/**
 *
 * @author BRYAN
 */
import sisfitness.models.CategoriaModel;
import sisfitness.builder.ProductoModel;

public class SuplementoFactory implements ProductoFactory {

    @Override
    public ProductoModel crearProducto() {
        return new ProductoModel.ProductoBuilder()
                .id(5)
                .nombre("Proteína Whey")
                .descripcion("Suplemento para aumentar masa muscular")
                .serie("SUP-001")
                .stock(10)
                .precio(130.0)
                .categoria(new CategoriaModel(5, "Suplemento"))
                .build();
    }
}