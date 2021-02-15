/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pablo Jacobo
 */
public class Controller {
    
    public Map<String, String> obtenerNumero(int index) {
        Map<String, String> response = new HashMap();
        try {
            List<Integer> numbers = Arrays.asList(1,2,3,4 );
            response.put("index", numbers.get(index).toString());
            response.put("status", "todo ok");
        } catch(ArrayIndexOutOfBoundsException exception) {
            response.put("exc", exception.toString());
            response.put("status", "todo mal :(");
        }
       
        return response;
    }
        
    public void Init() {
        Map<String, String> resultMap =  this.obtenerNumero( 100 );
        System.out.println(" el mapa de resultado es " + resultMap );
    }
   
}
