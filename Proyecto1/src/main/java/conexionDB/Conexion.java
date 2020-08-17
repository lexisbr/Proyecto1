/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionDB;


import java.sql.DriverManager;
import java.sql.Connection;
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
            conexionDB();
            stmt = getConnection().createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Los valores han sido agregados a la base de datos");
        } catch (SQLException e) {
             if(e.getErrorCode() == MYSQL_DUPLICATE_PK ){
                JOptionPane.showMessageDialog(null,"Error, el codigo de tienda ya existe.");
             }else{
             JOptionPane.showMessageDialog(null,"Error "+e);
             }
        }
    }
    
    public ResultSet Seleccionar(String query){
        Statement stmt = null;
        try {
            conexionDB();
            stmt = getConnection().createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            return resultado;
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
   
     public static void main(String[] args){
   
         Conexion c = new Conexion();
         c.conexionDB();
     }
    
}
