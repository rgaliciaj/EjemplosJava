/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplejavamysql;

/**
 *
 * @author Ronald Galicia
 */
public class Owner {
    int idOwner;
    String nameOwner;

    public Owner(int idOwner, String nameOwner) {
        this.idOwner = idOwner;
        this.nameOwner = nameOwner;
    }

    public Owner() {
    
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }
}
