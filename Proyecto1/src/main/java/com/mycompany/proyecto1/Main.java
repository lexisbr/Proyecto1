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
        File directorio = new File("Reportes");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            }
        }
        
        Conexion c = new Conexion();
        SeleccionVersion log = new SeleccionVersion();
        log.setVisible(true);
        
    }
    
}
