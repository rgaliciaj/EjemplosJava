/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.interfaces.CarInterface;
import mvc.models.Car;
import mvc.connection.ConnectionDB;
/**
 *
 * @author Ronald Galicia
 */
public class CarDao implements CarInterface {
    ConnectionDB conn = new ConnectionDB();
    String sql = "";
    
    @Override
    public void addNewCar(Car car) {
        
        try {
            this.conn.open();
            this.sql = "INSERT INTO TB_CAR(BRAND, ID_OWNER) VALUES('" + car.getBrand() +"', " + car.getIdOwner() + " );";
            boolean resultado = this.conn.executeSql(sql);
            System.out.println("resultado = " + resultado);
            this.conn.close();
        } catch (Exception ex) {
            Logger.getLogger(CarDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
