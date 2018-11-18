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
public class Posicion {
    private int fila;
    private char columna;
    /**
     * Constructor de la clase Posicion que inicializa las dos variables
     * @param columnaValor 
     * @param filaValor 
     */
    
    public Posicion(char columnaValor, int filaValor){
        setColumna(columnaValor);
        setFila(filaValor);
    }
    /**
     * Constructor copia del objeto Posicion
     * @param posicionValor 
     */
    public Posicion(Posicion posicionValor){
        fila=posicionValor.getFila();
        columna=posicionValor.getColumna();
    }
            
    /**
     * Hemos declarado el atributo fila que debe estar entre 1 y 8.
     * @param filaValor 
     */
    public void setFila(int filaValor){
        if(filaValor>=1 && filaValor<=8){
            fila=filaValor;
        }
        else{
            throw new IllegalArgumentException("La Fila introducida no es válida");   
        }
    }
    /**
     * Obtenemos el valor de la variable Fila
     * @return devuelve un valor entero
     */
    public int getFila(){
        return fila;
    }
    /**
     * Establecemos el valor del atributo Columna que debe estar comprendido entre las letras abcdefgh
     * @param columnaValor 
     */
    public void setColumna(char columnaValor){
        String caracteresValidos="abcdefgh";
        if(caracteresValidos.indexOf(columnaValor)>=0){
            columna=columnaValor;
        }
        else{
            throw new IllegalArgumentException("La Columna introducida no es válida");
        }
    }
    /**
     * Obtenemos el valor de la variable columna
     * @return devuelve un char
     */
    public char getColumna(){
        return columna;
    }
}
