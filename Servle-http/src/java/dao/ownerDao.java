/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Owner;
import utils.ConnectionDB;

/**
 *
 * @author Ronald Galicia
 */
public class ownerDao{
    ConnectionDB cn = new ConnectionDB();
    String sql = "";
    
    public void addOwner(Owner owner)  throws Exception {
        try {
            this.cn.open();
            this.sql = "INSERT INTO TB_OWNER(NAME_OWNER) VALUES('"+ owner.getNameOwner()+"')";
            System.out.println(" slq = "+ this.sql  );
            this.cn.close();
        } catch (Exception ex) {
            Logger.getLogger(ownerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
