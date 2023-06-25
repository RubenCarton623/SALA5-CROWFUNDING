package crowdfundingo;

import crowdfundingo.emprendedor.listproy;
import crowdfundingo.inversionista.MostraProy;
import crowdfundingo.controladores.*;
import crowdfundingo.controlcuentas.listusuarios;
import crowdfundingo.emprendedor.*;
import crowdfundingo.inversionista.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class menuprinc extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    
    public menuprinc() {
        initComponents();
        setIconImage(getIconImage());
        this.setContentPane(fondo);
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("res/ico.png"));
        return retValue;
    }

    class FondoPanel extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {
            imagen = new ImageIcon(ClassLoader.getSystemResource("res/ilus.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

    buscaproye bp = new buscaproye();
    Conecccion conect = new Conecccion();
    creaProy crp = new creaProy();
    listproy lp = new listproy();
    listdir ld = new listdir();
    listreem lru = new listreem();
    vermov vm = new vermov();
    about a = new about();
    reembproy r= new reembproy();
    listusuarios u= new listusuarios();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ini = new javax.swing.JLabel();
        ini2 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        funcionalidades = new javax.swing.JMenu();
        inversionistas = new javax.swing.JMenu();
        busproy = new javax.swing.JMenuItem();
        vertransac = new javax.swing.JMenuItem();
        emprendedor = new javax.swing.JMenu();
        creaproy = new javax.swing.JMenuItem();
        listproy = new javax.swing.JMenuItem();
        listdin = new javax.swing.JMenuItem();
        adic = new javax.swing.JMenu();
        remmbolso = new javax.swing.JMenuItem();
        listusr = new javax.swing.JMenuItem();
        reemusr = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setMinimumSize(new java.awt.Dimension(696, 396));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        ini.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ini.setText("Bienvenido, ");

        ini2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ini2.setText("ID: ");

        funcionalidades.setText("Funcionalidades");

        inversionistas.setText("Menú de Inversionista");

        busproy.setText("Buscar Proyecto");
        busproy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busproyActionPerformed(evt);
            }
        });
        inversionistas.add(busproy);

        vertransac.setText("Verificar transacciones");
        vertransac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vertransacActionPerformed(evt);
            }
        });
        inversionistas.add(vertransac);

        funcionalidades.add(inversionistas);

        emprendedor.setText("Menú de Emprendedor");

        creaproy.setText("Crear Proyecto");
        creaproy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaproyActionPerformed(evt);
            }
        });
        emprendedor.add(creaproy);

        listproy.setText("Listar los proyectos");
        listproy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listproyActionPerformed(evt);
            }
        });
        emprendedor.add(listproy);

        listdin.setText("Listar dinero recaudado");
        listdin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listdinActionPerformed(evt);
            }
        });
        emprendedor.add(listdin);

        funcionalidades.add(emprendedor);

        Menu.add(funcionalidades);

        adic.setText("Adicional");

        remmbolso.setText("Reembolsos por proyecto");
        remmbolso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remmbolsoActionPerformed(evt);
            }
        });
        adic.add(remmbolso);

        listusr.setText("Listar usuarios y cuentas");
        listusr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listusrActionPerformed(evt);
            }
        });
        adic.add(listusr);

        reemusr.setText("Reembolsos por usuario");
        reemusr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reemusrActionPerformed(evt);
            }
        });
        adic.add(reemusr);
        adic.add(jSeparator1);

        about.setText("Sobre esta app");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        adic.add(about);

        Menu.add(adic);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ini2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ini, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ini)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ini2)
                .addContainerGap(314, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vertransacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vertransacActionPerformed
        vm.show();
    }//GEN-LAST:event_vertransacActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int op = JOptionPane.showConfirmDialog(null, "¿Quieres salir del programa?", "Salida del programa", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(null, "Sesión cerrada");
        } else {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            this.setTitle("Menú Principal - "+ conect.getNames(globalvars.id));
            JOptionPane.showMessageDialog(null, "Sesión Iniciada, " + conect.getNames(globalvars.id));
            ini.setText("Bienvenido, " + conect.getNames(globalvars.id));
            ini2.setText("ID: "+globalvars.id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(menuprinc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void busproyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busproyActionPerformed
        bp.show(true);
    }//GEN-LAST:event_busproyActionPerformed

    private void creaproyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaproyActionPerformed
        crp.show();
    }//GEN-LAST:event_creaproyActionPerformed

    private void listproyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listproyActionPerformed
        lp.show();
    }//GEN-LAST:event_listproyActionPerformed

    private void listdinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listdinActionPerformed
        ld.show();
    }//GEN-LAST:event_listdinActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        a.show();
    }//GEN-LAST:event_aboutActionPerformed

    private void remmbolsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remmbolsoActionPerformed
        r.show();
    }//GEN-LAST:event_remmbolsoActionPerformed

    private void listusrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listusrActionPerformed
        u.show();
    }//GEN-LAST:event_listusrActionPerformed

    private void reemusrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reemusrActionPerformed
        lru.show();
    }//GEN-LAST:event_reemusrActionPerformed

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
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menuprinc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuprinc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuprinc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuprinc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuprinc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem about;
    private javax.swing.JMenu adic;
    private javax.swing.JMenuItem busproy;
    private javax.swing.JMenuItem creaproy;
    private javax.swing.JMenu emprendedor;
    private javax.swing.JMenu funcionalidades;
    private javax.swing.JLabel ini;
    private javax.swing.JLabel ini2;
    private javax.swing.JMenu inversionistas;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem listdin;
    private javax.swing.JMenuItem listproy;
    private javax.swing.JMenuItem listusr;
    private javax.swing.JMenuItem reemusr;
    private javax.swing.JMenuItem remmbolso;
    private javax.swing.JMenuItem vertransac;
    // End of variables declaration//GEN-END:variables
}
