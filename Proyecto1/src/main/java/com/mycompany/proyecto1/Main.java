/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1;
import conexionDB.Conexion;
import interfaces.SeleccionVersion;
import java.io.File;

/**
 *
 * @author jalej
 */
public class Main {
    public static void main(String[] arg){
        // Se crea carpeta para reportes si no existe aun.
        
        File directorio = new File("Reportes");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            }
        }
        //Inicio de conexion base de datos
        Conexion c = new Conexion();
        //Se inicia el programa
        SeleccionVersion log = new SeleccionVersion();
        log.setVisible(true);
        
    }
    
}
