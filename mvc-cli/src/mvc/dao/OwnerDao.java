/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.interfaces.OwenerInterface;
import mvc.models.Owner;
import mvc.connection.ConnectionDB;

/**
 *
 * @author Pablo Jacobo
 */
public class OwnerDao implements OwenerInterface {
    ConnectionDB conn = new ConnectionDB();
    String sql = "";

    @Override
    public void addNewOwner(Owner owner) {
        try {
            this.conn.open();
            this.sql = "INSERT INTO TB_OWNER(NAME_OWNER) VALUES('"+ owner.getNameOwner() +"')";
            boolean result = this.conn.executeSql(sql);
            System.out.println("result = " + result);
            this.conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OwnerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Owner> allOweners() {
        List<Owner> owners = new ArrayList();
        try {    
            this.conn.open();
            this.sql = "SELECT * FROM TB_OWNER;";
            
            ResultSet rs = this.conn.executeQuery(sql);
            while(rs.next()) {
                Owner o = new Owner();
                o.setIdOwner(rs.getInt("ID_OWNER"));
                o.setNameOwner(rs.getString("NAME_OWNER"));
                owners.add(o);
            }
            
            this.conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OwnerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return owners;
    }

    @Override
    public Owner updateOwner(Owner owner) {
        Owner ownerDb = new Owner();
        ownerDb = this.OwnerById(owner.getIdOwner());
        // new setting
        ownerDb.setNameOwner(owner.getNameOwner());
        try {
            this.conn.open();
            this.sql = "UPDATE TB_OWNER SET NAME_OWNER = '"+ ownerDb.getNameOwner() +"' WHERE ID_OWNER = "+ ownerDb.getIdOwner() +"";
            this.conn.executeSql(this.sql);
            this.conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OwnerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ownerDb;
    }

    @Override
    public boolean deleteOwner(int idOwner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Owner OwnerById(int idOwner) {
        Owner ownerDb = new Owner();
        ownerDb = this.allOweners().stream()
            .filter(owner -> owner.getIdOwner() == idOwner)
            .findAny()
            .orElse(null);
        return ownerDb;
    }

    
}
