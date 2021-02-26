/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Ronald Galicia
 */
public class Car {
    int idCar;
    String brand;
    int idOwner;

    public Car(int idCar, String brand, int idOwner) {
        this.idCar = idCar;
        this.brand = brand;
        this.idOwner = idOwner;
    }
    
    public Car(String brand, int idOwner){
        this.brand = brand;
        this.idOwner = idOwner;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }
}
