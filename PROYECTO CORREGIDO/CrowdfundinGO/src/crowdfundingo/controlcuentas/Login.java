/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdfundingo.controlcuentas;

import crowdfundingo.controladores.Conecccion;
import crowdfundingo.menuprinc;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends javax.swing.JFrame {

    crearcuenta crea = new crearcuenta();
    menuprinc prin = new menuprinc();
    modcuenta mod = new modcuenta();
    Conecccion conect = new Conecccion();

    public Login() {
        initComponents();
        setIconImage(getIconImage());
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("res/ico.png"));
        return retValue;
    }

    public void validar() throws SQLException, ClassNotFoundException {
        if ("".equals(user.getText())) {
            JOptionPane.showMessageDialog(null, "[ERROR] - Nombre de usuario en blanco");
        } else {
            if ("".equals(String.valueOf(contra.getPassword()))) {
                JOptionPane.showMessageDialog(null, "[ERROR] - Contraseña en blanco");
            } else {
                String cred = conect.coneccion(user.getText(), String.valueOf(contra.getPassword()));
                System.out.println(cred);
                if (cred.isEmpty() == false) {
                    prin.show(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "[ERROR] - Usuario o contraseña no válido");
                }
            }
        }
    }

    public String getNOMBRESG() {
        return conect.NOMBRESG;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbltittle = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        lblcon = new javax.swing.JLabel();
        contra = new javax.swing.JPasswordField();
        btcon = new javax.swing.JButton();
        chgcontr = new javax.swing.JLabel();
        chgcuenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setMinimumSize(new java.awt.Dimension(300, 223));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        lbltittle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbltittle.setText("Iniciar Sesión");
        lbltittle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbluser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbluser.setText("Usuario:");

        lblcon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblcon.setText("Contraseña:");

        contra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraActionPerformed(evt);
            }
        });

        btcon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btcon.setText("Conectar");
        btcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btconMousePressed(evt);
            }
        });
        btcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconActionPerformed(evt);
            }
        });

        chgcontr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chgcontr.setForeground(new java.awt.Color(0, 102, 255));
        chgcontr.setText("¿Olvidó su contraseña?");
        chgcontr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chgcontrMouseClicked(evt);
            }
        });

        chgcuenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chgcuenta.setForeground(new java.awt.Color(0, 102, 255));
        chgcuenta.setText("Crear cuenta");
        chgcuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chgcuentaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(btcon, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(lbltittle)))
                        .addGap(0, 81, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblcon, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                    .addComponent(lbluser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(user)
                                    .addComponent(contra)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chgcontr)
                                    .addComponent(chgcuenta))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbltittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbluser)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcon)
                    .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chgcontr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chgcuenta)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void contraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraActionPerformed

    private void btconMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btconMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btconMousePressed

    private void btconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconActionPerformed
        try {
            validar();
            conect.getID(user.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la Base de datos");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btconActionPerformed

    private void chgcontrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chgcontrMouseClicked
        mod.show(true);
    }//GEN-LAST:event_chgcontrMouseClicked

    private void chgcuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chgcuentaMouseClicked
        crea.show(true);
    }//GEN-LAST:event_chgcuentaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        //
    }//GEN-LAST:event_formWindowDeactivated

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //JOptionPane.showMessageDialog(null, "Sesión Iniciada, "+getNOMBRESG()+"."+globalvars.id);
    }//GEN-LAST:event_formWindowClosed

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
            //UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcon;
    private javax.swing.JLabel chgcontr;
    private javax.swing.JLabel chgcuenta;
    public javax.swing.JPasswordField contra;
    private javax.swing.JLabel lblcon;
    private javax.swing.JLabel lbltittle;
    private javax.swing.JLabel lbluser;
    public javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
