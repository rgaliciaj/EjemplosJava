/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mvc.models.Owner;
import mvc.dao.OwnerDao;

/**
 *
 * @author Pablo Jacobo
 */
public class PrincipalMenu {
    Scanner entradaDeDatos = new Scanner(System.in);
    OwnerDao oDao = new OwnerDao();
    

    public void Menu() {
        System.out.println(" 1. Registrar un owner ");
        System.out.println(" 2. Listar todos los owners ");
        System.out.println(" 3. actualizar los owners ");
        int selection =  Integer.parseInt(this.entradaDeDatos.nextLine());
        
        if ( selection == 1) {
            this.RegisterOwener();
        }
        
        if(  selection == 2) {
            this.ListOweners();
        }
        
        if( selection == 3 ) {
            this.updateOwner();
        }
        
    }
    
    
    public void RegisterOwener() {
        System.out.println("escribe el nombre");
        String vName = this.entradaDeDatos.nextLine();
        Owner ownerObject = new Owner(vName);
        this.oDao.addNewOwner(ownerObject);
    }
    
    public void ListOweners() {
       List<Owner> ownersDB = new ArrayList();
       ownersDB = this.oDao.allOweners();
       
        for(Owner o: ownersDB) {
            System.out.println(" id = " + o.getIdOwner());
            System.out.println(" name = " + o.getNameOwner());
        }
       
    }
    
    public void updateOwner(){
        List<Owner> ownersDB = new ArrayList();
       ownersDB = this.oDao.allOweners();
       
        for(Owner o: ownersDB) {
            System.out.println(" id = " + o.getIdOwner());
            System.out.println(" name = " + o.getNameOwner());
        }
        System.out.println(" escribe el id del owner a actualizar ");
        int vIdOwner = Integer.parseInt(this.entradaDeDatos.nextLine());
        System.out.println(" escribe el nuevo nombre.... ");
        String vName = this.entradaDeDatos.nextLine();
        
        Owner ow = new Owner();
        //setting values from set
        ow.setIdOwner(vIdOwner);
        ow.setNameOwner(vName);
        Owner ownerUpdate = this.oDao.updateOwner(ow);
        
        System.out.println("persona actualizada name "+ ownerUpdate.getNameOwner());
        System.out.println("persona actualizada id "+ ownerUpdate.getIdOwner());
        
        this.Menu();
     
    }
    
    
}
