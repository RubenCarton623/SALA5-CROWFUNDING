package crowdfundingo.inversionista;

import crowdfundingo.controladores.globalvars;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.time.LocalDate;
/**
 * Constructor de Clase.
 */    
public class MostraProy extends javax.swing.JFrame {
/**
 * Constructor de Clase.
 */    
    public MostraProy() {
        initComponents();
        setIconImage(getIconImage());
        this.imagen.setOpaque(false);
    }
/**
 * Constructor de Clase.
 */    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("res/ico.png"));
        return retValue;
    }
/**
 * Constructor de Clase.
 */    
    public String titulovar, lemavar, dinerovar, descripcionvar, linkvar;

    LocalDate jtime = LocalDate.now();
    
    public static String rand(int min, int max) {
        String randomNum = String.valueOf(Math.floor(Math.random() * (max - min)));
        return randomNum;
    }
    
    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            try {
                imagen = ImageIO.read(new File(getLinkvar()));
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
                setOpaque(false);
                super.paint(g);
            } catch (IOException ex) {
                Logger.getLogger(MostraProy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
/**
 * Constructor de Clase.
     * @param titulovar
 */    
    public void setTitulovar(String titulovar) {
        this.titulo.setText(titulovar);
        this.setTitle("Mostrar proyecto - " + titulovar);
    }
/**
 * Constructor de Clase.
     * @param lemavar
 */    
    public void setLemavar(String lemavar) {
        this.lema.setText(lemavar);
    }
/**
 * Constructor de Clase.
     * @param dinerovar
 */    
    public void setDinerovar(String dinerovar) {
        this.money.setText("$" + dinerovar);
    }
/**
 * Constructor de Clase.
     * @param descripcionvar
 */    
    public void setDescripcionvar(String descripcionvar) {
        this.desc.setText("<html>" + descripcionvar + "<html>");
    }
/**
 * Constructor de Clase.
     * @param linkvar
 */    
    public void setLinkvar(String linkvar) {
        this.linkvar = linkvar;
        System.out.println(linkvar);
    }
/**
 * Constructor de Clase.
     * @return 
 */    
    public String getLinkvar() {
        return linkvar;
    }
/**
 * Constructor de Clase.
     * @param don
     * @param ID
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
 */    
    public void donacion(int don, int ID) throws SQLException, ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(globalvars.conn,"crowdfundingo","12345");
        con.setSchema("CROWDFUNDINGO");
        Statement s = con.createStatement();
        String reqidproy="SELECT ID_BANCUENTA, DINERO FROM PROYECTO WHERE ID="+ID;
        String idbancuenta="",dinero="";
        System.out.println(don);
        System.out.println(reqidproy);
        s.execute(reqidproy);
        ResultSet rsidproy = s.getResultSet();
        while (rsidproy.next()) {
            idbancuenta = rsidproy.getString("ID_BANCUENTA");
            dinero=rsidproy.getString("DINERO");
        }
        String ide = rand(1000, 9999);
        int total=Integer.valueOf(dinero)+don;
        String actualizadin="UPDATE PROYECTO "
                + "SET DINERO="+total
                +" WHERE ID="+ID;
        String insertamov="INSERT INTO MOVIMIENTOS (ID, ID_BANCUENTA, MONTO, FECHA, ID_PROYECTO ,ID_INV) "+
                "VALUES ("+ide+","+
                        idbancuenta+","+
                        don+","+
                        "CURRENT_DATE,"+
                        globalvars.idproy+","+
                        globalvars.id+")";
        System.out.println("\nID: "+ide+
                "\nSentencia SQL insercción de movimiento: "+insertamov+
                "\nCuenta bancaria: "+idbancuenta+
                "\nDinero recolectado: "+dinero+
                "\nDonación: "+don+
                "\nDinero total después de donación: "+total+
                "\nFecha: "+jtime+
                "\nSentencia SQL donación efectuada: "+actualizadin);
        s.execute(actualizadin);
        this.money.setText("$"+total);
        s.execute(insertamov);
        JOptionPane.showMessageDialog(null, "Donación realizada");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        money = new javax.swing.JLabel();
        lema = new javax.swing.JLabel();
        fijo_dinero = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        imagen = new FondoPanel();
        desc = new javax.swing.JLabel();
        Donate = new javax.swing.JSlider();
        fijo_dona = new javax.swing.JLabel();
        btndonar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Proyecto - ");
        setMinimumSize(new java.awt.Dimension(730, 611));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        titulo.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("{Titulo del proyecto}");

        money.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        money.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        money.setText("${Money}");
        money.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lema.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lema.setText("{Lema}");

        fijo_dinero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fijo_dinero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fijo_dinero.setText("Dinero recaudado para este proyecto.");

        imagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout imagenLayout = new javax.swing.GroupLayout(imagen);
        imagen.setLayout(imagenLayout);
        imagenLayout.setHorizontalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenLayout.setVerticalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        desc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        desc.setText("<html> {Descripción} </html>");
        desc.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Donate.setMajorTickSpacing(5);
        Donate.setMinorTickSpacing(5);
        Donate.setPaintTicks(true);
        Donate.setSnapToTicks(true);
        Donate.setValue(5);
        Donate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                DonateStateChanged(evt);
            }
        });

        fijo_dona.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        fijo_dona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fijo_dona.setText("Donación de $5");

        btndonar.setText("Donar");
        btndonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndonarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fijo_dinero, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(money, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(Donate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fijo_dona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btndonar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desc, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                    .addComponent(lema, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lema, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(money, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(fijo_dinero, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Donate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fijo_dona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndonar)
                        .addGap(0, 84, Short.MAX_VALUE))
                    .addComponent(desc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DonateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_DonateStateChanged
        fijo_dona.setText(String.valueOf("Donación de $"+Donate.getValue()));
        if(Donate.getValue()<1){
            btndonar.setEnabled(false);
        }else{
            btndonar.setEnabled(true);
        }
    }//GEN-LAST:event_DonateStateChanged

    private void btndonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndonarActionPerformed
        try {
            donacion(Donate.getValue(),Integer.valueOf(globalvars.idproy));
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MostraProy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btndonarActionPerformed
/**
 * Metodo principal.
     * @param args
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostraProy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MostraProy().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider Donate;
    private javax.swing.JButton btndonar;
    private javax.swing.JLabel desc;
    private javax.swing.JLabel fijo_dinero;
    private javax.swing.JLabel fijo_dona;
    private javax.swing.JPanel imagen;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lema;
    private javax.swing.JLabel money;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
