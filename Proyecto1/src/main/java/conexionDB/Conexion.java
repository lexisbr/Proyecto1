/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionDB;


import interfaces.Login;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author jalej
 */
public class Conexion {
    private static Connection conexion = null;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static String user = "root";
    private static String password = "5200fcb1";
    private static String url = "jdbc:mysql://localhost/INTELAF?useSSL=false";
    public static final int MYSQL_DUPLICATE_PK = 1062;
    public static boolean verificar;
    public static boolean mensaje;
    public static boolean vacia=false;
     

    public Conexion() {
       
    }
    
    public void conexionDB() {
        /*Metodo para hacer conexion con DB*/
        conexion = null;
        try {
            //Se llama al jdbc
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(">>>Error al conectar " + e);
        }finally{
            
        }

    } 
    /*Metodo para insertar una nueva tupla*/
    public void Insertar(String query) {
        PreparedStatement stmt = null;
        try {
            conexionDB();
            stmt = getConnection().prepareStatement(query);
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Los valores han sido agregados a la base de datos");
            stmt.close();    
        } catch (SQLException e) {
             if(e.getErrorCode() == MYSQL_DUPLICATE_PK ){
                JOptionPane.showMessageDialog(null,"Error, el codigo ya existe.");
             }else{
             JOptionPane.showMessageDialog(null,"Error "+e);
             }
        }finally{
            disconnectDB();
        }
    }
    
    /*Metodo para insertar las tuplas del archivo txt*/
    public void InsertarArchivo(String query) {
        PreparedStatement stmt = null;
        verificar=true;
        try {
            conexionDB();
            stmt = getConnection().prepareStatement(query);
            stmt.executeUpdate(query);         
            stmt.close();
        } catch (SQLException e) {
                     verificar = false;
        }finally{
            disconnectDB();
        }
    }
    
    
    /*Metodo para insertar una factura que nos devuelve la pk para crear una venta*/
    public int InsertFactura(String query) {
        int resultado = 0;
        try {
            conexionDB();
            PreparedStatement stmt = null;
            stmt = getConnection().prepareStatement(query);
            stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                resultado = rs.getInt(1);
            }
            rs.close();

            stmt.close();
            
        } catch (SQLException e) {
            if (e.getErrorCode() == MYSQL_DUPLICATE_PK) {
                JOptionPane.showMessageDialog(null, "Error el ID o codigo ya existe");
            } else {
                JOptionPane.showMessageDialog(null, e);
            }
        }finally{
            disconnectDB();
        }
        return resultado;
    }
    
   /*Metodo para llenar combobox*/
    public ResultSet SeleccionarCB(String query){
        PreparedStatement stmt = null;
        try {
            conexionDB();
            stmt = getConnection().prepareStatement(query);
            ResultSet resultado = stmt.executeQuery();
            
            return resultado;
    
         
        } catch (Exception e) {
            return null;

        }finally{
            disconnectDB();
        }
    }
    /*Metodo para crear una consulta */
      public  ResultSet consulta(String query){
        PreparedStatement stmt = null;
        try {
            conexionDB();
            stmt = getConnection().prepareStatement(query);
            ResultSet resultado = stmt.executeQuery();
            
            return resultado;
    
         
        } catch (Exception e) {
            return null;

        }finally{
            disconnectDB();
        }
    }
      /*Metodo para llenar una jTable*/
    public ResultSet SeleccionarJT(String query){
         PreparedStatement ps = null;
         ResultSet rs = null;
         try {
            conexionDB();
            Connection con = getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
             return null;
        }finally{
            disconnectDB();
        }
         
    }
 /* Metodo para devolver conexion*/
    public Connection getConnection() {
        return  conexion;
    }

    /*Metodo encargado de desconectar con mysql*/
    public void disconnectDB() {
        conexion = null; 
    }
    /*Metodo usado para la carga de archivos que devuelve si se ingreso alguna tupla correctamente*/
    public static void setMensaje(boolean a){
        mensaje = a;
    }
    /*Metodo para verificar si el esquema esta vacio*/
    public void verificarEsquema(String campo, String tabla){
        Conexion a = new Conexion();
        ResultSet rs = a.consulta("SELECT "+campo+" FROM "+tabla);
        try{
            conexionDB();
             if (rs != null && rs.next()) {
             System.out.println("Encontre: " + rs.getString(1) ); // te da el valor de el primer campo
             vacia=false;
             
             } else if(Login.cont==4) {
                 vacia=true;
                JOptionPane.showMessageDialog(null, "Base de datos esta vacia!");
             } 
        
        } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error "+e);
        }
        
      
    }
}
