/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Models.User;
import Serialize.FileName;
import Serialize.Serialization;
import SetOfModels.SetOfUsers;
import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Himal Madhushan
 */
public class LoginView extends javax.swing.JPanel {

    /**
     * Creates new form LoginView
     */
    
    
    public User smartCityUser;
    static User logperson_disasterManagement;
    static User logperson_parkignManagement;
    static User logperson_ambulanceService;
    static User logperson_cityCleaning;


    private SetOfUsers allUsers = new SetOfUsers();
    
    public LoginView() throws ClassNotFoundException, IOException {
        initComponents();
        this.loadUsersData();
    }

    private void loadUsersData() throws ClassNotFoundException, IOException  {
        try {
            allUsers.addAll(Serialization.deserializeUsers());
            System.out.println("users: " + allUsers);
        } catch (IOException e) {
            Serialization.Serializing(allUsers, FileName.USER);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        login = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(930, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Avenir Next", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Welcome to Smart City Management...");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Avenir Next", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, -1, -1));

        txtUsername.setToolTipText("Username");
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 190, -1));

        txtPassword.setToolTipText("Password");
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 190, -1));

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel2.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 300, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 680));
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        
        if (txtUsername.getText().isEmpty() == false && txtPassword.getText().isEmpty() == false) {
            if (allUsers.userExists(txtUsername.getText())) {
                User user = allUsers.getUserForLogin(txtUsername.getText());
                if (user != null) {
                    if (user.username == txtUsername.getText() && user.password == txtPassword.getText()) {
                        
                    } else {
                        try {
                            JOptionPane.showMessageDialog(null, "Please enter correct username or password to login.", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception ex) {
                            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } else {
            try {
                  JOptionPane.showMessageDialog(null, "Please enter username and password to login.","Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_loginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton login;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
