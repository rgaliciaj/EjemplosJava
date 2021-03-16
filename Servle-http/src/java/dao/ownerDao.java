/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
<<<<<<< HEAD
=======

import java.util.ArrayList;
import java.util.List;
>>>>>>> dceefb75ba012c8bc0a87cf2acbebbfb429f984e
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Owner;
import utils.ConnectionDB;
<<<<<<< HEAD

=======
>>>>>>> dceefb75ba012c8bc0a87cf2acbebbfb429f984e
/**
 *
 * @author Ronald Galicia
 */
<<<<<<< HEAD
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
    
=======
public class ownerDao {
    ConnectionDB conn = new ConnectionDB();
    String sql = "";
>>>>>>> dceefb75ba012c8bc0a87cf2acbebbfb429f984e
    
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
    
    public List<Owner> allOwnerList(){
        List<Owner> ownerList = new ArrayList();
        
        
        return null;
    }
}
