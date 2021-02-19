/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplejavamysql;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ronald Galicia
 */
public class ExampleJavaMySQL {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
    /**
     *
     * @param obj
     * @return
     */
        
    String url = "jdbc:mysql://localhost:3306/parking";
    String user = "root";
    String password = "";
    Statement stmt = null;
    ResultSet rs = null;

    //Listar data DB - propietarios
    try{
        //configuracion de coneccion
        Connection conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM TB_OWNER;");
        
        List<Owner> owners = new ArrayList();

        System.out.println("---Lista de Propietarios---");
        while(rs.next()){
            Owner owner = new Owner();
            owner.setIdOwner(rs.getInt("ID_OWNER"));
            owner.setNameOwner(rs.getString("NAME_OWNER"));
            owners.add(owner);
        }
        
        for(Owner own : owners){
            System.out.println("idOwner: " + own.idOwner);
            System.out.println("NameOwner: " + own.nameOwner);
        }

    } catch (SQLException ex) {
            Logger.getLogger(ExampleJavaMySQL.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    //Lista de autos
    try{
        Connection conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM TB_CAR;");
        
        List<Car> cars = new ArrayList();
        
        System.out.println("---Lista de Automoviles---");
        while(rs.next()){
            Car car = new Car();
            
            car.setIdCar(rs.getInt("ID_CAR"));
            car.setBrand(rs.getString("BRAND"));
            car.setIdOwner(rs.getInt("ID_OWNER"));
            cars.add(car);
        }
        
        for(Car car : cars){
            System.out.println("idCar: " + car.idCar);
            System.out.println("brand: " + car.brand);
            System.out.println("idOwner: " + car.idOwner);
        }
        
    } catch (SQLException ex) {
            Logger.getLogger(ExampleJavaMySQL.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
}
