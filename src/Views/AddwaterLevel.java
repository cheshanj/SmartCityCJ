package Views;

import Models.FloodSensor;
import Serialize.FileName;
import Serialize.Serialization;
import SetOfModels.SetOfFloodSensors;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddwaterLevel extends javax.swing.JFrame {

    private SetOfFloodSensors allFloodSensors1 = new SetOfFloodSensors();
    private SetOfFloodSensors allFloodSensors2 = new SetOfFloodSensors();
    
    public AddwaterLevel() throws ClassNotFoundException, IOException {

        initComponents();

        refreshData1();
        refreshData2();
        sensorIDComboFill();
        
    }
    
    private void refreshData1() throws ClassNotFoundException, IOException {

        try {

            allFloodSensors1.addAll(Serialization.deserializeFloodSensorsWarning());

        } 
        
        catch (IOException e) {

            Serialization.Serializing(allFloodSensors1, FileName.FILE_FLOODSENSORWARNING);

        }
    }
    
    private void refreshData2() throws ClassNotFoundException, IOException {

        try {

            allFloodSensors2.addAll(Serialization.deserializeWaterlevel());

        } 
        
        catch (IOException e) {

            Serialization.Serializing(allFloodSensors2, FileName.FILE_WATERLEVEL);

        }
    }
    
    public void sensorIDComboFill() {
        
        sensorComboBox.removeAllItems();
        sensorComboBox.addItem("Select Sensor");
        
        for(FloodSensor sensor : allFloodSensors1) {
            
            sensorComboBox.addItem(sensor.getSen_id());
            
        }
    }
    
    public void sensorLableLoad(String sID) {
    
        String wsensorID = sID;
        
        for(FloodSensor sensor : allFloodSensors1) {
            
            String se = sensor.getSen_id();
            
            if(wsensorID.equals("Select Sensor ID")) {
            
                locationLabel.setText("Location");
                riverLabel.setText("River");
                
            }
            
            else if(se.equals(wsensorID)) {
            
                locationLabel.setText(sensor.getLocation());
                riverLabel.setText(sensor.getRiver());
                
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fNameLabel1 = new javax.swing.JLabel();
        fConditionLabel1 = new javax.swing.JLabel();
        fDescriptionLabel1 = new javax.swing.JLabel();
        wlevelField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        fNameLabel2 = new javax.swing.JLabel();
        sensorComboBox = new javax.swing.JComboBox<>();
        locationLabel = new javax.swing.JLabel();
        riverLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(550, 250, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Level");

        fNameLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fNameLabel1.setText("Location");
        fNameLabel1.setPreferredSize(new java.awt.Dimension(150, 30));

        fConditionLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fConditionLabel1.setText("River");
        fConditionLabel1.setPreferredSize(new java.awt.Dimension(150, 30));

        fDescriptionLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fDescriptionLabel1.setText("Water Level");
        fDescriptionLabel1.setPreferredSize(new java.awt.Dimension(150, 30));

        wlevelField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wlevelField.setPreferredSize(new java.awt.Dimension(190, 30));

        addButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addButton.setText("Add");
        addButton.setPreferredSize(new java.awt.Dimension(90, 30));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        fNameLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fNameLabel2.setText("Sensor");
        fNameLabel2.setPreferredSize(new java.awt.Dimension(150, 30));

        sensorComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sensorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Sensor" }));
        sensorComboBox.setPreferredSize(new java.awt.Dimension(190, 30));
        sensorComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sensorComboBoxMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sensorComboBoxMouseReleased(evt);
            }
        });
        sensorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sensorComboBoxActionPerformed(evt);
            }
        });

        locationLabel.setBackground(new java.awt.Color(255, 255, 255));
        locationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationLabel.setText("Location");
        locationLabel.setPreferredSize(new java.awt.Dimension(190, 30));
        locationLabel.setRequestFocusEnabled(false);

        riverLabel.setBackground(new java.awt.Color(255, 255, 255));
        riverLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        riverLabel.setText("River");
        riverLabel.setPreferredSize(new java.awt.Dimension(190, 30));
        riverLabel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(locationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fConditionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(riverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fDescriptionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(wlevelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sensorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sensorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fConditionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(riverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fDescriptionLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wlevelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        String asensorID = sensorComboBox.getSelectedItem().toString();
        String alocation = locationLabel.getText();
        String ariver =  riverLabel.getText();
        String awlevel = wlevelField.getText();
       
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String acdate = df.format(d); 
       
        FloodSensor fs = new FloodSensor();
        
        fs.sen_id = asensorID;
        fs.location = alocation;
        fs.river = ariver;
        fs.waterlevel = awlevel;
        fs.cdate = acdate;
        
        this.allFloodSensors2.add(fs);

        try {

            Serialization.Serializing(allFloodSensors2, FileName.FILE_WATERLEVEL);

            JOptionPane.showMessageDialog(null, "Adding Successful!");
            
        } 
        
        catch(IOException ex) {

            Logger.getLogger(FloodPanel.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        sensorComboBox.setSelectedItem("Select Sensor");
        locationLabel.setText("Location");
        riverLabel.setText("River");
        wlevelField.setText("");
                
    }//GEN-LAST:event_addButtonActionPerformed

    private void sensorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sensorComboBoxActionPerformed
                
    }//GEN-LAST:event_sensorComboBoxActionPerformed

    private void sensorComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sensorComboBoxMousePressed
        
    }//GEN-LAST:event_sensorComboBoxMousePressed

    private void sensorComboBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sensorComboBoxMouseReleased
        
        String asensorID = sensorComboBox.getSelectedItem().toString();
        
        sensorLableLoad(asensorID);
        
    }//GEN-LAST:event_sensorComboBoxMouseReleased

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
            java.util.logging.Logger.getLogger(AddwaterLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddwaterLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddwaterLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddwaterLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                
                    new AddwaterLevel().setVisible(true);
                
                } 
                
                catch(ClassNotFoundException ex) {
                    
                    Logger.getLogger(AddwaterLevel.class.getName()).log(Level.SEVERE, null, ex);
                
                } 
                
                catch(IOException ex) {
                 
                    Logger.getLogger(AddwaterLevel.class.getName()).log(Level.SEVERE, null, ex);
                
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel fConditionLabel1;
    private javax.swing.JLabel fDescriptionLabel1;
    private javax.swing.JLabel fNameLabel1;
    private javax.swing.JLabel fNameLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel riverLabel;
    private javax.swing.JComboBox<String> sensorComboBox;
    private javax.swing.JTextField wlevelField;
    // End of variables declaration//GEN-END:variables
}
