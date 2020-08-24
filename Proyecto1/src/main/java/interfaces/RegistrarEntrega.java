/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import conexionDB.Conexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jalej
 */
public class RegistrarEntrega extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarVenta
     */
    Conexion a = new Conexion();
    public LocalDate fecha = LocalDate.now();
    public RegistrarEntrega() {
        initComponents();
        this.setLocationRelativeTo(null);
        KeyListenerPedido();
        CargarTablaPedidos();
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
        jLabel2 = new javax.swing.JLabel();
        regresar_bt = new javax.swing.JButton();
        registrar_bt = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pedido_txt = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        pedido_jt = new javax.swing.JTable();
        pedido_bt = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        fecha_lbl = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        marco2 = new javax.swing.JLabel();
        tiempo_lbl = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pedido_lbl = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        codigo_lb = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tienda_origen = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        marco1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registrar pedido ingresado.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        regresar_bt.setBackground(new java.awt.Color(255, 255, 255));
        regresar_bt.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        regresar_bt.setForeground(new java.awt.Color(0, 0, 0));
        regresar_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/regresar.png"))); // NOI18N
        regresar_bt.setText("Regresar");
        regresar_bt.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        regresar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar_btActionPerformed(evt);
            }
        });
        jPanel1.add(regresar_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 130, 30));

        registrar_bt.setBackground(new java.awt.Color(255, 255, 255));
        registrar_bt.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        registrar_bt.setForeground(new java.awt.Color(0, 0, 0));
        registrar_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cargar (1).png"))); // NOI18N
        registrar_bt.setText("Registrar");
        registrar_bt.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        registrar_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_btActionPerformed(evt);
            }
        });
        jPanel1.add(registrar_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 280, 40));

        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 407, 285, 45));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pedidoingresado.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 60));

        pedido_txt.setBackground(new java.awt.Color(255, 255, 255));
        pedido_txt.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        pedido_txt.setForeground(new java.awt.Color(0, 0, 0));
        pedido_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido_txtActionPerformed(evt);
            }
        });
        jPanel1.add(pedido_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 240, 30));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setForeground(new java.awt.Color(0, 0, 0));

        pedido_jt.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(pedido_jt);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 380, 120));

        pedido_bt.setBackground(new java.awt.Color(255, 255, 255));
        pedido_bt.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        pedido_bt.setForeground(new java.awt.Color(0, 0, 0));
        pedido_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pedido3.1.png"))); // NOI18N
        pedido_bt.setText("Seleccionar Pedido");
        pedido_bt.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        pedido_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido_btActionPerformed(evt);
            }
        });
        jPanel1.add(pedido_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 190, 40));

        jLabel15.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Pedido:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 30));

        fecha_lbl.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        fecha_lbl.setForeground(new java.awt.Color(0, 0, 0));
        fecha_lbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204), null));
        jPanel1.add(fecha_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 200, 30));

        jLabel16.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, 30));

        marco2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null, new java.awt.Color(153, 153, 153)));
        jPanel1.add(marco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 400, 225));

        tiempo_lbl.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        tiempo_lbl.setForeground(new java.awt.Color(0, 0, 0));
        tiempo_lbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204), null));
        jPanel1.add(tiempo_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 60, 30));

        jLabel17.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Codigo:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, -1, 30));

        pedido_lbl.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        pedido_lbl.setForeground(new java.awt.Color(0, 0, 0));
        pedido_lbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204), null));
        jPanel1.add(pedido_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 200, 30));

        jLabel18.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Pedido:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, 30));

        codigo_lb.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        codigo_lb.setForeground(new java.awt.Color(0, 0, 0));
        codigo_lb.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204), null));
        jPanel1.add(codigo_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 80, 30));

        jLabel19.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Tiempo:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, 30));

        tienda_origen.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        tienda_origen.setForeground(new java.awt.Color(0, 0, 0));
        tienda_origen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 204), null));
        jPanel1.add(tienda_origen, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 200, 30));

        jLabel21.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Origen:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, 30));

        marco1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 255), null, new java.awt.Color(153, 153, 153)));
        jPanel1.add(marco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 290, 230));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondoventas.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 490));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar_btActionPerformed
        OpcionesPedido a = new OpcionesPedido();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresar_btActionPerformed

    private void registrar_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_btActionPerformed
        if ((fecha_lbl.getText().equals(""))) {

            javax.swing.JOptionPane.showMessageDialog(this,"Debe seleccionar un pedido. \n","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);       
        }else if(tiempo_lbl.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(this,"Debe crear un tiempo entre tiendas. \n","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);       
        }
        else{
            insertRecibo(fecha, Login.tienda_actual, pedido_lbl.getText(), codigo_lb.getText());
            CargarTablaPedidos();
            limpiarPantalla();
        }
            
    }//GEN-LAST:event_registrar_btActionPerformed

    private void pedido_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedido_txtActionPerformed

    private void pedido_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido_btActionPerformed
       int FilaSeleccionada = pedido_jt.getSelectedRow();
       String codigo = "";
        String fecha = "";
        String origen = "";
       

        if(FilaSeleccionada>=0){
            codigo=pedido_jt.getValueAt(FilaSeleccionada,0).toString();
            fecha=pedido_jt.getValueAt(FilaSeleccionada, 1).toString();
            origen= pedido_jt.getValueAt(FilaSeleccionada, 2).toString();
          
        }
        cargarTiempo(Login.tienda_actual,origen);
       fecha_lbl.setText(fecha);
        pedido_lbl.setText(codigo);
        tienda_origen.setText(origen);
       
    }//GEN-LAST:event_pedido_btActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEntrega().setVisible(true);
            }
        });
    }
     public void KeyListenerPedido(){
      
        pedido_txt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                CargarTablaPedidos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                 CargarTablaPedidos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                 CargarTablaPedidos();
            }
           
        });
    }
    
    
    public void CargarTablaPedidos(){
         String campo = pedido_txt.getText();
        String where = "";

        if (!"".equals(campo)) {
            where = "&& codigo LIKE '%" + campo + "%' ";

        }else{
            where="";
        }
         try {
             DefaultTableModel modelo_pedido = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                return false;
                }
           };
             System.out.println("++++"+where);
           pedido_jt.setModel(modelo_pedido);
           modelo_pedido.addColumn("Codigo");
           modelo_pedido.addColumn("Fecha");
            modelo_pedido.addColumn("Tienda origen");
           modelo_pedido.addColumn("Anticipo");
           modelo_pedido.addColumn("Total");   
           String query = "SELECT P.codigo,P.fecha,P.codigo_tienda_origen,P.anticipo,P.total FROM PEDIDO P LEFT JOIN RECIBE R ON P.codigo = R.codigo_pedido WHERE R.ID IS NULL && codigo_tienda_destino='"+Login.tienda_actual+"' "+where;
           String query_pedido = "SELECT codigo,fecha,codigo_tienda_origen,anticipo,total FROM PEDIDO WHERE codigo_tienda_destino='"+Login.tienda_actual+"' "+where;
           System.out.println(query);
           ResultSet rs = a.SeleccionarJT(query);
           ResultSetMetaData rsMd = rs.getMetaData();
           int cantidadColumnas = rsMd.getColumnCount();       
           while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for(int i = 0; i<cantidadColumnas; i++){             
                    filas[i]= rs.getObject(i+1);
                }
                modelo_pedido.addRow(filas);    
            }
           rs.close();
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error "+ e);
            
        }
    }
    
    public void cargarTiempo(String tienda1,String tienda2){
          Conexion b = new Conexion();
          String Query="SELECT tiempo,ID FROM TIEMPO_DE_ENVIO WHERE ((codigo_tienda1='"+tienda1+"' && codigo_tienda2='"+tienda2+"')||(codigo_tienda1='"+tienda2+"' && codigo_tienda2='"+tienda1+"'))";

          ResultSet Result = b.SeleccionarCB(Query);
         try {
             while (Result.next()) {
               if(!(Result.equals(Result.getObject("tiempo")))){
                  tiempo_lbl.setText(String.valueOf(Result.getObject("tiempo"))); 
                  codigo_lb.setText(String.valueOf(Result.getObject("ID"))); 
                }
              }
         Result.close();
         a.disconnectDB();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }

     }
    public void insertRecibo(LocalDate fecha,String tienda,String pedido,String tiempo){
        System.out.println("entra a db");
        Statement stmt = null;
        try {
             String query = ("INSERT INTO RECIBE VALUES('"+0+"','"+fecha+"','"+tienda+"','"+pedido+"','"+tiempo+"')");
             a.conexionDB();
             stmt = a.getConnection().createStatement();
             
             stmt.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Se registro exitosamente.");
             stmt.close();
             
        }catch(Exception e) {
               JOptionPane.showMessageDialog(null,"Hay un error en Pedido "+e);
         
        }
    }
    
    
    public void limpiarPantalla(){
        fecha_lbl.setText(null);
        pedido_lbl.setText(null);
        codigo_lb.setText(null);
        tiempo_lbl.setText(null);
        tienda_origen.setText(null);
        
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codigo_lb;
    private javax.swing.JLabel fecha_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel marco1;
    private javax.swing.JLabel marco2;
    private javax.swing.JButton pedido_bt;
    private javax.swing.JTable pedido_jt;
    private javax.swing.JLabel pedido_lbl;
    private javax.swing.JTextField pedido_txt;
    private javax.swing.JButton registrar_bt;
    private javax.swing.JButton regresar_bt;
    private javax.swing.JLabel tiempo_lbl;
    private javax.swing.JLabel tienda_origen;
    // End of variables declaration//GEN-END:variables
}
