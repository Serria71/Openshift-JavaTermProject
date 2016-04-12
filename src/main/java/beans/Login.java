package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0640858
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Login {
    private String username;
    private String password;
    private boolean loggedIn;
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public String login() {
        String passhash = Utils.hash(password);

        for (User u : new UserController().getUsers()) {
            if (username.equals(u.getUsername())
                    && passhash.equals(u.getPasshash())) {
                loggedIn = true;
                return "game";
            }
        }
        // If the Loop Ends -- No User Exists
        loggedIn = false;
        return "index";
    }
    public String create(){
        String passhash = Utils.hash(password);
        String passhashC = Utils.hash(confirmPassword);
        
        if (passhash == passhashC){
            for (User u: new UserController().getUsers()){
                if (username.equals(u.getUsername()) && passhash.equals(u.getPasshash())){
                    UserController.addUser(username, password);
                    loggedIn = true;
                    return "game";
                } else {
                    return "index";
                }
            }
        } else {
            return "index";
        }
        return "index";
    }
    
}
