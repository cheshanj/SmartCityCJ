/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcity2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Views.RegisterForm1;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Himal Madhushan
 */
public class SmartCity2  {
//    
//    @Override
//    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        
         java.awt.EventQueue.invokeLater(new Runnable() {
             @Override
             public void run() {
                 //             librarysystem.interfaces._MainPanel login = null;
                 Views.RegisterForm1 register = null;
                 try {
                     register = new RegisterForm1();
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(SmartCity2.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException ex) {
                     Logger.getLogger(SmartCity2.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 register.setVisible(true);
             }
         });
        
    }
    
}
