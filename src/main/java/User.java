/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0640858
 */
public class User {
    /*
    CREATE TABLE users (
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        userName VARCHAR(30) NOT NULL UNIQUE,
        passhash VARCHAR(30) NOT NULL
    );
    */
    private int id;
    private String userName;
    private String passhash;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }
    
    public User (int id, String userName, String passhash) {
        this.id = id;
        this.userName = userName;
        this.passhash = passhash;
    }
}
