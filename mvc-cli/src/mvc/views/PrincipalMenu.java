/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mvc.dao.CarDao;
import mvc.models.Owner;
import mvc.dao.OwnerDao;
import mvc.models.Car;

/**
 *
 * @author Pablo Jacobo
 */
public class PrincipalMenu {
    Scanner entradaDeDatos = new Scanner(System.in);
    OwnerDao oDao = new OwnerDao();
    CarDao carDao = new CarDao();
    
    public void Menu() {
        System.out.println(" 1. Registrar un owner ");
        System.out.println(" 2. Listar todos los owners ");
        System.out.println(" 3. Registar un car ");
        System.out.println(" 4. Listar todos los cars ");
        System.out.print(" Ingrese la opcion... ");
        int selection =  Integer.parseInt(this.entradaDeDatos.nextLine());
        
        if ( selection == 1) {
            this.RegisterOwener();
        }
        
        if(  selection == 2) {
            this.ListOweners();
        }
        
        if( selection == 3){
            this.RegisterCar();
        }
        
    }
    
    
    
    public void RegisterOwener() {
        System.out.println("escribe el nombre ");
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
    
    public void RegisterCar() {
        System.out.print("Escribe la marca ");
        String vBrand = this.entradaDeDatos.nextLine();
        System.out.print("Escribe el Id de owner ");
        int vIdOwner = Integer.parseInt(this.entradaDeDatos.nextLine());
        Car newCar = new Car(vBrand, vIdOwner);
        this.carDao.addNewCar(newCar);
    }
    
    
}
