/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrarlistas;

import java.util.ArrayList;

/**
 *
 * @author Ronald Galicia
 */
public class FiltrarListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> words = new ArrayList();
        
        words.add("spray");
        words.add("limit");
        words.add("elite");
        words.add("destruction");
        words.add("exuberant");
        words.add("present");
        
        System.out.println("---Lista de palabras---");
        for(int i=0; i < words.size(); i++){
            System.out.println("Elemento " + i + ": " + words.get(i));
        }
        System.out.println("");
        System.out.println("---Lista de palabras mayores a 6 letras---");
        words.stream().filter(word -> word.length() > 6).forEach(element -> {
            System.out.println("Elemento filtrado: " + element);
        });
        
        /*----------------------------------------------------------------------
        Result:
        
        ---Lista de palabras---
        Elemento 0: spray
        Elemento 1: limit
        Elemento 2: elite
        Elemento 3: destruction
        Elemento 4: exuberant
        Elemento 5: present

        ---Lista de palabras mayores a 6 letras---
        Elemento filtrado: destruction
        Elemento filtrado: exuberant
        Elemento filtrado: present
        ------------------------------------------------------------------------
        */
    }
    
}