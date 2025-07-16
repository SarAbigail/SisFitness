/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisfitness.factories;

/**
 *
 * @author BRYAN
 */
// ProductoFactoryCreator.java
public class ProductoFactoryCreator {
    public static ProductoFactory getFactory(String tipo) {
        switch (tipo.toLowerCase()) {
            case "suplemento":
                return new SuplementoFactory();
            case "accesorio":
                return new AccesorioFactory();
            default:
                throw new IllegalArgumentException("Tipo no válido");
        }
    }
}

