/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignacion1;

import java.util.List;

/**
 *
 * @author Ronald Galicia
 */
public class AsignClienteCarro {
    int idPersona;
    String name;
    List<Carro> carrosList;

    public AsignClienteCarro(int idPersona, String name, List<Carro> carrosList) {
        this.idPersona = idPersona;
        this.name = name;
        this.carrosList = carrosList;
    }
}
