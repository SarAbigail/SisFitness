/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfitness.common;

/**
 *
 * 
 */
public class FuncionesGenericas {
    
    public static boolean esEntero(String valor){     
        try{
            if(valor!= null){
                Integer.parseInt(valor);
            }
        }catch(NumberFormatException nfe){
             return false; 
        }
        return true;
    }
    
    public static boolean esDecimal(String valor){     
        try{
            if(valor!= null){
                Double.parseDouble(valor);
            }
        }catch(NumberFormatException nfe){
             return false; 
        }
        return true;
    }
    
    public static void ConvertMayuscula(java.awt.event.KeyEvent evt){     
        //minuzcula a MAYUSCULA
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A') && (c > 'Z')) {
            evt.consume();//Solo dejo ingresar letras minúsculas y  mayusculas (no numeros ni caracteres)
        }//Todo lo que ingresa se pone em mayúscula
        String cad = ("" + c).toUpperCase();
        c = cad.charAt(0);
        evt.setKeyChar(c);
        //minuzcula a MAYUSCULA FIN
    }    
    
}
