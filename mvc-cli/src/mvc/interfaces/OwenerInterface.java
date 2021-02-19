/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.interfaces;
import java.util.List;
import mvc.models.Owner;

/**
 *
 * @author Pablo Jacobo
 */
public interface OwenerInterface {
    public void addNewOwner(Owner owner);
    public List<Owner> allOweners();
    public Owner updateOwner(Owner owner);
    public boolean deleteOwner(int idOwner);
}
