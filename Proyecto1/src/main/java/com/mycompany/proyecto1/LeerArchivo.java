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
        // Instancia de filereader para luego instanciar un buffered reader que nos permita leer las secuencia de caracteres
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        // cada linea que devuelva el buffered se guarda en string
        while((cadena = b.readLine())!=null) {
            // se guarda una coma en cada salto de linea
            cadena = cadena + ",";
            // se con la coma agregada se guarda en la variable dato
            dato = dato + cadena;
            //lleva la cuenta de las lineas en el documento
            contlineas++;
        }
        // Uso de clase StringTokenizer para divir cadena en tokens, en este caso usamos la coma como separador
        StringTokenizer tokens = new StringTokenizer(dato,",");
        // inicializamos array datos con la cantidad de tokens existente
        datos = new String [tokens.countTokens()];
        //guardamos cada token en el array datos
        while(tokens.hasMoreTokens()){
           datos[i]=tokens.nextToken();  
           i++;
        }
        Tablas();
        
        b.close();
    }

    public static void main(String[] args) throws IOException {
       
    }
    
    ////////////////////////////////////////////////
    /*METODO PARA DETECTAR EL NOMBRE DE UN ENTIDAD*/
    ////////////////////////////////////////////////
    
    public void Tablas(){
        //Recorremos el array y vamos comparando para encontrar el nombre de cada entidad, si no encuentra lo ignora 
        try {
             for (int i = 0; i < datos.length; i++) {
            //Cuando encuentra el nombre de una entidad entra en ciclo for que manda los dato por dato para guardar en si correspondiente columna
            if (datos[i].equals("TIENDA")) {
                //Lleva cuenta de los inserts
                continsert++;    
                    for (int j = (i+1); j < (i+5); j++) {
                        //Metodo para guardar datos 
                        guardarTienda(datos[j]);
                    }
            
            }else if (datos[i].equals("TIEMPO")){
                continsert++;
                for (int j = (i+1); j < (i+4); j++) {            
                        guardarTiempo(datos[j]);
                    }
                
                
            }else if(datos[i].equals("PRODUCTO")){
                continsert++;
                for (int j = (i+1); j < (i+7); j++) {
                        guardarProducto(datos[j]);
                    }
               
                
            }else if(datos[i].equals("EMPLEADO")){
                 continsert++;
                for (int j = (i+1); j < (i+5); j++) {
                        guardarEmpleado(datos[j]);
                    }
                
                
            }else if(datos[i].equals("CLIENTE")){
                continsert++;
                for (int j = (i+1); j < (i+5); j++) {
                        guardarCliente(datos[j]);
                    }

            }else if(datos[i].equals("PEDIDO")){
                continsert++;
                for (int j = (i+1); j < (i+10); j++) {
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
    
    ///////////////////////////////////////
    /*METODOS PARA GUARDAR DATOS EN ARRAY*/
    ///////////////////////////////////////
    
    public void guardarTienda(String cadenas){
        // Va guardando token en cada posicion de array
        
        enviar[cont]=cadenas;
        cont++;
        //Cuando esta completa la informacion lo envia todo junto y hace el insert 
        if(cont==4){       
            insertTienda(enviar[0],enviar[1],enviar[2],enviar[3]);
            cont=0;
        }
        
    }
    
    public void guardarTiempo(String cadenas){
        
        enviar[cont]=cadenas;
        cont++;
        
        if(cont==3){   
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
            insertEmpleado(enviar[0],enviar[1],enviar[2],enviar[3]);
            cont=0;
        }
        
    }
     
     public void guardarCliente(String cadenas){
        double credito =0;
        enviar[cont]=cadenas;     
        cont++;
        if(cont==4){
                  try {         
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
        //Recibe los datos y los inserta en su entidad correspondiente 
        try {
             String query = ("INSERT INTO TIENDA(codigo,nombre,direccion,telefono_1) VALUES('"+codigo+"','"+nombre+"','"+direccion+"','"+telefono+"')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query);
             //Variable booleana verificar me permite saber cuando una tupla se ha insertado bien, sino muestra error.
             if(c.verificar){
                 //Mensaje final que avisa que los datos correctos fueron agregados
                  c.setMensaje(true);
             }else{
                 //Mensaje que muestra que datos no fueron agregados
                 JOptionPane.showMessageDialog(null,"Hay un error en Tienda: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Hay un error en Tienda: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
    
    
    public void insertTiempo(String tienda1,String tienda2,String tiempo){
         //Recibe los datos y los inserta en su entidad correspondiente 
        try {
             String query = ("INSERT INTO TIEMPO_DE_ENVIO(tiempo,codigo_tienda1,codigo_tienda2) VALUES('"+tiempo+"','"+tienda1+"','"+tienda2+"')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query);
             //Variable booleana verificar me permite saber cuando una tupla se ha insertado bien, sino muestra error.
             if(c.verificar){
                 //Mensaje final que avisa que los datos correctos fueron agregados
                  c.setMensaje(true);
             }else{
                 //Mensaje que muestra que datos no fueron agregados
                 JOptionPane.showMessageDialog(null,"Hay un error en Tiempo entre tiendas: "+tienda1+" y "+tienda2+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
                 JOptionPane.showMessageDialog(null,"Hay un error en Tiempo entre tiendas: "+tienda1+" y "+tienda2+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
    
     public void insertProducto(String nombre,String fabricante,String codigo,int cantidad,double precio,String tienda){
         //Recibe los datos y los inserta en su entidad correspondiente 
        try {
             String query = ("INSERT INTO PRODUCTO(nombre,fabricante,codigo,cantidad,precio,codigo_tienda) VALUES('"+nombre+"','"+fabricante+"','"+codigo+"','"+cantidad+"','"+precio+"','"+tienda+"')");     
             Conexion c = new Conexion();
             c.InsertarArchivo(query); 
             //Variable booleana verificar me permite saber cuando una tupla se ha insertado bien, sino muestra error.
             if(c.verificar){
                 //Mensaje final que avisa que los datos correctos fueron agregados
                  c.setMensaje(true);
                 
             }else{
                 //Mensaje que muestra que datos no fueron agregados
                 JOptionPane.showMessageDialog(null,"Hay un error en Producto: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
               JOptionPane.showMessageDialog(null,"Hay un error en Producto: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
     
      public void insertEmpleado(String nombre,String codigo,String telefono,String dpi){
          //Recibe los datos y los inserta en su entidad correspondiente 
        try {
             String query = ("INSERT INTO EMPLEADO(nombre,codigo,telefono,DPI,email,direccion) VALUES('"+nombre+"','"+codigo+"','"+telefono+"','"+dpi+"',' ',' ')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query); 
             //Variable booleana verificar me permite saber cuando una tupla se ha insertado bien, sino muestra error.
             if(c.verificar){
                 //Mensaje final que avisa que los datos correctos fueron agregados
                 c.setMensaje(true);
             }else{
                 //Mensaje que muestra que datos no fueron agregados
                 JOptionPane.showMessageDialog(null,"Hay un error en Empleado: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Hay un error en Empleado: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
      
     public void insertCliente(String nombre,String nit,String telefono,double credito){
         //Recibe los datos y los inserta en su entidad correspondiente 
        try {
             String query = ("INSERT INTO CLIENTE(nombre,NIT,telefono,credito_compra) VALUES('"+nombre+"','"+nit+"','"+telefono+"','"+credito+"')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query);
             //Variable booleana verificar me permite saber cuando una tupla se ha insertado bien, sino muestra error.
             if(c.verificar){
                 //Mensaje final que avisa que los datos correctos fueron agregados
                 c.setMensaje(true);        
             }else{
                 //Mensaje que muestra que datos no fueron agregados
                 JOptionPane.showMessageDialog(null,"Hay un error en Cliente: "+nit+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Hay un error en Cliente: "+nit+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
    public void insertPedido(String codigo,String tienda1,String tienda2,LocalDate fecha,String cliente,String producto,int cantidad,double total,double anticipo){
        //Recibe los datos y los inserta en su entidad correspondiente 
        try {
             String query = ("INSERT INTO PEDIDO(codigo,codigo_tienda_destino,codigo_tienda_origen,fecha,nit_cliente,codigo_producto,cantidad,total,anticipo) VALUES('"+codigo+"','"+tienda1+"','"+tienda2+"','"+fecha+"','"+cliente+"','"+producto+"','"+cantidad+"','"+total+"','"+anticipo+"')");
             Conexion c = new Conexion();
             c.InsertarArchivo(query);
             //Variable booleana verificar me permite saber cuando una tupla se ha insertado bien, sino muestra error.
             if(c.verificar){
                 //Mensaje final que avisa que los datos correctos fueron agregados
                 c.setMensaje(true);
             } else {
                 //Mensaje que muestra que datos no fueron agregados
                 JOptionPane.showMessageDialog(null,"Hay un error en Pedido: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
             }
        }catch(Exception e) {
               JOptionPane.showMessageDialog(null,"Hay un error en Pedido: "+codigo+" En la linea "+continsert+". Verifica e intenta de nuevo.");
         
        }

    }
    
   
}

