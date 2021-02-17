/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplemysqlconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Jacobo
 */
public class SampleMysqlConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String urlDB = "jdbc:mysql://localhost:3306/parking";
        String username = "root";
        String password = "";
        
        try {
            // DB Config
            Connection cn = DriverManager.getConnection(urlDB, username, password);
            Statement stmt = cn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM TB_OWNER");
            
            // read data from database
            while(resultSet.next()) {
                System.out.println(" name " + resultSet.getString("NAME_OWNER"));
            }
            
            //insert data from database
            String query = "INSERT INTO TB_OWNER(NAME_OWNER) VALUES('lee byrons')";
            PreparedStatement stmtInsert = cn.prepareStatement(query);
            // save to database
            int rowsAffected = stmtInsert.executeUpdate();
            System.out.println("rows " + rowsAffected );
        } catch (SQLException ex) {
            Logger.getLogger(SampleMysqlConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
