/*
 * Archivo: MochilaEntera.java
 * Autor: Carlos Caride Santeiro
 * DNI: 44446239G
 * Email: ccaride5@alumno.uned.es
 * Fecha: 15/12/2017
 * Asignatura: Programación y Estructuras de Datos Avanzadas.
 * Trabajo: Práctica 2 (2017-2018)
 */

package mochila.dinamica.algoritmos;

import java.io.PrintStream;
import java.util.ArrayList;
import mochila.dinamica.Objeto;

/**
 * Algoritmo para resolver el problema de la mochila entera mediante
 * programación dinámica
 */
public class MochilaEntera {
    int[][] tabla;
    Objeto[] objetosOriginales;
    int volumenMaximo;
    
    /**
     * Inicializa la mochila y crea la tabla de beneficio máximo
     * @param objetos Vector con los objetos a seleccionar
     * @param volumen Volumen máximo de la mochila
     */
    public MochilaEntera(Objeto[] objetos, int volumen) {
        objetosOriginales = objetos;
        volumenMaximo = volumen;
        
        tabla = new int[objetos.length][volumenMaximo + 1];
        
        for (int i = 0; i < objetos.length; i++) {
            tabla[i][0] = 0;
        }
        
        for (int j = 0; j <= volumenMaximo; j++) {
            tabla[0][j] = 0;
        }
        
        for (int i = 1; i < objetos.length; i++) {
            for (int j = 1; j <= volumenMaximo; j++) {
                Objeto obj = objetosOriginales[i]; 
                if(obj.getVolumen() > j) {
                    tabla[i][j] = tabla[i-1][j];
                } else {
                    tabla[i][j] = Integer.max(tabla[i-1][j], 
                            tabla[i-1][j-obj.getVolumen()] + obj.getBeneficio());
                }
            }
        }
    }
    
    /**
     * Devuelve la lista de objetos seleccionados por el algoritmo
     * @param salida Los objetos seleccionados
     */
    public void objetosMochila(ArrayList<Objeto> salida) {
        int w = volumenMaximo;
        
        for (int i = objetosOriginales.length - 1; i > 0; i--) {
            if (tabla[i][w] != tabla[i-1][w]) {
                salida.add(objetosOriginales[i]);
                w -= objetosOriginales[i].getVolumen();
            }
        }
    }
    
    /**
     * Traza la tabla del algoritmo
     * @param salida Recurso de salida
     */
    public void trazarResultado(PrintStream salida) {
        salida.print("Límite volumen       |");
        for (int i = 0; i <= volumenMaximo; i++) {
            salida.print(String.format("%4s", Integer.toString(i)));
        }
        salida.println();
        salida.print("---------------------|");
        for (int i = 0; i <= volumenMaximo; i++) {
            salida.print("----");
        }
        salida.println();

        for (int i = 0; i < objetosOriginales.length; i++) {
            if (i == 0) {
                salida.print("posición 0           |");
            } else {
                salida.print(String.format("v%1$d = %2$3s  b%1$d = %3$3s", i, 
                        Integer.toString(objetosOriginales[i].getVolumen()),
                        Integer.toString(objetosOriginales[i].getBeneficio())));
                if (i < 10) {
                    salida.print("   |");
                } else {
                    salida.print(" |");
                }
            }
            for (int j = 0; j <= volumenMaximo; j++) {
                salida.print(String.format("%4s", Integer.toString(tabla[i][j])));
            }
            salida.println();
        }

        salida.println();
    }
}
