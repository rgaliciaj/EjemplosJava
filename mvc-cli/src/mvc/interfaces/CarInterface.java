/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.interfaces;


import java.util.List;
import mvc.models.Car;

/**
 *
 * @author Ronald Galicia
 */
public interface CarInterface {
    public void addNewCar (Car car);
    public List<Car> allCars();
    public Car updateCar (Car car);
    public Car carByID (int idCar);
    public boolean deleteCar (int idCar);
}
