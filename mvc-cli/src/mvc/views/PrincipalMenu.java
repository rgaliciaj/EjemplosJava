/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.views;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.connection.ConnectionDB;

/**
 *
 * @author Pablo Jacobo
 */
public class PrincipalMenu {
    ConnectionDB cnn = new ConnectionDB();
    
    public void Menu() throws ClassNotFoundException{
        System.out.println("holass");
        try {
            String sql = "SELECT * FROM TB_OWNER";
            cnn.open();
            ResultSet rs = this.cnn.executeQuery(sql);
            while( rs.next()) {
                System.out.println(" name "+ rs.getString("NAME_OWNER"));
            }
            cnn.close();
        } catch (Exception ex) {
            Logger.getLogger(PrincipalMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
