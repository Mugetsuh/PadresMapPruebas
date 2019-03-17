/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller2;

import java.util.HashMap;

/**
 *
 * @author Diego
 */
public class Persona {
    
    /**
     * Docuemento de la persona
     */
    private int documento;
    /**
     * Nombre de la persona
     */
    private String nombre;
    /**
     * Apellido de la persona
     */
    private String apellido;
    /**
     * Mapa de persona
     */
    private HashMap<Integer,Persona> datos;

    /**
     * Constructor de la clase Persona
     * @param documento Documento de la persona
     * @param nombre    Nombre de la persona
     * @param apellido  Apellido de la persona
     */
    public Persona(int documento, String nombre, String apellido) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        datos = new HashMap<>();
    }

    public int getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public HashMap<Integer, Persona> getDatos() {
        return datos;
    }
    
}
