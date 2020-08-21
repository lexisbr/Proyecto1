/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1;
import conexionDB.Conexion;
import interfaces.Login;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
/**
 *
 * @author jalej
 */
public class LeerArchivo {
  
     
     int cont = 0;
     static String [] datos;
     String[] enviar = new String[10];
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     int contlineas =0;
     int continsert =0;
    public void muestraContenido(File archivo) throws FileNotFoundException, IOException {
        int i=0;
        String cadena;
        String dato="";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            //System.out.println(cadena);
            cadena = cadena + ",";
            dato = dato + cadena;
            contlineas++;
        }
        StringTokenizer tokens = new StringTokenizer(dato,",");
        datos = new String [tokens.countTokens()];
        while(tokens.hasMoreTokens()){
           datos[i]=tokens.nextToken();
          //  System.out.println(datos[i]);
           i++;
        }
        Tablas();
        
        b.close();
    }

    public static void main(String[] args) throws IOException {
       
    }
    
    public void Tablas(){
        
        int cuenta=1;
        try {
             for (int i = 0; i < datos.length; i++) {
            
            if (datos[i].equals("TIENDA")) {
                continsert++;
                System.out.println(">>>"+datos[i]+" "+(cuenta++));
//                tienda = true;
//                System.out.println("boolean "+tienda);
//                if(tienda){
                    for (int j = (i+1); j < (i+5); j++) {
                        System.out.println("==== "+datos[j]);
                        guardarTienda(datos[j]);
                    }

//                }
            }else if (datos[i].equals("TIEMPO")){
                continsert++;
                System.out.println(">>>"+datos[i]+" "+(cuenta++));
                for (int j = (i+1); j < (i+4); j++) {
                        System.out.println("==== "+datos[j]);
                        guardarTiempo(datos[j]);
                    }
                
                
            }else if(datos[i].equals("PRODUCTO")){
                continsert++;
                 System.out.println(">>>"+datos[i]+" "+(cuenta++));
                for (int j = (i+1); j < (i+7); j++) {
                        System.out.println("==== "+datos[j]);
                        guardarProducto(datos[j]);
                    }
               
                
            }else if(datos[i].equals("EMPLEADO")){
                 System.out.println(">>>"+datos[i]+" "+(cuenta++));
                 continsert++;
                for (int j = (i+1); j < (i+5); j++) {
                        System.out.println("==== "+datos[j]);
                        guardarEmpleado(datos[j]);
                    }
                
                
            }else if(datos[i].equals("CLIENTE")){
                continsert++;
                 System.out.println(">>>"+datos[i]+" "+(cuenta++));
                for (int j = (i+1); j < (i+5); j++) {
                        System.out.println("==== "+datos[j]);
                        guardarCliente(datos[j]);
                    }

            }else if(datos[i].equals("PEDIDO")){
                continsert++;
                System.out.println(">>>"+datos[i]+" "+(cuenta++));
                for (int j = (i+1); j < (i+10); j++) {
                        System.out.println("==== "+datos[j]);
                        guardarPedido(datos[j]);
                    }   
            }
            
            
        }
             if(Conexion.mensaje){
                 JOptionPane.showMessageDialog(null,"Los datos correctos se agregaron efectivamente.");
                 Conexion.setMensaje(false);
             }
              
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Error "+e);
        }
       
  
    }
    
    public void guardarTienda(String cadenas){
        
        enviar[cont]=cadenas;
//        System.out.println("contador "+cont+"- "+enviar[cont]);
        cont++;
        
        if(cont==4){
            /*System.out.println("entra");
            System.out.println(">>>>>>>>>>> "+enviar[0]+" "+enviar[1]+" "+enviar[2]+" "+enviar[3]);*/
            insertTienda(enviar[0],enviar[1],enviar[2],enviar[3]);
            cont=0;
        }
        
    }
    
    public void guardarTiempo(String cadenas){
        
        enviar[cont]=cadenas;
        //System.out.println("contador "+cont+"- "+enviar[cont]);
        cont++;
        
        if(cont==3){
            /*System.out.println("entra");
            System.out.println(">>>>>>>>>>> "+enviar[0]+" "+enviar[1]+" "+enviar[2]+" "+enviar[3]);*/
            insertTiempo(enviar[0],enviar[1],enviar[2]);
            cont=0;
        }
        
    }
    
     public void guardarProducto(String cadenas){
        double precio =0;
        int cantidad =0;
        enviar[cont]=cadenas;
        System.out.println("producto "+cont+"- "+enviar[cont]);
        cont++;
        
        if(cont==6){
          
             try {
                 precio = Double.parseDouble(enviar[4]);
                 cantidad = Integer.parseInt(enviar[3]);           
                 insertProducto(enviar[0],enviar[1],enviar[2],cantidad,precio,enviar[5]);
          
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,"Hay un error en Producto: "+enviar[2]+" En la linea "+continsert+". Verifica e intenta de nuevo.");
            }
            
            cont=0;
        }
        
    }
     
     public void guardarEmpleado(String cadenas){    
        enviar[cont]=cadenas;
        System.out.println("empleado "+cont+"- "+enviar[cont]);
        cont++;
        
        if(cont==4){
            /*System.out.println("entra");
            System.out.println(">>>>>>>>>>> "+enviar[0]+" "+enviar[1]+" "+enviar[2]+" "+enviar[3]);*/
            insertEmpleado(enviar[0],enviar[1],enviar[2],enviar[3]);
            cont=0;
        }
        
    }
     
     public void guardarCliente(String cadenas){
        double credito =0;
        enviar[cont]=cadenas;
        System.out.println("cliente "+cont+"- "+enviar[cont]);
        cont++;
         
             System.out.println("+++++++entra");  
              if(cont==4){
                  try {
                    System.out.println("+++++++entra");  
                    credito = Double.parseDouble(enviar[3]);        
                    insertCliente(enviar[0],enviar[1],enviar[2],credito);
                 } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Hay un error en Cliente: "+enviar[1]+" En la linea "+continsert+". Verifica e intenta de nuevo.");
                 }
                  cont=0;
            }
             
        
        
    }
     
     public void guardarPedido(String cadenas){
         String date ="";
        double total =0;
        double anticipo =0;
        int cantidad =0;
        enviar[cont]=cadenas;
        System.out.println("pedido "+cont+"- "+enviar[cont]);
        cont++;
        
        if(cont==9){
            try {
                date = enviar[3];
                LocalDate fecha = LocalDate.parse(date, formatter);
                total = Double.parseDouble(enviar[7]);
                anticipo = Double.parseDouble(enviar[8]);
                cantidad = Integer.parseInt(enviar[6]);   
                insertPedido(enviar[0],enviar[1],enviar[2],fecha,enviar[4],enviar[5],cantidad,total,anticipo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Hay un error en Cliente: "+enviar[1]+" En la linea "+continsert+". Verifica e intenta de nuevo.");
            }
           
            cont=0;
        }
        
    }
     
    /////////////////////////////////////////// 
    /* METODOS PARA INSERTAR EN BASE DE DATOS*/
    ///////////////////////////////////////////
     
    public void insertTienda(String nombre,String direccion,String codigo,String telefono){
        System.out.println("entra a db");
        
        try {
             String query = ("INSERT INTO TIENDA(codigo,nombre,direccion,telefono_1) VALUES('"+codigo+"','"+nombre+"','"+direccion+"','"+telefono+"')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query);    
             if(c.verificar){
                  c.setMensaje(true);
             }else{
                 JOptionPane.showMessageDialog(null,"Hay un error en Tienda: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Hay un error en Tienda: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
    
    
    public void insertTiempo(String tienda1,String tienda2,String tiempo){
        System.out.println("entra a db");
        
        try {
             String query = ("INSERT INTO TIEMPO_DE_ENVIO(tiempo,codigo_tienda1,codigo_tienda2) VALUES('"+tiempo+"','"+tienda1+"','"+tienda2+"')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query);
             if(c.verificar){              
                  c.setMensaje(true);
             }else{
                 JOptionPane.showMessageDialog(null,"Hay un error en Tiempo entre tiendas: "+tienda1+" y "+tienda2+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,"Hay un error en Tiempo entre tiendas: "+tienda1+" y "+tienda2+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
    
     public void insertProducto(String nombre,String fabricante,String codigo,int cantidad,double precio,String tienda){
        System.out.println("entra a db");
        
        try {
             String query = ("INSERT INTO PRODUCTO(nombre,fabricante,codigo,cantidad,precio,codigo_tienda) VALUES('"+nombre+"','"+fabricante+"','"+codigo+"','"+cantidad+"','"+precio+"','"+tienda+"')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query); 
             if(c.verificar){    
                  c.setMensaje(true);
                 
             }else{
                 JOptionPane.showMessageDialog(null,"Hay un error en Producto: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
               JOptionPane.showMessageDialog(null,"Hay un error en Producto: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
     
      public void insertEmpleado(String nombre,String codigo,String telefono,String dpi){
        System.out.println("entra a db");
        
        try {
             String query = ("INSERT INTO EMPLEADO(nombre,codigo,telefono,DPI,email,direccion) VALUES('"+nombre+"','"+codigo+"','"+telefono+"','"+dpi+"',' ',' ')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query);  
             if(c.verificar){     
                 c.setMensaje(true);
             }else{
                 JOptionPane.showMessageDialog(null,"Hay un error en Empleado: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Hay un error en Empleado: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
      
     public void insertCliente(String nombre,String nit,String telefono,double credito){
        System.out.println("entra a db");
        
        try {
             String query = ("INSERT INTO CLIENTE(nombre,NIT,telefono,credito_compra) VALUES('"+nombre+"','"+nit+"','"+telefono+"','"+credito+"')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query);
             if(c.verificar){         
                 c.setMensaje(true);        
             }else{
                 JOptionPane.showMessageDialog(null,"Hay un error en Cliente: "+nit+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Hay un error en Cliente: "+nit+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
    public void insertPedido(String codigo,String tienda1,String tienda2,LocalDate fecha,String cliente,String producto,int cantidad,double total,double anticipo){
        System.out.println("entra a db");
        
        try {
             String query = ("INSERT INTO PEDIDO(codigo,codigo_tienda_destino,codigo_tienda_origen,fecha,nit_cliente,codigo_producto,cantidad,total,anticipo) VALUES('"+codigo+"','"+tienda1+"','"+tienda2+"','"+fecha+"','"+cliente+"','"+producto+"','"+cantidad+"','"+total+"','"+anticipo+"')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query);
             if(c.verificar){
                 c.setMensaje(true);
             }else{
                 JOptionPane.showMessageDialog(null,"Hay un error en Pedido: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
               JOptionPane.showMessageDialog(null,"Hay un error en Pedido: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
    
   
}

