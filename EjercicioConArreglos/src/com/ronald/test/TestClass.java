package com.ronald.test;

import java.util.Scanner;

/**
 *
 * @author Ronald Galicia
 */
public class TestClass {
    /*
        Pedir 10 números por teclado y obtener la suma, media aritmética, 
        el número menor, el número  mayor y cuántas veces se repite cada número.
    */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;
        float promedio = 0;
        int menor = 0;
        int mayor = 0;
        
        //se crea el arreglo de 10 posiciones y se solicitan los numeros por teclado.
        //al mismo tiempo que se realiza la suma
        int miArreglo[] = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese su numero en la posicion " + i);
            miArreglo[i] = sc.nextInt();
            suma = suma + miArreglo[i];
        }
        System.out.println("la suma es= " + suma);
        
        //se realiza el promedio
        promedio = suma/miArreglo.length;
        System.out.println("El promedio es= " + promedio);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el numero en la posicion " + (i+1) + " : ");
            miArreglo[i] = sc.nextInt();
        }
        
        //ya capturados los datos se realiza la suma, promedio y el numero mayor 
        //de todos los numero ingresados.
                
        for (int i = 0; i < miArreglo.length; i++) {
            suma += miArreglo[i];
            if(mayor < miArreglo[i]) {
                mayor = miArreglo[i];
            }
            System.out.println(String.format("Posicion [%d] Elemento: %d", i, miArreglo[i]));
        }
        menor = mayor;
        //buscar el menor
        for (int i = 0; i < miArreglo.length; i++) {
            if (menor > miArreglo[i]) {
                menor = miArreglo[i];
            }
        }
        
        //promedio
        promedio = suma/miArreglo.length;
        
        System.out.println("****SALIDA****");
        System.out.println("");
        //contar las veces que se repite un numero
        int cont;
        for (int i = 0; i < miArreglo.length; i++) {
            cont = 0;
            for (int j = 0; j < miArreglo.length; j++) {
                if (miArreglo[i] == miArreglo[j]) {
                    cont++;
                }
            }
            System.out.println(String.format("El numero %d se repite %d veces", 
                    miArreglo[i], cont));
        }
        System.out.println(String.format("La suma es %d, el promedio es %.2f,"
                + " el mayor es %d, el menor es %d", suma, promedio, mayor, menor));
    }*/
    }
}
