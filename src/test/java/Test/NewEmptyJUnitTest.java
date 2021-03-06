/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.mycompany.taller2.Menu;
import com.mycompany.taller2.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author German
 */
public class NewEmptyJUnitTest {
    
    static Menu m;
    static Persona p;
    static HashMap<Integer, Persona> mapaAbuelo;
    static ArrayList<String> respuesta;
    static ArrayList<String> comparar;
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        m = new Menu();
        mapaAbuelo = new HashMap<>();
        respuesta = new ArrayList<String>(); 
        comparar = new ArrayList<String>();
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
    
    @AfterClass
    public static void tearDownClass() {
        m = null;
        p = null;
        mapaAbuelo = null;
        respuesta = null;
        comparar = null;
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }   
    
    @Test
    public void testAbuelo(){       
        comparar.add("Jose");
        comparar.add("Alberto");
        comparar.add("Tatiana");
        comparar.add("Fernanda");
        comparar.add("Jimmy");
        comparar.add("Viviana");
        comparar.add("Jhon");
        comparar.add("Diana");
        respuesta = m.buscar(mapaAbuelo, 2);
        assertEquals(comparar, respuesta);
    }
    
    @Test
    public void testPadre(){        
  
        comparar.add("Juan");
        comparar.add("Carlos");
        comparar.add("Jaime");
        respuesta = m.buscar(mapaAbuelo, 5);
        assertEquals(comparar, respuesta);
    }
    
    @Test
    public void testHijo(){        
        comparar.add("Juan");
        comparar.add("Maria");
        comparar.add("Sofia");
        respuesta = m.buscar(mapaAbuelo, 11);
        assertEquals(comparar, respuesta);
    }
}
