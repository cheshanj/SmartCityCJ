/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetOfModels;

import java.util.Vector;
import Models.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Himal Madhushan
 */
public class SetOfUsers extends Vector<User> {
    
    public SetOfUsers() {
        super();
    }

    public void addUser(User aUser) {
        super.add(aUser);
    }
    
//    public SetOfUsers getAllUsers() {
//        SetOfUsers userSet = new SetOfUsers();
//        userSet.addAll(this);
//        return userSet;
//    }

    public boolean removeUser(User rm) {
        return super.removeElement(rm);//remove(rm);
    }
    
    public boolean userExists(String email) {
        System.out.println(email);
        boolean exists = false;
        for (User user : this) {
            System.out.println("printint USER: "+user);
            if (user.getUserEmail().equals(email)) {
                exists = true;
                System.out.println("Email: " + email + " already exists.");
            }
        }
        return exists;
    }
    
    public User getUserForLogin(String username) {
        User usr = null;
        for (User user : this) {
            System.out.println("printint USER: "+user);
            if (user.getUserEmail().equals(username)) {
                usr = user;
                System.out.println("username: " + username + " found.");
            }
        }
        return usr;
    }
    
    public SetOfUsers getParamedicUers() {
        SetOfUsers users = new SetOfUsers();
        for (User user : this) {
            if (user.userDepartment.equals("Ambulance Service ")) {
                users.add(user);
            }
        }
        return users;
    }
}
