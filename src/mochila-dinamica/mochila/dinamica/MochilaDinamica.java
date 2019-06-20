/*
 * Archivo: MochilaDinamica.java
 * Autor: Carlos Caride Santeiro
 * DNI: 44446239G
 * Email: ccaride5@alumno.uned.es
 * Fecha: 15/12/2017
 * Asignatura: Programación y Estructuras de Datos Avanzadas.
 * Trabajo: Práctica 2 (2017-2018)
 */

package mochila.dinamica;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Clase principal de la aplicación
 */
public class MochilaDinamica {

    /**
     * Punto de entrada de la aplicación
     */
    public static void main(String[] args) throws IOException {
        boolean traza = false;
        String ficheroIn = "";
        String ficheroOut = "";
        int desfaseArgumentos = 0;
        
        if (args.length == 0) {
            System.out.println("ERROR: Sintaxis incorrecta");
            imprimirAyuda();
            return;
        }
        if (args[0].equalsIgnoreCase("-h")){
            imprimirAyuda();
            return;
        }
        
        if (args[0].equalsIgnoreCase("-t")){
            traza = true;
            desfaseArgumentos++;
        }
        
        if (args.length <= desfaseArgumentos) {
            System.out.println("ERROR: Pocos argumentos");
            imprimirAyuda();
            return;
        }
        
        ficheroIn = args[desfaseArgumentos++];
        
        if (args.length > desfaseArgumentos) {
            ficheroOut = args[desfaseArgumentos];
        }
        
        PrintStream ps;
        if (ficheroOut.isEmpty()) {
            ps = System.out;
        } else {
            File f = new File(ficheroOut);
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            ps = new PrintStream(f);
        }
        
        Mochila mochila = new Mochila();
        
        if (!mochila.leerDatos(ficheroIn)) {
            return;
        }
        
        mochila.resolver();
        mochila.imprimirContenido(traza, ps);
        
        if (!ficheroOut.isEmpty()) {
            ps.close();
        }
    }
    
    /**
     * Imprime la ayuda que se le mostrará al usuario
     */
    private static void imprimirAyuda() {
        System.out.println("SINTAXIS:");
        System.out.println("mochila-dinamica [-t] [-h] [fichero_entrada] [fichero_salida]");
        System.out.println("-t               Traza la selección de clientes");
        System.out.println("-h               Muestra esta ayuda");
        System.out.println("fichero_entrada  Nombre del fichero de entrada");
        System.out.println("fichero_salida   Nombre del fichero de salida");
    }
}
