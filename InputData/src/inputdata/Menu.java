/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Pablo Jacobo
 */
public class Menu {
    Scanner entradaDeDatos = new Scanner(System.in);
    List<User> users = new ArrayList();
 
    public void Inicio(){
        // usuario commodion
        this.users.add(new User("admin", "123"));
        
        System.out.println(" Escribe tu usuario... ");
        String nickname = this.entradaDeDatos.nextLine();
        
        System.out.println(" Escribe tu password... ");
        String password = this.entradaDeDatos.nextLine();
        
        boolean respuesta = this.verificarIdentidad(nickname, password);
        
        if ( respuesta ) {
            this.MenuPrincipal();
        }
        
        if ( respuesta == false ) {
            System.out.println("vuelva a intentar");
            this.Inicio();
        }
        
    }
    
    
    public boolean verificarIdentidad(String username, String password) {
        List<User> listaDeusuarioEncontrado = this.users.stream().filter( e -> { 
            String tempUsername = e.username;
            String tempPass = e.password;
            boolean resultado = false;
            if ( tempUsername.equals(username) &&  tempPass.equals(password)) {
                resultado = true;
                return resultado;
            }
            return resultado;
        }).collect(Collectors.toList());
        
        boolean respuesta = false;
        
        if( (listaDeusuarioEncontrado.size() > 0 ) ) {
            respuesta = true;
        }
        
        return respuesta;
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
