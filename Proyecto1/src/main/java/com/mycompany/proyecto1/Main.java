/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1;
import conexionDB.Conexion;
import interfaces.SeleccionVersion;

/**
 *
 * @author jalej
 */
public class Main {
    public static void main(String[] arg){
        Conexion c = new Conexion();
        c.conexionDB();
        SeleccionVersion log = new SeleccionVersion();
        log.setVisible(true);
        
    }
    
}
