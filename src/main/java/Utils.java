/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        String host = "";
        String port = "";
        String db = "";
        String user = "";
        String pass = "";
        String jdbc = "jdbc:mysql://" + host + ":" + port + "/" + db;
        return DriverManager.getConnection(jdbc, user, pass);
    }
    public final static String SALT = "NUMBSofCHARACTERSthatAREusedfTOsaltsTHESTring";
    
    
    
    
}
