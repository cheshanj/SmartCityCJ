/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Himal Madhushan
 */
public class User implements Serializable {

    public String username;
    public String userDepartment;
    public String password;
    public String email;
    public String firstName;
    public String lastName;

    private static int userCount = 0;

    public User() {
        username = null;
        userDepartment = null;
        password = null;
        email = null;
        firstName = null;
        lastName = null;
    }

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.email = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        userCount = (Integer) ois.readObject();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(userCount));
    }

    public Object getName() {
        return username;
    }

    public Object getPassword() {
        return password;
    }

    public Object getUserType() {
        return userDepartment;
    }

    public Object getUserEmail() {
        return email;
    }
}
