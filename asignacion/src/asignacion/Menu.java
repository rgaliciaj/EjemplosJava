/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Pablo Jacobo
 */
public class Menu {
    List<Persona> persons = new ArrayList();
    List<Carro> cars  = new ArrayList();
    List<AsignClienteCarro>  nuevaListaPersonasYCarros = new ArrayList();
    
    
    public void Ejecutar() {
        Persona persona_1 = new Persona(1, "jorge");
        Persona persona_2 = new Persona(2, "david");
        Persona persona_3 = new Persona(3, "andres");
        
        persons =  Arrays.asList(persona_1, persona_2, persona_3);
        
        Carro carro_1 = new Carro(1, "toyota",  1);
        Carro carro_2 = new Carro(2, "honda",  1);
        Carro carro_3 = new Carro(3, "rolls-royce",  2);
        Carro carro_4 = new Carro(4, "mclaren 720s",  2);
        Carro carro_5 = new Carro(5, "ford",  2);
        Carro carro_6 = new Carro(6, "nissan",  2);
        
        cars = Arrays.asList(carro_1, carro_2, carro_3, carro_4, carro_5, carro_6);
        
        // formar la tercer estructura
        /*
            {
                idPerson: 1
                name: 'jorge',
                cars: [{...}, {...} ]
            },
        */
        for(int i=0; i < persons.size(); i ++) {
            Persona elemento = persons.get(i);
            AsignClienteCarro asignacion = new AsignClienteCarro(elemento.idPerson, elemento.name, this.buscarCarroPorPropietario(elemento.idPerson));
            this.nuevaListaPersonasYCarros.add(asignacion);
        }
        
        
        for(AsignClienteCarro elementoNuevaEstructrua: nuevaListaPersonasYCarros ) {
            System.out.println(" idPerson  " + elementoNuevaEstructrua.idPersona);
            System.out.println(" name  " + elementoNuevaEstructrua.name );
            // mostrar en otro for  los datos de la lista...
            System.out.println(" cars " + elementoNuevaEstructrua.carrosList.size());
        }
        
        
    }
    
    List<Carro> buscarCarroPorPropietario(int idPerson) {
        List<Carro> carrosEncontrados = new ArrayList();
        this.cars.stream().filter( elemento ->{
            if( elemento.idPerson == idPerson ){
                carrosEncontrados.add(elemento);
            }
            return false;
        }).collect(Collectors.toList());
        return carrosEncontrados;
    }
    
}
