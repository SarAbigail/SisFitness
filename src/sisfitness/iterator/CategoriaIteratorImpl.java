/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sisfitness.iterator;

/**
 *
 * @author ITALO
 */

import java.util.List;
import sisfitness.models.CategoriaModel;

public class CategoriaIteratorImpl implements CategoriaIterator {
    private final List<CategoriaModel> categorias;
    private int position = 0;

    public CategoriaIteratorImpl(List<CategoriaModel> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean hasNext() {
        return position < categorias.size();
    }

    @Override
    public CategoriaModel next() {
        return categorias.get(position++);
    }
}
