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
        System.out.println(" 3. actualizar los owners ");
        System.out.println(" 4. Eliminar un owner ");
        System.out.println(" 5. Registrar un carro");
        System.out.println(" 6. Listar todos los carros");
        System.out.println(" 7. Actualizar los carros");
        System.out.println(" 8. Eliminar un carro");
        System.out.print(" Ingrese la opcion... ");

        int selection = Integer.parseInt(this.entradaDeDatos.nextLine());

        if (selection == 1) {
            this.RegisterOwener();
        }

        if (selection == 2) {
            this.ListOweners();
        }

        if (selection == 3) {
            this.updateOwner();
        }
        if (selection == 4) {
            this.deleteOwner();
        }
        if (selection == 5) {
            this.RegisterCar();
        }

        if (selection == 6) {
            this.listCars();
        }

        if (selection == 7) {
            this.UpdateCar();
        }

        if (selection == 8) {
            
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

        for (Owner o : ownersDB) {
            System.out.println(" id = " + o.getIdOwner());
            System.out.println(" name = " + o.getNameOwner());
        }

    }

    public void updateOwner() {
        List<Owner> ownersDB = new ArrayList();
        ownersDB = this.oDao.allOweners();

        /*for(Owner o: ownersDB) {
         System.out.println(" id = " + o.getIdOwner());
         System.out.println(" name = " + o.getNameOwner());
         }*/
        System.out.println(" escribe el id del owner a actualizar ");
        int vIdOwner = Integer.parseInt(this.entradaDeDatos.nextLine());
        System.out.println(" escribe el nuevo nombre.... ");
        String vName = this.entradaDeDatos.nextLine();

        Owner ow = new Owner();
        //setting values from set
        ow.setIdOwner(vIdOwner);
        ow.setNameOwner(vName);
        Owner ownerUpdate = this.oDao.updateOwner(ow);

        System.out.println("persona actualizada name " + ownerUpdate.getNameOwner());
        System.out.println("persona actualizada id " + ownerUpdate.getIdOwner());

        this.Menu();
    }

    public void deleteOwner() {
        boolean resultOperation = false;

        System.out.print("Ingrese id de owner a eliminar ");
        int vIdOwner = this.entradaDeDatos.nextInt();
        resultOperation = this.oDao.deleteOwner(vIdOwner);

    }

    public void RegisterCar() {
        System.out.print("Escribe la marca ");
        String vBrand = this.entradaDeDatos.nextLine();
        System.out.print("Escribe el Id de owner ");
        int vIdOwner = Integer.parseInt(this.entradaDeDatos.nextLine());
        Car newCar = new Car(vBrand, vIdOwner);
        this.carDao.addNewCar(newCar);
    }

    public void listCars() {
        List<Car> carsDB = new ArrayList();
        carsDB = this.carDao.allCars();

        for (Car cc : carsDB) {
            System.out.println("ID car: " + cc.getIdCar());
            System.out.println("car brand: " + cc.getBrand());
            System.out.println("Id owner: " + cc.getIdOwner());
        }
    }

    public void UpdateCar() {
        List<Car> carDB = new ArrayList();
        carDB = this.carDao.allCars();
        
        System.out.print("Escriba el id de carro a actualizar ");
        int vIdCar = Integer.parseInt(this.entradaDeDatos.nextLine());
        System.out.print("Escribe la marca del carro ");
        String vBrand = this.entradaDeDatos.nextLine();
        System.out.print("Escriba el id del owner del carro ");
        int vIdOwner = Integer.parseInt(this.entradaDeDatos.nextLine());
        
        Car car = new Car();
        
        car.setIdCar(vIdCar);
        car.setBrand(vBrand);
        car.setIdOwner(vIdOwner);
        
        Car carUpdate = this.carDao.updateCar(car);
        
    }

}
