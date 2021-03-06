/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesCliente;

import conexionDB.Conexion;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jalej
 */
public class CatalogoProducto extends javax.swing.JFrame {

    /**
     * Creates new form CatalogoProducto
     */
    Conexion a = new Conexion();
    
    public CatalogoProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
       
        cargarTablaProducto();
        KeyListener();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_visualizar = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscar_txt = new javax.swing.JTextField();
        opciones_cb = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setForeground(new java.awt.Color(0, 0, 0));

        jt_visualizar.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(jt_visualizar);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 620, 260));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/producto.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Productos.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        buscar_txt.setBackground(new java.awt.Color(255, 255, 255));
        buscar_txt.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        buscar_txt.setForeground(new java.awt.Color(0, 0, 0));
        buscar_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_txtActionPerformed(evt);
            }
        });
        jPanel1.add(buscar_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 230, 30));

        opciones_cb.setBackground(new java.awt.Color(255, 255, 255));
        opciones_cb.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        opciones_cb.setForeground(new java.awt.Color(0, 0, 0));
        opciones_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtrar por.", "Codigo.", "Nombre.", "Fabricante.", " " }));
        jPanel1.add(opciones_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 200, 30));

        jLabel11.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Buscar:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 30));

        jLabel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null, new java.awt.Color(153, 153, 153)));
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 640, 330));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/regresar.png"))); // NOI18N
        jButton7.setText("Regresar");
        jButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondoventas3.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscar_txtActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        MainCliente log = new MainCliente();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CatalogoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatalogoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatalogoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatalogoProducto().setVisible(true);
            }
        });
    }
    public void KeyListener(){
      
        buscar_txt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                cargarTablaProducto();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                 cargarTablaProducto();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                 cargarTablaProducto();
            }
           
        });
    }
    /*Carga tabla de productos*/
    public void cargarTablaProducto(){
         String campo = buscar_txt.getText();
         String opcion = String.valueOf(opciones_cb.getSelectedItem());
        String where = "";

        if (!"".equals(campo)&&opcion.equals("Codigo.")) {
            where = "WHERE codigo LIKE '%" + campo + "%'";

        }else if(!"".equals(campo)&&opcion.equals("Nombre.")){
            where =  "WHERE nombre LIKE '%"+ campo +"%'";
        }else if(!"".equals(campo)&&opcion.equals("Fabricante.")){
            where =  "WHERE fabricante LIKE '%"+ campo +"%'";
        }else{
            where="";
        }
         try {
           DefaultTableModel modelo = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                return false;
                }
           };
           jt_visualizar.setModel(modelo);
           TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jt_visualizar.getModel());
            jt_visualizar.setRowSorter(new TableRowSorter(modelo));

            
           modelo.addColumn("Codigo");
           modelo.addColumn("Nombre");
           modelo.addColumn("Fabricante"); 
           modelo.addColumn("Cantidad");
           modelo.addColumn("Precio");
           modelo.addColumn("Descripcion");
           modelo.addColumn("Garantia");
           modelo.addColumn("Tienda");
           String query = "SELECT * FROM PRODUCTO "+where;
           System.out.println(query);
           ResultSet rs = a.SeleccionarJT(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int cantidadColumnas = rsMd.getColumnCount();
             System.out.println("creando tabla");
           while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for(int i = 0; i<cantidadColumnas; i++){
                    filas[i]= rs.getObject(i+1);
                }
                modelo.addRow(filas);    
            }
           rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error "+ e);
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscar_txt;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jt_visualizar;
    private javax.swing.JComboBox<String> opciones_cb;
    // End of variables declaration//GEN-END:variables
}
