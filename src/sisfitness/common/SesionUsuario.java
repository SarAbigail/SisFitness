/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisfitness.common;

import sisfitness.models.UsuarioModel;

/**
 *
 * @author rarteaga
 */
public class SesionUsuario {
    private static SesionUsuario instancia;
    private UsuarioModel usuario;
    
    private SesionUsuario() { }

    public static SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }    
    
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void cerrarSesion() {
        usuario = null;
        instancia = null;
    }    
    
}
