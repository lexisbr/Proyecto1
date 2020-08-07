/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
/**
 *
 * @author jalej
 */
public class LeerArchivo {
  
    public static void muestraContenido(File archivo) throws FileNotFoundException, IOException {
        int i=0;
        String [] datos;
        String cadena;
        String dato="";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            //System.out.println(cadena);
            cadena = cadena + ",";
            dato = dato + cadena;
            
        }
        StringTokenizer tokens = new StringTokenizer(dato,",");
        datos = new String [tokens.countTokens()];
        while(tokens.hasMoreTokens()){
           datos[i]=tokens.nextToken();
         //  System.out.println(datos[i]);
           i++;
        }
        for (int e  = 0; e < datos.length; e++) {
            System.out.println(">>>"+datos[e]);
        }
        b.close();
    }

    public static void main(String[] args) throws IOException {
       
    }
    
    public void Tablas(String [] datoss){
        for (int i = 0; i < datoss.length; i++) {
            System.out.println(datoss[i]);
        }
        
    }
   
}

