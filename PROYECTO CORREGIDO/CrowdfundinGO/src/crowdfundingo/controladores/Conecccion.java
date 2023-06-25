package crowdfundingo.controladores;

import java.sql.*;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import oracle.jdbc.driver.OracleDriver;

public class Conecccion {

    public String NOMBRESG = "";
    public String id = "";
    
    public String coneccion(String username, String Pass) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        String a = "";
        Connection con = DriverManager.getConnection(globalvars.conn,"crowdfundingo","12345");
        con.setSchema("CROWDFUNDINGO");
        Statement s = con.createStatement();
        s.execute("SELECT USUARIO, CONTRASEÑA,NOMBRES,APELLIDOS FROM USUARIO WHERE USUARIO='" + username + "' AND CONTRASEÑA='" + Pass + "'");
        ResultSet rs = s.getResultSet();
        System.out.println(rs.getRow());
        while (rs.next()) {
            a = rs.getString("USUARIO") + ";" + rs.getString("CONTRASEÑA");
            this.NOMBRESG = rs.getString("NOMBRES") + " " + rs.getString("APELLIDOS");
        }

        return a;
    }

    public void getID(String username) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        Connection con = DriverManager.getConnection(globalvars.conn,"crowdfundingo","12345");
        con.setSchema("CROWDFUNDINGO");
        Statement s = con.createStatement();
        s.execute("SELECT ID FROM USUARIO WHERE USUARIO='" + username + "'");
        ResultSet rs = s.getResultSet();
        while (rs.next()) {
            globalvars.id = rs.getString("ID");
        }
    }

    public String getNames(String ID) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        String names = "";
        Connection con = DriverManager.getConnection(globalvars.conn,"crowdfundingo","12345");
        con.setSchema("CROWDFUNDINGO");
        Statement s = con.createStatement();
        s.execute("SELECT NOMBRES, APELLIDOS FROM USUARIO WHERE ID=" + ID);
        ResultSet rs = s.getResultSet();
        while (rs.next()) {
            names = rs.getString("NOMBRES") + " " + rs.getString("APELLIDOS");
        }
        return names;
    }

     public void insertUser(String Nombres, String Apellidos, String username, String Pass, String Bancuenta, String Banco, String tipoc) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        Connection con = DriverManager.getConnection(globalvars.conn,"crowdfundingo","12345");
        con.setSchema("CROWDFUNDINGO");
        Statement s = con.createStatement();
        String ide = rand(1, 9999);
        System.out.print(ide);     
        String idebank = "";
        String temporalID = "";
        System.out.print(ide);
        //CREACIÓN DE CUENTA BANCARIA
        s.execute("SELECT ID_BANCUENTA FROM BANCUENTA WHERE CUENTA="+Bancuenta);
        ResultSet rss = s.getResultSet();
        while (rss.next()) {
            temporalID = rss.getString("ID_BANCUENTA");
            System.out.println(temporalID);
        }
        if(temporalID.isEmpty()){
            temporalID = rand(2000, 9999);
            String q="INSERT INTO BANCUENTA VALUES (" + temporalID + ",'" + tipoc + "'," +Bancuenta + ",'" + Banco + "',"+ide+")";
            System.out.println(q);
            s.execute(q);
        }
        idebank=temporalID;
        //CREACION DE USUARIO
        s.execute("SELECT ID FROM USUARIO WHERE USUARIO='" + username + "'");
        ResultSet rs = s.getResultSet();
        String temp = "";
        while (rs.next()) {
            temp = rs.getString("ID");
            System.out.println(temp);
        }
        if (temp.isEmpty()) {
            String qu="INSERT INTO USUARIO VALUES (" + ide + ",'" + Nombres + "','" + Apellidos + "','" + username + "','" + Pass + "'," + idebank+")";
            s.execute(qu);
            System.out.println(qu);
            JOptionPane.showMessageDialog(null, "Usuario: " + Nombres + " " + Apellidos + ", creado.");
        }   
    }

    public void insertproyecto(String titulo, String lema, String Descripcion, String Pais, String link) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        Connection con = DriverManager.getConnection(globalvars.conn,"crowdfundingo","12345");
        con.setSchema("CROWDFUNDINGO");
        Statement s = con.createStatement();
        String ide = rand(1000, 9999);
        //Consultar ID de banco
        String idebank="";
        s.execute("SELECT ID_BANCUENTA FROM USUARIO WHERE ID="+globalvars.id);
        ResultSet rss = s.getResultSet();
        while (rss.next()) {
            idebank = rss.getString("ID_BANCUENTA");
            System.out.println(idebank);
        }
        //CREACIÓN DE PROYECTO
        String query="INSERT INTO PROYECTO VALUES (" + ide+ ",'" + titulo+ "','"+lema+"','" + Descripcion+ "',0,'" + Pais+ "'," +idebank+ ","+globalvars.id+ ",'" + link+ "')";
        System.out.println(query);
        s.execute(query);
        s.execute("SELECT * FROM PROYECTO WHERE ID="+ide);
        ResultSet rs = s.getResultSet();
        String temp = "";
        while (rs.next()) {
            temp = rs.getString("ID");
            System.out.println(temp);
        }
        if (temp.isEmpty() == false) {
            JOptionPane.showMessageDialog(null, "Proyecto creado.");
        }
    }
    
    public void chgpass(String username, String Pass) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        Connection con = DriverManager.getConnection(globalvars.conn,"crowdfundingo","12345");
        con.setSchema("CROWDFUNDINGO");
        String usern="";
        Statement ver=con.createStatement();
        ver.execute("SELECT * FROM USUARIO WHERE USUARIO='" + username + "'");
        while (ver.getResultSet().next()) {
            usern=ver.getResultSet().getString("USUARIO");
        }
        if(usern.isEmpty()==false){
            Statement s = con.createStatement();
            s.execute("UPDATE USUARIO SET CONTRASEÑA='" + Pass + "' WHERE USUARIO='" + username + "'");
            JOptionPane.showMessageDialog(null,"Contraseña cambiada.");
        }else{
            JOptionPane.showMessageDialog(null, "Usuario no existe.");
        }
        
    }

    public static String rand(int min, int max) {
        String randomNum = String.valueOf(Math.floor(Math.random() * (max - min)));
        return randomNum;
    }

    
    
}
