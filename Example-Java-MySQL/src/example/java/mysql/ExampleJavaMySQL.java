/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.java.mysql;

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
public class ExampleJavaMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost:3306/UsersEE";
        String user = "root";
        String password = "";
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TB_USERS");
            
            //insert
            String query = "INSERT INTO TB_USERS(NAME_USER, PASS_USER) VALUES('foo', 'bar')";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
            
            // listar
            while( rs.next() ){
                System.out.println(" name " +  rs.getString("NAME_USER"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExampleJavaMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
