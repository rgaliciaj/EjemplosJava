/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejobjetos;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ronald Galicia
     */
public class EjObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Lista de personas
        Persona persona_1 = new Persona("Ronald");
        Persona persona_2 = new Persona("Pablo");
        Persona persona_3 = new Persona("David");
        
        List<Persona> ListaPersona = Arrays.asList(persona_1, persona_2, persona_3);
        
        /*for(Persona persona : ListaPersona){
            System.out.println("Persona es: " + persona.nombre);
        }*/
        
        //Lista de habilidades
        Habilidad habilidad_1 = new Habilidad("Matematica, IO");
        Habilidad habilidad_2 = new Habilidad("Progra, SOP");
        Habilidad habilidad_3 = new Habilidad("Electronica");
        
        List<Habilidad> ListaHabilidad = Arrays.asList(habilidad_1, habilidad_2, habilidad_3);
        
        /*for(Habilidad habilidad : ListaHabilidad){
            System.out.println("Habilidad: " + habilidad.nombreHabilidad);
        }*/
        
        for(int i=0; i < ListaPersona.size(); i++) {
            switch(i){
                case 0:
                    System.out.println("Alumno " + ListaPersona.get(i).nombre + " es bueno en: " + ListaHabilidad.get(i).nombreHabilidad );
                break;
                case 1:
                    System.out.println("Alumno " + ListaPersona.get(i).nombre + " es bueno en: " + ListaHabilidad.get(i).nombreHabilidad );
                break;
                case 2:
                    System.out.println("Alumno " + ListaPersona.get(i).nombre + " es bueno en: " + ListaHabilidad.get(i).nombreHabilidad );
                break;
            }
        }
        
    }
    
}
