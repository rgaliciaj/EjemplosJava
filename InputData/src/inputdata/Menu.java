/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Pablo Jacobo
 */
public class Menu {
    Scanner entradaDeDatos = new Scanner(System.in);
    List<User> users = new ArrayList();
    Map<Object, Object> mapAuth = new HashMap();
 
    public void Inicio(){
        // usuario commodion
        this.users.add(new User("admin", "123"));
        
        System.out.println(" Escribe tu usuario... ");
        String nickname = this.entradaDeDatos.nextLine();
        
        System.out.println(" Escribe tu password... ");
        String password = this.entradaDeDatos.nextLine();
        
        Map<Object, Object> resultAuth = this.verificarIdentidad(nickname, password);
        Object resultObj = resultAuth.get("status");
        boolean access = Boolean.parseBoolean(resultObj.toString());
         
        if ( access == true ) {
            this.MenuPrincipal();
        }
        
        if ( access == false) {
            System.out.println("vuelva a intentar");
            this.Inicio();
        }
        
    }
    
    
    public Map<Object, Object> verificarIdentidad(String username, String password) {
        User userFind = this.users.stream()
            .filter( u -> u.username.equals(username))
            .filter( u -> u .password.equals(password))
            .findAny()
            .orElse(null);
        
        boolean resultStatus = false;
        if ( userFind != null ) {
            resultStatus = true;
        }
        
       
        this.mapAuth.put("status", resultStatus);
        this.mapAuth.put("user", userFind);
        return this.mapAuth;
    }
    
    
    public void MenuPrincipal(){
        System.out.println(" 1. Personas ");
        System.out.println(" 2. Carros   ");
        System.out.println(" 3. usuarios ");
        System.out.println(" 4. salir   ");
        
        System.out.println(" selecciona una opcion ");
        int opcion = Integer.parseInt( this.entradaDeDatos.nextLine());
        
        if (  opcion == 3  ) {
            this.MenuUsuarios();
        }
        
    }
    
    public void MenuUsuarios(){
        System.out.println(" 1. agregar 1 usuario");

        int opcion = Integer.parseInt( this.entradaDeDatos.nextLine());
        
        if ( opcion == 1 ) {
            System.out.println(" escribe el username ");
            String vUsername = this.entradaDeDatos.nextLine();
            System.out.println(" escribe el password ");
            String vPass = this.entradaDeDatos.nextLine();
            
            System.out.println(" vuser " + vUsername + " vPass " + vPass );
            
            
            this.users.add(new User( vUsername, vPass));
            System.out.println(" se guardo exitosamente....");
            this.Inicio();
        }
        
    }
    
    public void MenuPersonas(){
        System.out.println(" 1. Ingresar 1 persona ");
        System.out.println(" 2. Listar  todas las personas ");
          System.out.println(" 3. regresar   ");
    }
    
    public void MenuCarros(){
        System.out.println(" 1. Ingrese 1 registro de carros ");
        System.out.println(" 1. listar registros de carros ");
        System.out.println(" 3. regresar   ");
    }
    
}
