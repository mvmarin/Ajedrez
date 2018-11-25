package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
    private static Caballo caballoPrueba;

    public MainApp(){
        
    }
    /**
     *Hemos declarado las funciones del menú y lo mostramos en pantalla.
     */
    private static void mostrarMenu(){
        System.out.println("1- Crear caballo por defecto");
        System.out.println("2- Crear caballo de un color");
        System.out.println("3- Crear caballo de un color en columna inicial");
        System.out.println("4- Mover el caballo");
        System.out.println("5- Salir");
    }
    /**
     * Imprimimos por pantalla que se elija la opción deseada, y cuando cumpla la condición devuelve el valor de opcion
     * @return devuelve la opción
     */
    private static int elegirOpcion(){
        int opcion;
        do{
            System.out.println("Elija la opción deseada mostrada en pantalla: ");
            opcion=Entrada.entero();   
        }while (opcion<1 || opcion>5);
        return opcion;
        
    }
    /**
     * Definimos las opciones posible para ejecutar
     * @param opcion 
     */
    private static void ejecutarOpcion(int opcion){
        switch (opcion){
            case 1: crearCaballoDefecto();
                break;
            case 2: crearCaballoDefectoColor();
                break;
            case 3: crearCaballoColorPosicion();
                break;
            case 4: mover();
                break;    
        }
        if(caballoPrueba!=null){
           System.out.println("Estado actual del caballo: "+ caballoPrueba.toString()); 
        } 
    }
    /**
     * Con este método creamos el caballo por defecto en color blanco y negro
     */
    private static void crearCaballoDefecto(){
        caballoPrueba = new Caballo();
    }
    /**
     * Con el método elegirColor pretendemos que según la opción insertada (1 ó 2) me devuelva por pantalla el color correspondiente.
     * @return Devuelve Blanco si es 1 y Negro si es 2
     */
    private static Color elegirColor(){
        int opcion;
        do{
            System.out.println("El color blanco será el numero 1 y el color negro será el número 2, elija la opción deseada: ");
            opcion=Entrada.entero();
        }while(opcion<1 || opcion>2);
        if (opcion==1){
            return Color.BLANCO;
        }
        return Color.NEGRO;
    }
    /**
     * Definimos el método donde el caballo adquiere la posición y el color y la excepción en caso de que ni la posición ni el color sea correcto, preguntamo tantas veces como sea necesario
     */
    private static void crearCaballoColorPosicion(){
        boolean correcto = true;       
        Color colorCaballo = elegirColor();
        do{ 
            correcto = true;
            char columnaCaballo = elegirColumnaInicial();
            try{
                caballoPrueba = new Caballo(colorCaballo, columnaCaballo);
            }catch(IllegalArgumentException e){
                correcto = false;
            }
        }while(!correcto);   
    }
    
    /**
     * Imprimimos por pantalla elegir la columna inicial
     * @return devuelve la columna leida
     */
    private static char elegirColumnaInicial(){
        char columnaLeida;
        System.out.println("Introduzca una columna válida");
        columnaLeida = Entrada.caracter();
        return columnaLeida;
    }
    /**
     * Definimos el método mover, llamando a nuestro menú de direcciones y controlando la excepción con un mensaje en pantalla.
     */
    private static void mover(){
        if(caballoPrueba==null){
            System.out.println("Es necesario crear un caballo para poder empezar a jugar");
            return;
        }
        mostrarMenuDirecciones();
        try{
           caballoPrueba.mover(elegirDireccion()); 
        }catch(OperationNotSupportedException e){
            System.out.println("Moviemiento no permitido");
        }

    }
    /**
     * Hemos declarado el método mostrar menú con las diferentes opciones de movimiento.
     */
    
    private static void mostrarMenuDirecciones(){
        System.out.println("Introduzca 1 para mover Arriba-izquierda");
        System.out.println("Introduzca 2 para mover Arriba-derecha");
        System.out.println("Introduzca 3 para mover Derecha-arriba");
        System.out.println("Introduzca 4 para mover Derecha-abajo");
        System.out.println("Introduzca 5 para mover Abajo-derecha");
        System.out.println("Introduzca 6 para mover Abajo-izquierda");
        System.out.println("Introduzca 7 para mover Izquierda-arriba");
        System.out.println("Introduzca 8 para mover Izquierda-abajo");         
    }
    /**
     * Definimos el método elegirDireccion con los 8 casos posibles.
     * @return 
     */
    private static Direccion elegirDireccion(){
        int opcion;
        do{
            System.out.println("Elige la opción del movimiento");
            opcion = Entrada.entero();
        }while(opcion<1 || opcion>8);
        switch (opcion){
            case 1: return Direccion.ARRIBA_IZQUIERDA;
            case 2: return Direccion.ARRIBA_DERECHA;
            case 3: return Direccion.DERECHA_ARRIBA;
            case 4: return Direccion.DERECHA_ARRIBA;
            case 5: return Direccion.ABAJO_DERECHA;
            case 6: return Direccion.ABAJO_IZQUIERDA;
            case 7: return Direccion.IZQUIERDA_ARRIBA;
            case 8: return Direccion.IZQUIERDA_ABAJO;
            default: return Direccion.ARRIBA_IZQUIERDA;
        }
    }
    
    /**
     * Llamamos dentro de crearCaballoDefectoColor al método elegirColor creado en las lineas anteriores
     */
    private static void crearCaballoDefectoColor(){
        caballoPrueba = new Caballo(elegirColor());
    }
    public static void main(String[] args) {
        System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
        int opcion;
        do{   
            mostrarMenu();
            opcion = elegirOpcion();
            ejecutarOpcion(opcion);
	}while(opcion!=5);
        
        System.out.println("Fin de la ejecución y Gracias por participar");
                
    }
        
}