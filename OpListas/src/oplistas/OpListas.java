/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oplistas;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ronald Galicia
 */
public class OpListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creación de listas
        List<String> persons = Arrays.asList("Pablo", "David", "Ronald");
        List<String> habilities = Arrays.asList("Progra, SOP" , "Electronica" , "tiene salud");
        
        for(int i=0; i < persons.size(); i++){
            
            switch (i){
                case 0:
                    System.out.println("Hola " + persons.get(i) + " sos bueno en " + habilities.get(i));
                break;
                case 1:
                    System.out.println("Hola " + persons.get(i) + " sos bueno en " + habilities.get(i));
                break;
                case 2:
                    System.out.println("Hola " + persons.get(i) + " gracias a Dios " + habilities.get(i));
                break;
            }
        }
    }
    
}
