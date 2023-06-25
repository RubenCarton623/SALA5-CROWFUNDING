package crowdfundingo.controlcuentas;

import crowdfundingo.controladores.Conecccion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
/**
 * Clase Crea cuenta.
 */
public class crearcuenta extends javax.swing.JFrame {

    Conecccion conect=new Conecccion();
/**
 * Constructor de Clase.
 */    
    public crearcuenta() {
        initComponents();    
        setIconImage(getIconImage());
    }
/**
 * Metodo Optiene Imagen.
 */    
    @Override
    public Image getIconImage(){
        Image retValue=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("res/ico.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblname = new javax.swing.JLabel();
        lbltittle = new javax.swing.JLabel();
        lblape = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        apel = new javax.swing.JTextField();
        lblname1 = new javax.swing.JLabel();
        lblape1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        chckval = new javax.swing.JCheckBox();
        btncrea = new javax.swing.JButton();
        contra = new javax.swing.JPasswordField();
        lblname4 = new javax.swing.JLabel();
        ncuenta = new javax.swing.JTextField();
        banco1 = new javax.swing.JTextField();
        lblname6 = new javax.swing.JLabel();
        lblname3 = new javax.swing.JLabel();
        tcuenta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Creación de cuenta");
        setMinimumSize(new java.awt.Dimension(244, 208));
        setName("crea"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        lblname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblname.setText("Nombres:");

        lbltittle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbltittle.setText("Crear cuenta");
        lbltittle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblape.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblape.setText("Apellidos:");

        lblname1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblname1.setText("Username:");

        lblape1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblape1.setText("Contraseña:");

        chckval.setText("He leido los terminos de contrato");
        chckval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckvalActionPerformed(evt);
            }
        });

        btncrea.setText("Crear Cuenta");
        btncrea.setEnabled(false);
        btncrea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreaActionPerformed(evt);
            }
        });

        lblname4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblname4.setText("Tipo de cuenta:");

        lblname6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblname6.setText("Banco:");

        lblname3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblname3.setText("No. Cuenta:");

        tcuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahorros", "Corriente" }));
        tcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lbltittle))
                    .addComponent(chckval)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btncrea))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblname6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblname4, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(lblname3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(banco1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ncuenta)
                                    .addComponent(tcuenta, 0, 124, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblape1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(lblname1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(apel, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(name)
                                    .addComponent(username)
                                    .addComponent(contra))))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbltittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblname)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblape))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblname1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblape1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblname4)
                        .addComponent(tcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ncuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblname3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(banco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblname6))
                        .addGap(26, 26, 26)))
                .addComponent(chckval)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncrea)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chckvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckvalActionPerformed
        if(chckval.isSelected()==true){
            btncrea.setEnabled(true);
        }else{
            btncrea.setEnabled(false);
        }
    }//GEN-LAST:event_chckvalActionPerformed

    private void btncreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreaActionPerformed
        try {
            conect.insertUser(name.getText(), apel.getText(), username.getText(), String.valueOf(contra.getPassword()),ncuenta.getText(),banco1.getText(),String.valueOf(tcuenta.getSelectedItem()));
            name.setText("");
            apel.setText("");
            username.setText("");
            contra.setText("");
            ncuenta.setText("");
            banco1.setText("");
            btncrea.setEnabled(false);
            chckval.setSelected(false);
            name.requestFocus();
            this.dispose();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(crearcuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btncreaActionPerformed

    private void tcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcuentaActionPerformed

    }//GEN-LAST:event_tcuentaActionPerformed
/**
 * Metodo Principal Main.
     * @param args
 */    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crearcuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new crearcuenta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apel;
    private javax.swing.JTextField banco1;
    private javax.swing.JButton btncrea;
    private javax.swing.JCheckBox chckval;
    private javax.swing.JPasswordField contra;
    private javax.swing.JLabel lblape;
    private javax.swing.JLabel lblape1;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblname1;
    private javax.swing.JLabel lblname3;
    private javax.swing.JLabel lblname4;
    private javax.swing.JLabel lblname6;
    private javax.swing.JLabel lbltittle;
    private javax.swing.JTextField name;
    private javax.swing.JTextField ncuenta;
    private javax.swing.JComboBox<String> tcuenta;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
