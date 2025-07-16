/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sisfitness.iterator;

/**
 *
 * @author ITALO
 */


import sisfitness.models.CategoriaModel;

public interface CategoriaIterator {
    boolean hasNext();
    CategoriaModel next();
}

