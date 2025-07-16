/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisfitness.iterator;

/**
 *
 * @author ITALO
 */


import java.util.List;
import sisfitness.models.CategoriaModel;

public class CategoriaCollection implements CategoriaAggregate {

    private final List<CategoriaModel> categorias;

    public CategoriaCollection(List<CategoriaModel> categorias) {
        this.categorias = categorias;
    }

    @Override
    public CategoriaIterator createIterator() {
        return new CategoriaIteratorImpl(categorias);
    }
}
