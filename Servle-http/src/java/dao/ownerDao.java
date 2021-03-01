/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Owner;
import utils.ConnectionDB;
/**
 *
 * @author Ronald Galicia
 */
public class ownerDao {
    ConnectionDB conn = new ConnectionDB();
    String sql = "";
    List<Owner> ownerList = new ArrayList();
    
    public void registerOwner(Owner own) {
        
        try {
            this.conn.open();
            this.sql = "INSERT INTO TB_OWNER(NAME_OWNER) VALUES('"+ own.getNameOwner() +"');";
            boolean result = this.conn.executeSql(sql);
            System.out.println("result = " + result);
            this.conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ownerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
