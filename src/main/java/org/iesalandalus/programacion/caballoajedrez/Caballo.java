/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

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
     * Constructor copia de Caballo
     * @param caballoValor 
     */
    public Caballo(Caballo caballoValor){
        color=caballoValor.getColor();
        posicion=new Posicion(caballoValor.getPosicion());   
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
    
    /**
     * Creamos el método mover con las distintas direcciones e incluimos la excepción.
     * @param dir
     * @throws OperationNotSupportedException 
     */
    public void mover(Direccion dir) throws OperationNotSupportedException{
        int filaActual=posicion.getFila();
        char columnaActual=posicion.getColumna();
        String caracteresValidos="abcdefgh";
        int posicionColumnaActual = caracteresValidos.indexOf(columnaActual);
        int filaNueva=-1;
        int posicionColumnaNueva=-1;
        
        switch(dir){
            case ARRIBA_IZQUIERDA:filaNueva=filaActual-2;
                                  posicionColumnaNueva=posicionColumnaActual-1;
                                  break;
                              
            case ARRIBA_DERECHA:filaNueva=filaActual-2;
                                  posicionColumnaNueva=posicionColumnaActual+1;
                                  break;
                                  
            case DERECHA_ARRIBA:filaNueva=filaActual-1;
                                  posicionColumnaNueva=posicionColumnaActual+2;
                                  break;
            
            case DERECHA_ABAJO:filaNueva=filaActual+1;
                                  posicionColumnaNueva=posicionColumnaActual+2;
                                  break;
                                  
            case ABAJO_DERECHA:filaNueva=filaActual+2;
                                  posicionColumnaNueva=posicionColumnaActual+1;
                                  break;
                                  
            case ABAJO_IZQUIERDA:filaNueva=filaActual+2;
                                  posicionColumnaNueva=posicionColumnaActual-1;
                                  break;
                                  
            case IZQUIERDA_ARRIBA:filaNueva=filaActual-1;
                                  posicionColumnaNueva=posicionColumnaActual-2;
                                  break;
                                  
            case IZQUIERDA_ABAJO:filaNueva=filaActual+1;
                                  posicionColumnaNueva=posicionColumnaActual-2;
                                  break;                        
       }   
        if(filaNueva>=1 && filaNueva<=8){
            if(posicionColumnaNueva>=0 && posicionColumnaNueva<=7){
                posicion.setFila(filaNueva);
                posicion.setColumna(caracteresValidos.charAt(posicionColumnaNueva));
            }else{
                throw new OperationNotSupportedException("La columna introducida no es válida");
            }
        }else{
            throw new OperationNotSupportedException("La fila introducida no es válida");
        }
    }
    
    
    /**
     * Utilizamos el método equals para comparar el color y la posición de nuestro objeto caballo con el objeto que nos han pasado en la entrada
     * @param obj objeto con el que vamos a realizar la comprobación
     * @return Terminamos la ejecución del método devolviendo true si se cumple la comparación del color y el objeto de nuestra clase caballo y sino devuelve false.
     */
    public boolean equals(Object obj){
        if(obj instanceof Caballo){
            Caballo tmp = (Caballo) obj;
            if(color == tmp.getColor() && posicion == tmp.getPosicion()){
                return true;
            }
        }
        return false;    
    }
    
}
