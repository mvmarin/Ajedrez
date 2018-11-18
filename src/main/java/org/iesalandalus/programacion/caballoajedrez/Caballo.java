/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

/**
 *
 * @author victoriamarin
 */
public class Caballo {
    private Color color;
    private Posicion posicion;
    
    /**
     * Creamos un constructor por defecto de Caballo.
     */
    public Caballo(){
        color = Color.NEGRO;
        posicion = new Posicion(8,'b');
    }
    
    /**
     * Introducimos un constructor que si el caballo es blanco tendrá posición 1b y si es negro 8b
     * @param colorValor 
     */
    public Caballo(Color colorValor){
        color = colorValor;
        if(color == Color.BLANCO){
            posicion = new Posicion(1, 'b');
        }else{
            posicion = new Posicion(8, 'b');
        }
        
    }
    /**
     * Creamos un constructor para comprobar que si el caballo no está en la columna b ó g, se lance un mensaje y lo situe en la fila 1 si es blanco o en la 8 si es negro
     * @param colorValor
     * @param columnaValor 
     */
    public Caballo(Color colorValor, char columnaValor){
        color = colorValor;
        String caracteresValidos="bg";
        if(caracteresValidos.indexOf(columnaValor)>=0){
            if(color == Color.BLANCO){
                posicion = new Posicion(1, columnaValor);
            }else{
                posicion = new Posicion(8, columnaValor);
            }
        }else{
            throw new IllegalArgumentException("Columna no válida");
        }
    }
    
    /**
     * Definimos el set de nuestro atributo Color
     * @param colorValor 
     */
    public void setColor(Color colorValor){
        color=colorValor;
    }
    
    /**
     * Definimos el get de nuestro atributo Color
     * @return 
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Definimos el set de la Posición llamando al cosntructor new de la clase Posicion para inicializar las variables
     * @param posicionValor 
     */
    public void setPosicion (Posicion posicionValor){
        posicion=new Posicion(posicionValor);
    }
    
    /**
     * Definimos el get de la Posicion llamando al return para devolver el valor.
     * @return 
     */
    public Posicion getPosicion(){
        return posicion;
    }
    
    
}
