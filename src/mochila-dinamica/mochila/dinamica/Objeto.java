/*
 * Archivo: Objeto.java
 * Autor: Carlos Caride Santeiro
 * DNI: 44446239G
 * Email: ccaride5@alumno.uned.es
 * Fecha: 15/12/2017
 * Asignatura: Programación y Estructuras de Datos Avanzadas.
 * Trabajo: Práctica 2 (2017-2018)
 */

package mochila.dinamica;

/**
 * Representa un objeto que puede ser introducido en la mochila
 */
public class Objeto {
    
    private int volumen;
    private int beneficio;
    
    /**
     * Constructor por defecto
     */
    public Objeto() {
        
    }
    
    /**
     * Constructor indicando el volumen y el beneficio del objeto
     * @param volumen el volumen que ocupa el objeto
     * @param beneficio el beneficio que reporta el objeto
     */
    public Objeto(int volumen, int beneficio) {
        this.volumen = volumen;
        this.beneficio = beneficio;
    }

    /**
     * Obtiene el volumen del objeto
     * @return el volumen que ocupa el objeto
     */
    public int getVolumen() {
        return volumen;
    }

    /**
     * Establece el volumen del objeto
     * @param volumen el volumen que ocupa el objeto
     */
    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    /**
     * Obtiene el beneficio del objeto
     * @return el beneficio que reporta el objeto
     */
    public int getBeneficio() {
        return beneficio;
    }

    /**
     * Establece el beneficio del objeto
     * @param beneficio el beneficio que reporta el objeto
     */
    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }
    
    /**
     * Obtiene la relación entre beneficio y volumen (beneficio/volumen)
     * @return la relación entre beneficio y volumen
     */
    public float getRelacion() {
        return (float)beneficio/(float)volumen;
    }
}
