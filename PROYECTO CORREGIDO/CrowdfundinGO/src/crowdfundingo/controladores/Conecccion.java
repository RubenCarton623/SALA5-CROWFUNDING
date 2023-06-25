package crowdfundingo.controladores;

import java.sql.*;
import javax.swing.JOptionPane;
/**
* Clase Coneccion a la base de datos.
*/
public class Conecccion {
/**
* Variable nombre.
*/
    public String NOMBRESG = "";
/**
* Variable id iidentificador.
*/
    public String id = "";
/**
* Metodo de coneccion con la base.
     * @param username
     * @param Pass
     * @return 
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
*/
    public String coneccion(String username, String Pass) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");  
        String a = "";
        Connection con = DriverManager.getConnection(globalvars.conn,"crowdfundingo","12345");
        con.setSchema("CROWDFUNDINGO");
        Statement s = con.createStatement();
        s.execute("SELECT USUARIO, CONTRASEÑA,NOMBRES,APELLIDOS FROM USUARIO WHERE USUARIO='" + username + "' AND CONTRASEÑA='" + Pass + "'");
        ResultSet rs = s.getResultSet();

        while (rs.next()) {
            a = rs.getString("USUARIO") + ";" + rs.getString("CONTRASEÑA");
            this.NOMBRESG = rs.getString("NOMBRES") + " " + rs.getString("APELLIDOS");
        }

        return a;
    }
/**
* Metodo de obtiene id.
     * @param username
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
*/
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
/**
* Metodo de obtiene nombre.
     * @param ID
     * @return 
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
*/
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
/**
* Metodo de inserta usuario.
     * @param Nombres
     * @param Apellidos
     * @param username
     * @param Pass
     * @param Bancuenta
     * @param Banco
     * @param tipoc
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
*/
     public void insertUser(String Nombres, String Apellidos, String username, String Pass, String Bancuenta, String Banco, String tipoc) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        Connection con = DriverManager.getConnection(globalvars.conn,"crowdfundingo","12345");
        con.setSchema("CROWDFUNDINGO");
        Statement s = con.createStatement();
        String ide = rand(1, 9999);
        System.out.print(ide);     
        String idebank;
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
/**
* Metodo de registra proyecto.
     * @param titulo
     * @param lema
     * @param Descripcion
     * @param Pais
     * @param link
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
*/
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
/**
* Metodo de obtiene passwaord.
     * @param username
     * @param Pass
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
*/
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
/**
* Metodo de obtiene clave random.
     * @param min
     * @param max
     * @return 
*/
    public static String rand(int min, int max) {
        String randomNum = String.valueOf(Math.floor(Math.random() * (max - min)));
        return randomNum;
    }

    
    
}
