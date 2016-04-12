package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c0640858
 */
public class Utils {
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String name = "rog";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
        String username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
        //String host = "";
        //String port = "";
        //String db = "";
        //String user = "";
        //String pass = "";
        //String jdbc = "jdbc:mysql://" + host + ":" + port + "/" + db;
        //return DriverManager.getConnection(jdbc, user, pass);
    }
    public final static String SALT = "NUMBSofCHARACTERSthatAREusedfTOsaltsTHESTring";
    
    public static String hash(String password) {
        try {
            String salted = password + SALT;
            MessageDigest mess = MessageDigest.getInstance("SHA1");
            byte[] hash = mess.digest(salted.getBytes("UTF-8"));
            StringBuilder stb = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(b & 0xff).toUpperCase();
                if (hex.length() == 1) {
                    stb.append("0");
                }
                stb.append(hex);
            }
            return stb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
