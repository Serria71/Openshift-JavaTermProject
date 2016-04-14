package beans;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0640858
 */
@ApplicationScoped
@ManagedBean
public class UserController {
    private List<User> users;
    
    public UserController() {
        updateUsersFromDatabase();
    }
    public List<User> getUsers() {
        return users;
    }
    public String getUsernameById(int id){
        for (User r : users) {
            if (r.getId() == id)
                return r.getUsername();
        }
        return null;
    }
    private void updateUsersFromDatabase() {
        try {
            users = new ArrayList<>();
            
            Connection conn = Utils.getConnection();
            
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            
            while (res.next()) {
                User r = new User (
                    res.getInt("id"),
                    res.getString("userName"),
                    res.getString("password")
                );
            users.add(r);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addUser(String username, String password) {
        try (Connection conn = Utils.getConnection()) {
            if (username != "" && password != ""){
                String sql = "INSERT INTO users (username, password) VALUES(?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
