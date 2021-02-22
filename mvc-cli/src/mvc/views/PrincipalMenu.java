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
<<<<<<< HEAD
        System.out.println(" 3. actualizar los owners ");
=======
        System.out.println(" 3. Registar un car ");
        System.out.println(" 4. Listar todos los cars ");
        System.out.print(" Ingrese la opcion... ");
>>>>>>> 09cfc9a35ced4346da5dc38c92e1331b3eff82a8
        int selection =  Integer.parseInt(this.entradaDeDatos.nextLine());
        
        if ( selection == 1) {
            this.RegisterOwener();
        }
        
        if(  selection == 2) {
            this.ListOweners();
        }
        
<<<<<<< HEAD
        if( selection == 3 ) {
            this.updateOwner();
=======
        if( selection == 3){
            this.RegisterCar();
        }
        if(selection == 4){
            this.listCars();
>>>>>>> 09cfc9a35ced4346da5dc38c92e1331b3eff82a8
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
    
<<<<<<< HEAD
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
    
=======
    public void RegisterCar() {
        System.out.print("Escribe la marca ");
        String vBrand = this.entradaDeDatos.nextLine();
        System.out.print("Escribe el Id de owner ");
        int vIdOwner = Integer.parseInt(this.entradaDeDatos.nextLine());
        Car newCar = new Car(vBrand, vIdOwner);
        this.carDao.addNewCar(newCar);
    }
    
    public void listCars(){
        List<Car> carsDB = new ArrayList();
        carsDB = this.carDao.allCars();
        
        for(Car cc : carsDB){
            System.out.println("ID car: " + cc.getIdCar());
            System.out.println("car brand: " + cc.getBrand());
            System.out.println("Id owner: " + cc.getIdOwner());
        }
    }
>>>>>>> 09cfc9a35ced4346da5dc38c92e1331b3eff82a8
    
}
