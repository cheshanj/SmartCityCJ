/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.SensorStation;
import Serialize.FileName;
import Serialize.Serialization;
import SetOfModels.SetOfStations;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Praweenkg
 */
public class AddStationForm extends javax.swing.JFrame {

    SetOfStations parkingStations = new SetOfStations();
    SetOfStations cleaningStations = new SetOfStations();
    SetOfStations trafficStations = new SetOfStations();
    SetOfStations floodStations = new SetOfStations();
    SetOfStations allStations = new SetOfStations();
    /**
     * Creates new form StationManage
     */
    public AddStationForm() throws ClassNotFoundException, IOException {
        initComponents();
        this.loadStations();
    }
    
    private void loadStations() throws ClassNotFoundException, IOException  {
        try {
            parkingStations.addAll(Serialization.deserializeParkingStations());
        } catch (IOException e) {
        }
        try {
            cleaningStations.addAll(Serialization.deserializeCleaningStations());
        } catch (IOException e) {
        }
        try {
            trafficStations.addAll(Serialization.deserializeTrafficStations());
        } catch (IOException e) {
        }
        try {
            floodStations.addAll(Serialization.deserializeFloodStations());
        } catch (IOException e) {
        }
        allStations.addAll(parkingStations);
        allStations.addAll(cleaningStations);
        allStations.addAll(trafficStations);
        allStations.addAll(floodStations);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_buttonDemo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtStationId = new javax.swing.JTextField();
        txtStationName = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        cmbDepartment = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register_buttonDemo.setText("Demo");
        register_buttonDemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_buttonDemoActionPerformed(evt);
            }
        });
        getContentPane().add(register_buttonDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(54, 33, 89));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Station ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Station Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Description");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Station Manager");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 26, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 61, 202, 15));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Department");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Station Location");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 549));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStationId.setBackground(new java.awt.Color(204, 204, 204));
        txtStationId.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtStationId.setBorder(null);
        txtStationId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStationIdFocusLost(evt);
            }
        });
        txtStationId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStationIdKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStationIdKeyReleased(evt);
            }
        });
        jPanel3.add(txtStationId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 500, 30));

        txtStationName.setBackground(new java.awt.Color(204, 204, 204));
        txtStationName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtStationName.setBorder(null);
        jPanel3.add(txtStationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 500, 30));

        txtLocation.setBackground(new java.awt.Color(204, 204, 204));
        txtLocation.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtLocation.setBorder(null);
        jPanel3.add(txtLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 500, 30));

        btnCancel.setBackground(new java.awt.Color(0, 51, 102));
        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 500, -1));

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtDescriptionMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDescriptionMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescription);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 500, -1));

        btnAdd.setBackground(new java.awt.Color(0, 51, 102));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add Station");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 347, 500, -1));

        cmbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Flood", "Cleaning", "Traffic", "Parking" }));
        cmbDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartmentActionPerformed(evt);
            }
        });
        jPanel3.add(cmbDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 500, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 100, 660, 450));

        jPanel4.setBackground(new java.awt.Color(122, 72, 221));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void register_buttonDemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_buttonDemoActionPerformed
        txtStationId.setText("S001");
        txtStationName.setText("Demo Station");
        txtLocation.setText("Baththaramulla");
        txtDescription.setText("Demo description");
    }//GEN-LAST:event_register_buttonDemoActionPerformed

    private void txtStationIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStationIdFocusLost

        // TODO add your handling code here:
    }//GEN-LAST:event_txtStationIdFocusLost

    private void txtStationIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStationIdKeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_txtStationIdKeyReleased

    private void txtStationIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStationIdKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_txtStationIdKeyTyped

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this station?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            if (txtStationId.getText().isEmpty() == false && txtStationName.getText().isEmpty() == false && txtLocation.getText().isEmpty() == false) {
                if (allStations.stationIdExists(txtStationId.getText()) == false) {
                    SensorStation station = new SensorStation(txtStationId.getText());
                    station.setStationName(txtStationName.getText());
                    station.setStationLocationName(txtLocation.getText());
                    station.setDescription(txtDescription.getText());
                    String department = cmbDepartment.getSelectedItem().toString();
                    station.setStationType(department);
                    
                    try {
                        if (department == "Parking") {
                            parkingStations.add(station);
                            Serialization.Serializing(parkingStations, FileName.STATION_PARKING);
                        } else if (department == "Cleaning") {
                            cleaningStations.add(station);
                            Serialization.Serializing(cleaningStations, FileName.STATION_CLEANING);
                        } else if (department == "Traffic") {
                            trafficStations.add(station);
                            Serialization.Serializing(trafficStations, FileName.STATION_TRAFFIC);
                        } else if (department == "Flood") {
                            floodStations.add(station);
                            Serialization.Serializing(floodStations, FileName.STATION_FLOOD);
                        }
                        this.loadStations();
                    } catch (IOException ex) {
                        Logger.getLogger(AddStationForm.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AddStationForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Station ID " + txtStationId.getText() + " is not available.", "SORRY!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill required fields. Description is optional.", "SORRY!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtDescriptionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescriptionMouseEntered
        txtDescription.setText("Optional");
    }//GEN-LAST:event_txtDescriptionMouseEntered

    private void txtDescriptionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescriptionMouseExited
        txtDescription.setText(null);
    }//GEN-LAST:event_txtDescriptionMouseExited

    private void cmbDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartmentActionPerformed
        System.out.println("cmbDepartment : "+cmbDepartment.getSelectedItem().toString());
    }//GEN-LAST:event_cmbDepartmentActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddStationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddStationForm().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddStationForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AddStationForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton register_buttonDemo;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtStationId;
    private javax.swing.JTextField txtStationName;
    // End of variables declaration//GEN-END:variables
}
