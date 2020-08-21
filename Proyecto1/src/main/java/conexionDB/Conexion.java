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
    public static boolean vacia;
     

    public Conexion() {
        conexionDB();
        
    }
    
    public void conexionDB() {
        conexion = null;
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
            if (conexion != null) {
                System.out.println("Conexion establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(">>>Error al conectar " + e);
        }

    }
    public void Insertar(String query) {
        Statement stmt = null;
        try {
            
            stmt = getConnection().createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Los valores han sido agregados a la base de datos");
            stmt.close();
            disconnectDB();
        } catch (SQLException e) {
             if(e.getErrorCode() == MYSQL_DUPLICATE_PK ){
                JOptionPane.showMessageDialog(null,"Error, el codigo ya existe.");
             }else{
             JOptionPane.showMessageDialog(null,"Error "+e);
             }
        }
    }
    public void InsertarArchivo(String query) {
        Statement stmt = null;
        verificar=true;
        try {
            
            stmt = getConnection().createStatement();
            stmt.executeUpdate(query);
            System.out.println("Se agrego dato ");
            stmt.close();
            disconnectDB();
        } catch (SQLException e) {
                     verificar = false;
        }
    }
    
    
    
    public int InsertFactura(String query) {
        int resultado = 0;
        try {
 
            Statement stmt = null;
            stmt = getConnection().createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                resultado = rs.getInt(1);
            }
            rs.close();

            stmt.close();
            disconnectDB();
        } catch (SQLException e) {
            if (e.getErrorCode() == MYSQL_DUPLICATE_PK) {
                JOptionPane.showMessageDialog(null, "Error el ID o codigo ya existe");
            } else {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return resultado;
    }
    
    public ResultSet SeleccionarCB(String query){
        Statement stmt = null;
        try {
            getConnection();
            stmt = getConnection().createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            
            return resultado;
    
         
        } catch (Exception e) {
            return null;

        }
    }
    
      public  ResultSet consulta(String query){
        Statement stmt = null;
        try {
            getConnection();
            stmt = getConnection().createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            
            return resultado;
    
         
        } catch (Exception e) {
            return null;

        }
    }
  
    public ResultSet SeleccionarJT(String query){
         PreparedStatement ps = null;
         ResultSet rs = null;
         try {
            Connection con = getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
             return null;
        }
         
    }

    public Connection getConnection() {
        return  conexion;
    }

    //metodo encargado de salir de la base de datos
    public void disconnectDB() {
        conexion = null;
        if (conexion == null) {
            System.out.println("Conexion terminada");
        }
    }
    
    public static void setMensaje(boolean a){
        mensaje = a;
    }
    
    public void verificarEsquema(String campo, String tabla){
        Conexion a = new Conexion();
        ResultSet rs = a.consulta("SELECT "+campo+" FROM "+tabla);
        try{
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
