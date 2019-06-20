/*
 * Archivo: Mochila.java
 * Autor: Carlos Caride Santeiro
 * DNI: 44446239G
 * Email: ccaride5@alumno.uned.es
 * Fecha: 15/12/2017
 * Asignatura: Programación y Estructuras de Datos Avanzadas.
 * Trabajo: Práctica 2 (2017-2018)
 */

package mochila.dinamica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import mochila.dinamica.algoritmos.MochilaEntera;

/**
 * Representa la mochila en la que se introducen los objetos
 */
public class Mochila {
    
    private int capacidadMaxima;
    private ArrayList<Objeto> objetosEnMochila;
    private Objeto[] objetosOriginales;
    MochilaEntera algoritmo;
    
    /**
     * Inicializa una nueva mochila vacía.
     */
    public Mochila() {
        objetosEnMochila = new ArrayList<Objeto>();
    }
    
    /**
     * Inicializa una nueva mochila indicando el volumen máximo
     * @param capacidad Volumen máximo que puede contener la mochila
     */
    public Mochila(int capacidad) {
        this();
        capacidadMaxima = capacidad;
    }

    /**
     * Obtiene la capacidad máxima de la mochila
     * @return la capacidad máxima
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Establece la capacidad máxima de la mochila
     * @param capacidadMaxima la capacidad máxima
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    /**
     * Lee la configuración de la mochila y los objetos a seleccionar
     * @param ficheroEntrada Fichero de donde leer la configuración
     * @return Verdadero en caso de no existir ningún error.
     */
    public boolean leerDatos(String ficheroEntrada) {
        FileReader reader;
        BufferedReader br;
        int numeroObjetos;
        
        
        if (ficheroEntrada.isEmpty()) {
            System.out.println("ERROR: No se indicó fichero de entrada");
            return false;
        }
        
        try {
            reader = new FileReader(ficheroEntrada);
            br = new BufferedReader(reader);

            numeroObjetos = Integer.parseInt(br.readLine());
            objetosOriginales = new Objeto[numeroObjetos + 1];
            for (int i = 1; i <= numeroObjetos; i++) {
                String[] cadena = br.readLine().split(" ");
                objetosOriginales[i] = new Objeto(Integer.parseInt(cadena[0]),
                        Integer.parseInt(cadena[1]));
            }
            capacidadMaxima = Integer.parseInt(br.readLine());
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: No se encontró el fichero de entrada");
            return false;
        } catch (IOException | NumberFormatException |
                IndexOutOfBoundsException ex) {
            System.out.println("ERROR: El formato del fichero es erróneo");
            return false;
        }
        
        return true;
    }
    
    /**
     * Resuelve la selección de objetos a contener en la mochila mediante 
     * selección por máximo beneficio
     */
    public void resolver() {
        algoritmo = new MochilaEntera(objetosOriginales, capacidadMaxima);
        algoritmo.objetosMochila(objetosEnMochila);
    }
    
    /**
     * Imprime el resultado de la selección del algoritmo
     * @param traza Verdadero si se desea imprimir la tabla del algoritmo
     * @param ps Salida de texto, fichero o consola
     */
    public void imprimirContenido(boolean traza, PrintStream ps) {
        int beneficio = 0;
        Objeto actual;

        if (traza) {
            algoritmo.trazarResultado(ps);
        }
        
        ps.print("Objetos de volumen: ");
        for (int i = 0; i < objetosEnMochila.size(); i++) {
            actual = objetosEnMochila.get(i);
            if (i != 0) {
                ps.print(", ");
            }
            ps.print(actual.getVolumen());
            beneficio += actual.getBeneficio();
        }
        ps.println();
        ps.print("Beneficio: ");
        ps.println(beneficio);
    }
}
