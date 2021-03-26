/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asignaciondeautos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Ronald Galicia
 */
public class Menu {
    Scanner entradaDeDatos = new Scanner(System.in);
    List<User> user = new ArrayList();
    List<Persona> persona = new ArrayList();
    List<Carro> carro = new ArrayList();
    List<AsignClienteCarro>  nuevaListaPersonasYCarros = new ArrayList();
    
    List<Carro> buscarCarroPorPropietario(int idPerson) {
        List<Carro> carrosEncontrados = new ArrayList();
        this.carro.stream().filter( e ->{
            if( e.idPersona == idPerson ){
                carrosEncontrados.add(e);
            }
            return false;
        }).collect(Collectors.toList());
        return carrosEncontrados;
    }
    
    
    public void inicio(){
        this.user.add(new User("admin", "123"));
        
        System.out.print("Ingrese su usuario: ");
        String nickname = entradaDeDatos.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = entradaDeDatos.nextLine();
        
        boolean respuesta = this.identificarIdentidad(nickname, password);
        
        if(respuesta){
            this.menuPrincial();
        }else{
            System.out.println("Credenciales incorrectas, vuelta a intentar...");
            this.inicio();
        }
        
        
    }
    
    public boolean identificarIdentidad(String username, String password){
        List<User> listaUsuarioEncontrado = this.user.stream().filter(e -> {
            String tempUser = e.username;
            String tempPass = e.password;
            boolean resultado = false;
            if(tempUser.equals(username) && tempPass.equals(password)){
                resultado = true;
                return resultado;
            }
            
            return resultado;
        }).collect(Collectors.toList());
        
        return (listaUsuarioEncontrado.size() > 0)? true : false;
    }
    
    public void menuPrincial(){
        System.out.println("---MENU PRINCIPAL---");
        System.out.println("");
        System.out.println("1. Personas");
        System.out.println("2. Carros");
        System.out.println("3. Usuarios");
        System.out.println("4. Salir");
        System.out.print("Elija una opcion: ");
        
        int opcion = Integer.parseInt(this.entradaDeDatos.nextLine());
        
        switch(opcion) {
            case 1:
                this.menuPersonas();
            break;
            case 2:
                this.menuCarros();
            break;
            case 3:
                this.menuUsuarios();
            break;
            case 4:
                System.exit(0);
            break;
            default: 
                System.out.println("Opcion incorrecta, vuelta a intentarlo...");
                this.inicio();
                System.out.println("");
        }
        
    }
    
    public void menuPersonas(){
        System.out.println("-----MENU DE PERSONAS-----");
        System.out.println("");
        System.out.println("1. Ingreso de personas");
        System.out.println("2. Lista de personas");
        System.out.println("3. Regresar");
        System.out.print("Elija una opcion: ");
        System.out.println("");
        
        int opcion = Integer.parseInt(this.entradaDeDatos.nextLine());
        
        switch(opcion) {
            case 1:
                System.out.println("-----INGRESO DE PERSONAS-----");
                System.out.print("Ingrese id de la persona: ");
                int vIdPersona = Integer.parseInt(this.entradaDeDatos.nextLine());
                System.out.print("Ingrese nombre de la persona: ");
                String vNombrePersona = this.entradaDeDatos.nextLine();
                
                
                this.persona.add(new Persona (vIdPersona, vNombrePersona));
                System.out.println("Se ingresa persona exitosamente...");
                this.menuPersonas();
            break;
            case 2:
                System.out.println("---LISTADO DE PERSONAS---");
                System.out.println("");
                for(Persona person : persona ){
                    System.out.println("Id persona: " + person.idPersona + " Nombre: " + person.nombre);
                }
                
                
                
                
                
                System.out.println("--------------------------------------------");
                this.menuPersonas();
            break;
            case 3:
                this.menuPrincial();
            break;
            default: 
                System.out.println("Opcion incorrecta, vuelta a intentarlo...");
                this.menuPersonas();
                System.out.println("");
        }
    }
    
    public void menuCarros(){
        System.out.println("-----MENU DE CARROS-----");
        System.out.println("");
        System.out.println("1. Ingreso de carros");
        System.out.println("2. Lista de carros");
        System.out.println("3. Regresar");
        System.out.print("Elija una opcion: ");
        System.out.println("");
        
        int opcion = Integer.parseInt(this.entradaDeDatos.nextLine());
        
        switch(opcion) {
            case 1:
                System.out.println("-----INGRESO DE CARROS-----");
                System.out.print("Ingrese id de carro: ");
                int vIdCarro = Integer.parseInt(this.entradaDeDatos.nextLine());
                System.out.print("Ingrese marca de carro: ");
                String vMarcaCarro = this.entradaDeDatos.nextLine();
                System.out.print("Ingrese id de dueño: ");
                int vIdDueno = Integer.parseInt(this.entradaDeDatos.nextLine());
                
                this.carro.add(new Carro (vIdCarro, vMarcaCarro, vIdDueno));
                System.out.println("Se ingresa carro exitosamente...");
                this.menuCarros();
            break;
            case 2:
                System.out.println("---LISTADO DE CARROS---");
                System.out.println("");
                
                
                
                
                /*for(Carro car : carro){
                    System.out.println("Id carro: " + car.idCarro 
                + " Marca: " + car.marca 
                + " Id Persona: " + car.idPersona);
                }*/
                
                
                for(int i=0; i < persona.size(); i ++) {
                    Persona elemento = persona.get(i);
                    AsignClienteCarro asignacion = new AsignClienteCarro(elemento.idPersona, elemento.nombre, this.buscarCarroPorPropietario(elemento.idPersona));
                    this.nuevaListaPersonasYCarros.add(asignacion);
                }
                
                for(AsignClienteCarro elementoNuevaEstructrua: nuevaListaPersonasYCarros ) {
                    System.out.println("idPersona  " + elementoNuevaEstructrua.idPersona);
                    System.out.println("name  " + elementoNuevaEstructrua.nombre );
                    // mostrar en otro for  los datos de la lista...
                    for(Carro car: elementoNuevaEstructrua.carrosList ){
                        System.out.println("Car: " + car.marca);
                    }
                    //System.out.println("tamaño de lista " + this.nuevaListaPersonasYCarros.size());
                    System.out.println("----------------------");
                }
                
                
                
                System.out.println("--------------------------------------------");
                this.menuCarros();
            break;
            case 3:
                this.menuPrincial();
            break;
            default: 
                System.out.println("Opcion incorrecta, vuelta a intentarlo...");
                this.menuPersonas();
                System.out.println("");
        }
        
    }
    
    public void menuUsuarios(){
        System.out.println("-----MENU DE USUARIOS-----");
        System.out.println("");
        System.out.println("1. Ingreso de usuarios");
        System.out.println("2. Lista de usuarios");
        System.out.println("3. Regresar");
        System.out.print("Elija una opcion: ");
        System.out.println("");
        
        int opcion = Integer.parseInt(this.entradaDeDatos.nextLine());
        
        switch(opcion) {
            case 1:
                System.out.println("-----INGRESO DE USUARIOS-----");
                System.out.print("Ingrese usuario: ");
                String vUsuario = this.entradaDeDatos.nextLine();
                System.out.print("Ingrese contraseña: ");
                String vPassword = this.entradaDeDatos.nextLine();
                
                System.out.println("vUsuario " + vUsuario + " vPassword " + vPassword);
                
                this.user.add(new User (vUsuario, vPassword));
                System.out.println("Se ingresa usuario exitosamente...");
                this.menuUsuarios();
            break;
            case 2:
                System.out.println("---LISTADO DE USUARIOS---");
                System.out.println("");
                for(User usuario : user){
                    System.out.println("Usuario: " + usuario.username + " Contraseña: " + usuario.password);
                }
                System.out.println("--------------------------------------------");
                this.menuUsuarios();
            break;
            case 3:
                this.menuPrincial();
            break;
            default: 
                System.out.println("Opcion incorrecta, vuelta a intentarlo...");
                this.menuUsuarios();
                System.out.println("");
        }
    }
    
    
}
