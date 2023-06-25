/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdfundingo.emprendedor;

import crowdfundingo.controladores.Conecccion;
import crowdfundingo.controladores.globalvars;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Henry Ruiz
 */
public class listproy extends javax.swing.JFrame {

    /**
     * Creates new form buscaproye
     */
    public listproy() {
        initComponents();
        setIconImage(getIconImage());
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("res/ico.png"));
        return retValue;
    }

    Conecccion conect = new Conecccion();
    
    public void llenarTablaProy() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(globalvars.conn,"crowdfundingo","12345");
        con.setSchema("CROWDFUNDINGO");
        Statement s = con.createStatement();
        s.executeQuery("SELECT ID, TITULO, LEMA, PAIS FROM PROYECTO WHERE ID_EMP=" + globalvars.id);
        ResultSet rs = s.getResultSet();
        System.out.println(rs);
        ProyTables.setModel(DbUtils.resultSetToTableModel(rs));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProyTables = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        setTitle("Buscar proyectos");
        setMinimumSize(new java.awt.Dimension(704, 466));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        ProyTables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TITULO ", "LEMA", "PAIS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProyTables.setToolTipText("");
        ProyTables.setColumnSelectionAllowed(true);
        ProyTables.setDoubleBuffered(true);
        ProyTables.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ProyTables);
        ProyTables.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (ProyTables.getColumnModel().getColumnCount() > 0) {
            ProyTables.getColumnModel().getColumn(0).setResizable(false);
            ProyTables.getColumnModel().getColumn(1).setResizable(false);
            ProyTables.getColumnModel().getColumn(2).setResizable(false);
            ProyTables.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            this.setTitle("Proyectos hechos por "+conect.getNames(globalvars.id));
            llenarTablaProy();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(listproy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        try {
            this.setTitle("Proyectos hechos por "+conect.getNames(globalvars.id));
            llenarTablaProy();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(listproy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(listproy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listproy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listproy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listproy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listproy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ProyTables;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
