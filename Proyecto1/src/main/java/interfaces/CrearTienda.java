/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import conexionDB.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author jalej
 */
public class CrearTienda extends javax.swing.JFrame {

   
    public CrearTienda() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        telefono1_txt = new javax.swing.JTextField();
        correo_txt = new javax.swing.JTextField();
        horario_txt = new javax.swing.JTextField();
        nombre_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        codigo_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        telefono2_txt = new javax.swing.JTextField();
        direccion_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Leelawadee", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresar Tienda:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Direccion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono 1:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono 2:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Horario:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        jLabel8.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cargar (1).png"))); // NOI18N
        jButton1.setText("Cargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 170, 40));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/regresar.png"))); // NOI18N
        jButton7.setText("Regresar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 170, 40));

        telefono1_txt.setBackground(new java.awt.Color(255, 255, 255));
        telefono1_txt.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        telefono1_txt.setForeground(new java.awt.Color(0, 0, 0));
        telefono1_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefono1_txtKeyTyped(evt);
            }
        });
        jPanel1.add(telefono1_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 230, 30));

        correo_txt.setBackground(new java.awt.Color(255, 255, 255));
        correo_txt.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        correo_txt.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(correo_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 230, 30));

        horario_txt.setBackground(new java.awt.Color(255, 255, 255));
        horario_txt.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        horario_txt.setForeground(new java.awt.Color(0, 0, 0));
        horario_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horario_txtActionPerformed(evt);
            }
        });
        jPanel1.add(horario_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 230, 30));

        nombre_txt.setBackground(new java.awt.Color(255, 255, 255));
        nombre_txt.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        nombre_txt.setForeground(new java.awt.Color(0, 0, 0));
        nombre_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_txtKeyTyped(evt);
            }
        });
        jPanel1.add(nombre_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 230, 30));

        jLabel9.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Codigo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        codigo_txt.setBackground(new java.awt.Color(255, 255, 255));
        codigo_txt.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        codigo_txt.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(codigo_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 230, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tienda.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        telefono2_txt.setBackground(new java.awt.Color(255, 255, 255));
        telefono2_txt.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        telefono2_txt.setForeground(new java.awt.Color(0, 0, 0));
        telefono2_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefono2_txtKeyTyped(evt);
            }
        });
        jPanel1.add(telefono2_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 230, 30));

        direccion_txt.setBackground(new java.awt.Color(255, 255, 255));
        direccion_txt.setFont(new java.awt.Font("Leelawadee", 0, 12)); // NOI18N
        direccion_txt.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(direccion_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 230, 30));

        jLabel11.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("*");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 5, -1));

        jLabel12.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("*");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 5, -1));

        jLabel13.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("*");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 5, -1));

        jLabel14.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("*");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 5, -1));

        jLabel15.setFont(new java.awt.Font("Leelawadee", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("* Campos Obligatorios");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 375, 140, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondoempresa(2).jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 730, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        IngresarDatos a = new IngresarDatos();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void horario_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horario_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horario_txtActionPerformed

    private void telefono1_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefono1_txtKeyTyped
        char c = evt.getKeyChar();
        if (telefono1_txt.getText().length()== 8) evt.consume();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_telefono1_txtKeyTyped

    private void nombre_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_txtKeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c>'z') && (c<'A' || c>'Z')&& (c<' '||c>' ')) evt.consume();
    }//GEN-LAST:event_nombre_txtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if ((codigo_txt.getText().equals("")) || (nombre_txt.getText().equals("")) || (direccion_txt.getText().equals("")) || (telefono1_txt.getText().equals(""))) {
            
            javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar todos los campos obligatorios \n","AVISO",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            codigo_txt.requestFocus();
        }else if((telefono1_txt.getText().length()< 8)){
            JOptionPane.showMessageDialog(null,"El número de telefono debe contener 8 digitos");
        }
        else {
            System.out.println("entra");
            insertDB(codigo_txt.getText(),nombre_txt.getText(),direccion_txt.getText(),telefono1_txt.getText(),telefono2_txt.getText(),correo_txt.getText(),horario_txt.getText());
       }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void telefono2_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefono2_txtKeyTyped
           char c = evt.getKeyChar();
            if (telefono2_txt.getText().length()== 8) evt.consume();
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_telefono2_txtKeyTyped

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
            java.util.logging.Logger.getLogger(CrearTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearTienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearTienda().setVisible(true);
            }
        });
    }
    
    public void insertDB(String cadena1,String cadena2,String cadena3,String cadena4,String cadena5,String cadena6,String cadena7){
        try {
             String query = ("INSERT INTO TIENDA VALUES('"+cadena1+"','"+cadena2+"','"+cadena3+"','"+cadena4+"','"+cadena5+"','"+cadena6+"','"+cadena7+"')");
             Conexion c = new Conexion();
             c.Insertar(query);
             System.out.println("Los valores han sido agregados a la base de datos ");
            vaciar();
             //c.conexionDB();
             //stmt = c.getConnection().createStatement(); 
            // stmt.executeUpdate("INSERT INTO TIENDA VALUES('"+cadena1+"','"+cadena2+"','"+cadena3+"','"+cadena4+"','"+cadena5+"','"+cadena6+"','"+cadena7+"')");
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Error "+e);
         
        }
        
    
        
    }
    
    public void vaciar(){
        codigo_txt.setText(null);
        nombre_txt.setText(null);
        direccion_txt.setText(null);
        telefono1_txt.setText(null);
        telefono2_txt.setText(null);
        correo_txt.setText(null);
        horario_txt.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo_txt;
    private javax.swing.JTextField correo_txt;
    private javax.swing.JTextField direccion_txt;
    private javax.swing.JTextField horario_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombre_txt;
    private javax.swing.JTextField telefono1_txt;
    private javax.swing.JTextField telefono2_txt;
    // End of variables declaration//GEN-END:variables
}
