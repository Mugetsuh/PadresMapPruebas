/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Menu {

    /**
     * Mapa que guarda el arbol de personas
     */
    public HashMap<Integer, Persona> mapaAbuelo;
    /**
     * Metodo para capturar la entrada por consola
     */
    Scanner sc = new Scanner(System.in);
    /**
     * Variable para capturar la entrada por consola
     */
    int codigo;
    /**
     * Lista String para enviar el resultar de la busqueda
     */
    ArrayList<String> Listabusqueda = new ArrayList<String>();
    
    /**
     * Metodo donde inicial el programa
     */
    public void Menu() {      
        System.out.println("Digite el codigo que desea buscar:");
        codigo = sc.nextInt();
        mapaAbuelo = new HashMap<>();
        quemarMapa();
        buscar(mapaAbuelo,codigo);
    }

    /**
     * Metodo para quemar los datos del árbol
     */
    public void quemarMapa() {
        mapaAbuelo = new HashMap<>();
        mapaAbuelo.put(1, new Persona(1, "Juan", "Galindo"));
        mapaAbuelo.put(2, new Persona(2, "Jose", "Ordoñez"));
        mapaAbuelo.get(1).getDatos().put(3, new Persona(3, "Andres", "Galindo"));
        mapaAbuelo.get(1).getDatos().put(4, new Persona(4, "Maria", "Galindo"));
        mapaAbuelo.get(1).getDatos().put(5, new Persona(5, "Carlos", "Ordoñez"));
        mapaAbuelo.get(2).getDatos().put(6, new Persona(6, "Alberto", "Galindo"));
        mapaAbuelo.get(2).getDatos().put(7, new Persona(7, "Jimmy", "Galindo"));
        mapaAbuelo.get(2).getDatos().put(8, new Persona(8, "Jhon", "Ordoñez"));
        mapaAbuelo.get(1).getDatos().get(3).getDatos().put(9, new Persona(9, "Juana", "Galindo"));
        mapaAbuelo.get(1).getDatos().get(3).getDatos().put(10, new Persona(10, "Paola", "Galindo"));
        mapaAbuelo.get(1).getDatos().get(4).getDatos().put(11, new Persona(11, "Sofia", "Galindo"));
        mapaAbuelo.get(1).getDatos().get(5).getDatos().put(12, new Persona(12, "Jaime", "Galindo"));
        mapaAbuelo.get(2).getDatos().get(6).getDatos().put(13, new Persona(13, "Tatiana", "Ordoñez"));
        mapaAbuelo.get(2).getDatos().get(6).getDatos().put(14, new Persona(14, "Fernanda", "Ordoñez"));
        mapaAbuelo.get(2).getDatos().get(7).getDatos().put(15, new Persona(15, "Viviana", "Ordoñez"));
        mapaAbuelo.get(2).getDatos().get(8).getDatos().put(16, new Persona(16, "Diana", "Ordoñez"));
    }

    /**
     * Metodo que busca por el documento que le corresponde a cada persona
     * @param mapaAbuelo Mapa con el cual se hara la busqueda
     * @param codigo codigo de la persona que se desea buscar
     */
    public ArrayList<String> buscar(HashMap<Integer, Persona> mapaAbuelo,int codigo) {
        Persona pAbuelo = null;
        Persona pPadre = null;
        Persona pHijo = null;
        for(Integer key: mapaAbuelo.keySet()){
            pAbuelo = mapaAbuelo.get(key);
            if(codigo == key){
                System.out.println("Abuelo: " + pAbuelo.getNombre());
                Listabusqueda.add(pAbuelo.getNombre());
            }
            for(Integer key2: pAbuelo.getDatos().keySet()){
                pPadre = pAbuelo.getDatos().get(key2);
                if(codigo == key2){                    
                    System.out.println("Abuelo: " + pAbuelo.getNombre());
                    Listabusqueda.add(pAbuelo.getNombre());
                    System.out.println("            Padre: " + pPadre.getNombre());
                    Listabusqueda.add(pPadre.getNombre());
                }
                if(codigo == key){
                    System.out.println("            Padre : " + pPadre.getNombre());
                    Listabusqueda.add(pPadre.getNombre());
                }
                for(Integer key3: pPadre.getDatos().keySet()){
                    pHijo = pPadre.getDatos().get(key3);
                    if(codigo == key3){      
                        System.out.println("Abuelo: " + pAbuelo.getNombre());
                        Listabusqueda.add(pAbuelo.getNombre());
                        System.out.println("          Padre: " + pPadre.getNombre()); 
                        Listabusqueda.add(pPadre.getNombre());
                        System.out.println("                     Hijo: " + pHijo.getNombre());
                        Listabusqueda.add(pHijo.getNombre());
                        break;
                    }
                    if(codigo == key2){
                        System.out.println("                     Hijo: " + pHijo.getNombre());
                        Listabusqueda.add(pHijo.getNombre());
                    }
                    if(codigo == key){
                        System.out.println("                     Hijo: " + pHijo.getNombre());
                        Listabusqueda.add(pHijo.getNombre());
                    }
                }
            }
        }        
        return Listabusqueda;
    }
    
}
