/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.User;
import Models.Journey;
import static Models.PublicInterface.data;
import Models.SensorMonitor;
import Models.Vehicle;
import Serialize.FileName;
import Serialize.Serialization;
import SetOfModels.SetOfUsers;
import SetOfModels.SetOfJourneys;
import SetOfModels.SetOfVehicles;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Cheshan Shaleekshana
 */
public class paramedicHome extends javax.swing.JFrame {
    
    private SetOfUsers allUsers = new SetOfUsers();
    private SetOfJourneys allJourneys = new SetOfJourneys();
    private SetOfVehicles allAmbulances = new SetOfVehicles();
    
    private Vector<Vector<String>> data;
    private Vector<String> header;
    SetOfJourneys allJournies = new SetOfJourneys();
    
    public paramedicHome() throws ClassNotFoundException, IOException {
        initComponents();
        this.refreshData();
        this.refreshDataParamedic();
        this.refreshDataVehicle();
        this.loadTable();
    }
    //  paramedic_journeyTable

    private void loadTable() {
        data = new Vector<Vector<String>>();
        header = new Vector<String>();
        
        header.add("Journey ID");
        header.add("Ambulance");
        header.add("Driver");
        header.add("Hospital");
        header.add("Destination");
        
        System.out.println("journey==" + allJourneys);
        for (Journey journey : allJournies) {
            Vector v = new Vector();
            v.add(journey.getJourneyID());
            v.add(journey.getAmbulance());
            v.add(journey.getDriver());
            v.add(journey.getHospital());
            v.add(journey.getDestination());
            data.add(v);
            
        }
        
        paramedic_journeyTable.setModel(new DefaultTableModel(data, header));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(paramedic_journeyTable.getModel());
        paramedic_journeyTable.setRowSorter(sorter);
        paramedic_journeyScrollPanal.setViewportView(paramedic_journeyTable);
        paramedic_journeyTable.setAutoCreateRowSorter(true);
        paramedic_journeyTable.setAutoscrolls(true);
        paramedic_journeyTable.getTableHeader().setReorderingAllowed(false);
        
    }
    
    private void refreshData() throws ClassNotFoundException, IOException {
        try {
            allUsers.addAll(Serialization.deserializeUsers());
            this.reloadPeramedicUsers();
            
        } catch (IOException e) {
            Serialization.Serializing(allUsers, FileName.USER);
        }
    }
    
    private void refreshDataVehicle() throws ClassNotFoundException, IOException {
        try {
            
            allAmbulances.addAll(Serialization.deserializeVehicles());
            this.reloadPeramedicVehicles();
            System.out.println("Ambulance: " + allAmbulances);
        } catch (IOException e) {
            Serialization.Serializing(allAmbulances, FileName.FILE_VEHICLE);
        }
    }
    
    private void refreshDataParamedic() throws ClassNotFoundException, IOException {
        try {
            
            allJourneys.addAll(Serialization.deserializeJourneys());
            System.out.println("Journey: " + allJourneys);
        } catch (IOException e) {
            Serialization.Serializing(allJourneys, FileName.FILE_JOURNEY);
        }
    }
    
    void reloadPeramedicUsers() {
        SetOfUsers paraUsers = allUsers.getParamedicUers();
        for (User user : paraUsers) {
            cmbParamedicUsers.addItem(user.firstName + " " + user.lastName);
        }
    }
    
    void reloadPeramedicVehicles() {
        SetOfVehicles paraVehicles = allAmbulances.getParamedicVehicle();
        paramedic_selectAmbulance.removeAll();
        for (Vehicle vehicle : paraVehicles) {
            paramedic_selectAmbulance.addItem(vehicle.licencePlateNumber);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbParamedicUsers = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        paramedic_selectAmbulance = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        paramedic_journeyDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pramedic_journeytime = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        paramedic_hospital = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        paramedic_hospitalLongatiude = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        paramedic_hospitalLatitude = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pramedic_nearestTown = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        paramedic_townLongatitude = new javax.swing.JTextField();
        paramedic_townLatiude = new javax.swing.JTextField();
        paramedic_journeyScrollPanal = new javax.swing.JScrollPane();
        paramedic_journeyTable = new javax.swing.JTable();
        paramedic_journeyAdd = new javax.swing.JButton();
        paramedic_journeyClear = new javax.swing.JButton();
        paramedic_journeyDemo = new javax.swing.JButton();
        paramedic_journeyId = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        paramedic_VehicleId = new javax.swing.JTextField();
        paramedic_VehicleLicensePlateNumber = new javax.swing.JTextField();
        paramedic_AmbulanceRegNumberGov = new javax.swing.JTextField();
        paramedic_CurrentOwnership = new javax.swing.JTextField();
        paramedic_ambulanceAdd = new javax.swing.JButton();
        paramedic_ambulanceClean = new javax.swing.JButton();
        paramedic_ambulanceDemo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        paramedic_ambulanceLoadTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setMinimumSize(new java.awt.Dimension(1020, 680));
        setPreferredSize(new java.awt.Dimension(1020, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Select User:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 44, -1, -1));

        cmbParamedicUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User..." }));
        jPanel1.add(cmbParamedicUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 42, 272, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Create New Journey");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 82, -1, -1));

        jLabel3.setText("Select a ambulance:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 141, -1, -1));

        paramedic_selectAmbulance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an ambulance.." }));
        jPanel1.add(paramedic_selectAmbulance, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 138, 272, -1));

        jLabel5.setText("Date:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 179, -1, -1));

        paramedic_journeyDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paramedic_journeyDateMouseClicked(evt);
            }
        });
        paramedic_journeyDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramedic_journeyDateActionPerformed(evt);
            }
        });
        jPanel1.add(paramedic_journeyDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 176, 272, -1));

        jLabel6.setText("Starting Time:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 217, -1, -1));

        pramedic_journeytime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pramedic_journeytimeMouseClicked(evt);
            }
        });
        jPanel1.add(pramedic_journeytime, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 214, 272, -1));

        jLabel7.setText("Select the hospital:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 141, -1, -1));

        paramedic_hospital.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select the hospital...", "National Hospital of Sri Lanka", "Dr Neville Fernando Hospital", "Suwasahana Hospital", "Asiri Central Hospital" }));
        paramedic_hospital.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                paramedic_hospitalPropertyChange(evt);
            }
        });
        jPanel1.add(paramedic_hospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 138, 250, -1));

        jLabel8.setText("Longitude:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 179, -1, -1));

        paramedic_hospitalLongatiude.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paramedic_hospitalLongatiudeMouseClicked(evt);
            }
        });
        jPanel1.add(paramedic_hospitalLongatiude, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 176, 250, -1));

        jLabel9.setText("Latitude:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 217, -1, -1));
        jPanel1.add(paramedic_hospitalLatitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 214, 250, -1));

        jLabel10.setText("Nearest town to the destination:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 264, -1, -1));

        pramedic_nearestTown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pramedic_nearestTownActionPerformed(evt);
            }
        });
        jPanel1.add(pramedic_nearestTown, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 261, 272, -1));

        jLabel11.setText("Longitude:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 291, -1, -1));

        jLabel12.setText("Latitude:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 332, -1, -1));

        paramedic_townLongatitude.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paramedic_townLongatitudeMouseClicked(evt);
            }
        });
        jPanel1.add(paramedic_townLongatitude, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 288, 272, -1));
        jPanel1.add(paramedic_townLatiude, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 329, 272, -1));

        paramedic_journeyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", ""
            }
        ));
        paramedic_journeyScrollPanal.setViewportView(paramedic_journeyTable);

        jPanel1.add(paramedic_journeyScrollPanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 388, 900, 208));

        paramedic_journeyAdd.setText("Add");
        paramedic_journeyAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramedic_journeyAddActionPerformed(evt);
            }
        });
        jPanel1.add(paramedic_journeyAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, -1, -1));

        paramedic_journeyClear.setText("Clear");
        paramedic_journeyClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramedic_journeyClearActionPerformed(evt);
            }
        });
        jPanel1.add(paramedic_journeyClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, -1, -1));

        paramedic_journeyDemo.setText("Demo");
        jPanel1.add(paramedic_journeyDemo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, -1, -1));
        jPanel1.add(paramedic_journeyId, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 115, 128, 17));

        jLabel17.setText("Journey ID:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jTabbedPane1.addTab("Paramedic Home | Create New Journey", jPanel1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Add New Ambulance");

        jLabel13.setText("License plate number:");

        jLabel14.setText("Vehicle ID:");

        jLabel15.setText("Current ownership:");

        jLabel16.setText("Ambulance registration number provide by goverment:");

        paramedic_ambulanceAdd.setText("Add");
        paramedic_ambulanceAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramedic_ambulanceAddActionPerformed(evt);
            }
        });

        paramedic_ambulanceClean.setText("Clean");
        paramedic_ambulanceClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramedic_ambulanceCleanActionPerformed(evt);
            }
        });

        paramedic_ambulanceDemo.setText("Demo");

        paramedic_ambulanceLoadTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane2.setViewportView(paramedic_ambulanceLoadTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(paramedic_ambulanceAdd)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(paramedic_VehicleId)
                                        .addComponent(paramedic_VehicleLicensePlateNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(136, 136, 136)
                                    .addComponent(paramedic_ambulanceClean))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(76, 76, 76)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(paramedic_ambulanceDemo)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel16)
                                                .addComponent(jLabel15))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(paramedic_AmbulanceRegNumberGov)
                                                .addComponent(paramedic_CurrentOwnership, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))))))))
                .addContainerGap(1339, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(paramedic_ambulanceDemo)))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(paramedic_VehicleId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(paramedic_AmbulanceRegNumberGov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(paramedic_VehicleLicensePlateNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(paramedic_CurrentOwnership, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paramedic_ambulanceAdd)
                    .addComponent(paramedic_ambulanceClean))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add New Ambulance", jPanel2);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("View Live Traffic Feeds");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1623, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Live Traffic Feeds", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void pramedic_nearestTownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pramedic_nearestTownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pramedic_nearestTownActionPerformed

    private void paramedic_journeyDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramedic_journeyDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramedic_journeyDateActionPerformed

    private void paramedic_journeyClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramedic_journeyClearActionPerformed
        // TODO add your handling code here:

        cmbParamedicUsers.setSelectedIndex(0);
        paramedic_journeyId.setText("");
        paramedic_selectAmbulance.setSelectedIndex(0);
        paramedic_journeyDate.setText("");
        pramedic_journeytime.setText("");
        pramedic_nearestTown.setText("");
        paramedic_townLongatitude.setText("");
        paramedic_townLatiude.setText("");
        paramedic_hospital.setSelectedIndex(0);
        paramedic_hospitalLongatiude.setText("");
        paramedic_hospitalLatitude.setText("");
    }//GEN-LAST:event_paramedic_journeyClearActionPerformed

    private void paramedic_journeyAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramedic_journeyAddActionPerformed
        
        if (paramedic_journeyDate.getText().isEmpty() == false && pramedic_journeytime.getText().isEmpty() == false && pramedic_nearestTown.getText().isEmpty() == false) {
            if (allJourneys.JourneyExists(paramedic_journeyId.getText())) {
                JOptionPane.showMessageDialog(null, "SORRY! " + paramedic_journeyId.getText() + ", Already exists!\n Try again. ", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Journey journey = new Journey(paramedic_journeyId.getText(), paramedic_journeyDate.getText(), pramedic_journeytime.getText(), paramedic_hospitalLongatiude.getText(), paramedic_hospitalLatitude.getText(), pramedic_nearestTown.getText(), paramedic_townLongatitude.getText(), paramedic_townLatiude.getText());
                
                journey.driver = cmbParamedicUsers.getSelectedItem().toString();
                journey.ambulance = paramedic_selectAmbulance.getSelectedItem().toString();
                journey.hospital = paramedic_hospital.getSelectedItem().toString();
                allJourneys.add(journey);
                try {
                    this.refreshDataParamedic();
                } catch (ClassNotFoundException ex) {
                    //      Logger.getLogger(RegisterForm1.class.getName()).log(Level.SEVERE, null, ex);
                    Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
                    
                } catch (IOException ex) {
                    Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Serialization.Serializing(allJourneys, FileName.FILE_JOURNEY);
                } catch (IOException e) {
                }
            }
        }
        

    }//GEN-LAST:event_paramedic_journeyAddActionPerformed

    private void paramedic_journeyDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paramedic_journeyDateMouseClicked
        // TODO add your handling code here:

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        paramedic_journeyDate.setText(sdf.format(d));
        
        double x = (Math.random() * ((999 - 1) + 1)) + 1;
        paramedic_journeyId.setText("paraMedic" + Double.toString(x));
    }//GEN-LAST:event_paramedic_journeyDateMouseClicked

    private void pramedic_journeytimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pramedic_journeytimeMouseClicked
        // TODO add your handling code here:

        Calendar cal = new GregorianCalendar();
        
        int sec = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        pramedic_journeytime.setText(hour + ":" + minute + ":" + sec);
    }//GEN-LAST:event_pramedic_journeytimeMouseClicked

    private void paramedic_townLongatitudeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paramedic_townLongatitudeMouseClicked
        
        try {
            // TODO add your handling code here:
            String address = pramedic_nearestTown.getText();
            String latLongs[] = getLatLongPositions(address);
            paramedic_townLatiude.setText(latLongs[0]);
            paramedic_townLongatitude.setText(latLongs[1]);
        } catch (IOException ex) {
            Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_paramedic_townLongatitudeMouseClicked

    private void paramedic_hospitalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_paramedic_hospitalPropertyChange
        // TODO add your handling code here:


    }//GEN-LAST:event_paramedic_hospitalPropertyChange

    private void paramedic_hospitalLongatiudeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paramedic_hospitalLongatiudeMouseClicked
        // TODO add your handling code here:

        try {
            // TODO add your handling code here:
            String address = paramedic_hospital.getSelectedItem().toString();
            String latLongs[] = getLatLongPositions(address);
            paramedic_hospitalLatitude.setText(latLongs[0]);
            paramedic_hospitalLongatiude.setText(latLongs[1]);
        } catch (IOException ex) {
            Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_paramedic_hospitalLongatiudeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(browserView, BorderLayout.CENTER);
        frame.setSize(1020, 680);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        String path = new File("src/maps/directions.html").getAbsolutePath();
        // System.out.println(path);

        // browser.loadURL("https://www.google.lk/maps/dir/6.8508007,79.9518236/6.8451342,79.9887083");
        browser.loadURL(path);
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void paramedic_ambulanceAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramedic_ambulanceAddActionPerformed
        // TODO add your handling code here:

        if (paramedic_VehicleId.getText().isEmpty() == false && paramedic_VehicleLicensePlateNumber.getText().isEmpty() == false && paramedic_AmbulanceRegNumberGov.getText().isEmpty() == false && paramedic_CurrentOwnership.getText().isEmpty() == false) {
            if (allAmbulances.VehicleExists(paramedic_VehicleId.getText())) {
                JOptionPane.showMessageDialog(null, "SORRY! " + paramedic_VehicleId.getText() + ", Already exists!\n Try again. ", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Vehicle vehicle = new Vehicle(paramedic_VehicleId.getText(), paramedic_VehicleLicensePlateNumber.getText(), paramedic_AmbulanceRegNumberGov.getText(), paramedic_CurrentOwnership.getText());
                
                allAmbulances.add(vehicle);
                try {
                    this.refreshDataVehicle();
                } catch (ClassNotFoundException ex) {
                    
                    Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
                    
                } catch (IOException ex) {
                    Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Serialization.Serializing(allAmbulances, FileName.FILE_VEHICLE);
                } catch (IOException e) {
                }
            }
        }
        

    }//GEN-LAST:event_paramedic_ambulanceAddActionPerformed

    private void paramedic_ambulanceCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramedic_ambulanceCleanActionPerformed
        // TODO add your handling code here:
        
        paramedic_VehicleId.setText("");
        paramedic_AmbulanceRegNumberGov.setText("");
        paramedic_VehicleLicensePlateNumber.setText("");
        paramedic_CurrentOwnership.setText("");
    }//GEN-LAST:event_paramedic_ambulanceCleanActionPerformed

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
            java.util.logging.Logger.getLogger(paramedicHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paramedicHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paramedicHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paramedicHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new paramedicHome().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(paramedicHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbParamedicUsers;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField paramedic_AmbulanceRegNumberGov;
    private javax.swing.JTextField paramedic_CurrentOwnership;
    private javax.swing.JTextField paramedic_VehicleId;
    private javax.swing.JTextField paramedic_VehicleLicensePlateNumber;
    private javax.swing.JButton paramedic_ambulanceAdd;
    private javax.swing.JButton paramedic_ambulanceClean;
    private javax.swing.JButton paramedic_ambulanceDemo;
    private javax.swing.JTable paramedic_ambulanceLoadTable;
    private javax.swing.JComboBox<String> paramedic_hospital;
    private javax.swing.JTextField paramedic_hospitalLatitude;
    private javax.swing.JTextField paramedic_hospitalLongatiude;
    private javax.swing.JButton paramedic_journeyAdd;
    private javax.swing.JButton paramedic_journeyClear;
    private javax.swing.JTextField paramedic_journeyDate;
    private javax.swing.JButton paramedic_journeyDemo;
    private javax.swing.JLabel paramedic_journeyId;
    private javax.swing.JScrollPane paramedic_journeyScrollPanal;
    private javax.swing.JTable paramedic_journeyTable;
    private javax.swing.JComboBox<String> paramedic_selectAmbulance;
    private javax.swing.JTextField paramedic_townLatiude;
    private javax.swing.JTextField paramedic_townLongatitude;
    private javax.swing.JTextField pramedic_journeytime;
    private javax.swing.JTextField pramedic_nearestTown;
    // End of variables declaration//GEN-END:variables

    private String[] getLatLongPositions(String address) throws UnsupportedEncodingException, MalformedURLException, IOException, ParserConfigurationException, SAXException, XPathExpressionException, Exception {
        
        int responseCode = 0;
        String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";
        URL url = new URL(api);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.connect();
        responseCode = httpConnection.getResponseCode();
        if (responseCode == 200) {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
            Document document = builder.parse(httpConnection.getInputStream());
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile("/GeocodeResponse/status");
            String status = (String) expr.evaluate(document, XPathConstants.STRING);
            if (status.equals("OK")) {
                expr = xpath.compile("//geometry/location/lat");
                String latitude = (String) expr.evaluate(document, XPathConstants.STRING);
                expr = xpath.compile("//geometry/location/lng");
                String longitude = (String) expr.evaluate(document, XPathConstants.STRING);
                return new String[]{latitude, longitude};
            } else {
                throw new Exception("Error from the API - response status: " + status);
            }
        }
        return null;
        
    }
}
