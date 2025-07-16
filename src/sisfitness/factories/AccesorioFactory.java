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
import sisfitness.models.ProductoModel;

public class AccesorioFactory implements ProductoFactory {

    @Override
    public ProductoModel crearProducto() {
        return new ProductoModel.Builder()
                .id(0)
                .nombre("Guantes Pro Grip")
                .descripcion("Accesorio para levantamiento de pesas")
                .serie("ACC-101")
                .precio(40.0)
                .stock(20)
                .categoria(new CategoriaModel(6, "Accesorio")) // ID real de la categoría
                .build();
    }
}