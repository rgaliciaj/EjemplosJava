/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo Jacobo
 */
public class ConnectionDB {
    String url = "jdbc:mysql://localhost:3306/parking";
    String user = "root";
    String password = "";
    Connection conn = null;
    PreparedStatement preparedStatement = null; 
    ResultSet resultSet = null;
    
    public Connection open() {  
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public void close() throws Exception{
        try {
            if (conn != null){
                conn.clearWarnings();
                conn.close();                
            }
        } catch (SQLException e) {
            conn = null;
            throw new Exception(e.getMessage());
        }
    }
    
    public boolean executeSql (String cmd) throws Exception{
        int counterRows = 0;
        if (cmd != null) {
            this.preparedStatement = this.conn.prepareStatement(cmd);
            counterRows = this.preparedStatement.executeUpdate();
        } else {
            throw new Exception("El comando a ejecutar es nulo!");
        }
            
        return  (counterRows > 0 );
    }
    
    public ResultSet executeQuery (String strSQL){
        if (strSQL != null) {
            try {
                this.preparedStatement = conn.prepareStatement(strSQL);
                this.resultSet =  this.preparedStatement.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return this.resultSet;
    }
    
}
