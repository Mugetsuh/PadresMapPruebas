/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Menu {

    public HashMap<Integer, Persona> mapaAbuelo;

    public void Menu() {

        quemarMapa();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el codigo que desea buscar:");
        int codigo = sc.nextInt();
        buscar(codigo);
    }

    private void quemarMapa() {
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
/*
    private void buscar(int codigo) {
        if (mapaAbuelo.containsKey(codigo)) {
            System.out.println("Abuelo: " + mapaAbuelo.get(codigo).getNombre() + " " + mapaAbuelo.get(codigo).getApellido()
                    + " Padres :");

            Iterator it = mapaAbuelo.get(codigo).getDatos().keySet().iterator();
            while (it.hasNext()) {
                int i = Integer.parseInt(it.next().toString());
                System.out.println(mapaAbuelo.get(codigo).getDatos().get(i).getNombre() + " "
                        + mapaAbuelo.get(codigo).getDatos().get(i).getApellido() + ".");

                System.out.println("Nietos: ");
                Iterator itera = mapaAbuelo.get(codigo).getDatos().get(i).getDatos().keySet().iterator();
                while (itera.hasNext()) {
                    int j = Integer.parseInt(itera.next().toString());
                    System.out.println(mapaAbuelo.get(codigo).getDatos().get(i).getDatos().get(j).getNombre() + " "
                            + mapaAbuelo.get(codigo).getDatos().get(i).getDatos().get(j).getApellido());
                }
            }
        } else {
            Iterator it = mapaAbuelo.keySet().iterator();
            while (it.hasNext()) {
                int i = Integer.parseInt(it.next().toString());
                if (mapaAbuelo.get(i).getDatos().containsKey(codigo)) {
                    System.out.println("Padre: " + mapaAbuelo.get(i).getDatos().get(codigo).getNombre() + " "
                            + mapaAbuelo.get(i).getDatos().get(codigo).getApellido() + " Abuelo : "
                            + mapaAbuelo.get(i).getNombre() + " " + mapaAbuelo.get(i).getApellido() + " Hijos: ");

                    Iterator itera = mapaAbuelo.get(i).getDatos().get(codigo).getDatos().keySet().iterator();

                    while (itera.hasNext()) {
                        int j = Integer.parseInt(itera.next().toString());
                        System.out.println(mapaAbuelo.get(i).getDatos().get(codigo).getDatos().get(j).getNombre() + " "
                                + mapaAbuelo.get(i).getDatos().get(codigo).getDatos().get(j).getApellido());
                    }
                } else {
                    Iterator itera = mapaAbuelo.get(i).getDatos().keySet().iterator();
                    while (itera.hasNext()) {
                        int j = Integer.parseInt(itera.next().toString());
                        if (mapaAbuelo.get(i).getDatos().get(j).getDatos().containsKey(codigo)) {
                            System.out.println("Hijo " + mapaAbuelo.get(i).getDatos().get(j).getDatos().get(codigo).getNombre()
                                    + " " + mapaAbuelo.get(i).getDatos().get(j).getDatos().get(codigo).getApellido()
                                    + " Padre" + mapaAbuelo.get(i).getDatos().get(j).getNombre() + " "
                                    + mapaAbuelo.get(i).getDatos().get(j).getApellido() + "\n Abuelo: " + mapaAbuelo.get(i).getNombre()
                                    + " " + mapaAbuelo.get(i).getApellido());
                        }
                    }
                }
            }
        }
    }
*/

    private void buscar(int codigo) {
        
       boolean verificar = false;
       
        for (Integer key : mapaAbuelo.keySet()) {
            Persona pAbuelo = mapaAbuelo.get(key);
            if (codigo == pAbuelo.getDocumento()) {
                verificar = true;
            }
    //        System.out.println(pAbuelo.getNombre());
            for (Integer key2 : pAbuelo.getDatos().keySet()) {
                Persona pPadre = pAbuelo.getDatos().get(key2);
                if (codigo == pPadre.getDocumento()) {
                    verificar = true;
                }
    //            System.out.println("   " + pPadre.getNombre());
                for (Integer key3 : pPadre.getDatos().keySet()) {
                    Persona pHijo = pPadre.getDatos().get(key3);
                    if (codigo == pHijo.getDocumento()) {
                        verificar = true;                        
                    }
                    if ( verificar == true) {
                        System.out.println("Abuelo:  " + pAbuelo.getNombre());
                        System.out.println("         Padre:  " + pPadre.getNombre());
                        System.out.println("                     Hijo : " + pHijo.getNombre());
                        verificar = false;
                        
                    }
    //                System.out.println("       " + pHijo.getNombre());
                }
            }
            
        }
        
    }
    
}
