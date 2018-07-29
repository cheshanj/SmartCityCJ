package Views;

import Models.FloodSensor;
import Serialize.FileName;
import Serialize.Serialization;
import SetOfModels.SetOfFloodSensors;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FloodPanel extends javax.swing.JPanel {

    private Vector<Vector<String>> data; 
    private Vector<String> header;
    private SetOfFloodSensors allFloodSensors1 = new SetOfFloodSensors();
    private SetOfFloodSensors allFloodSensors2 = new SetOfFloodSensors();
    private SetOfFloodSensors allFloodSensors3 = new SetOfFloodSensors();
    private SetOfFloodSensors allFloodSensors4 = new SetOfFloodSensors();

    public FloodPanel() throws ClassNotFoundException, IOException {

        initComponents();
         
        refreshData1();
        refreshData2();
        refreshData3();
        refreshData4();
        notifyWarning();
        floodTableLoad();
        sensorTableLoad();
        sensorwarningTableLoad();
        sensorIDComboFill();
        
    }

    private void refreshData1() throws ClassNotFoundException, IOException {

        try {

            allFloodSensors1.addAll(Serialization.deserializeFloodSensors());

        } 
        
        catch (IOException e) {

            Serialization.Serializing(allFloodSensors1, FileName.FILE_FLOODSENSOR);

        }
    }
    
    private void refreshData2() throws ClassNotFoundException, IOException {

        try {

            allFloodSensors2.addAll(Serialization.deserializeFloodSensorsWarning());

        } 
        
        catch (IOException e) {

            Serialization.Serializing(allFloodSensors2, FileName.FILE_FLOODSENSORWARNING);

        }
    }
    
    private void refreshData3() throws ClassNotFoundException, IOException {

        try {

            allFloodSensors3.addAll(Serialization.deserializeWaterlevel());

        } 
        
        catch (IOException e) {

            Serialization.Serializing(allFloodSensors3, FileName.FILE_WATERLEVEL);

        }
    }
    
    private void refreshData4() throws ClassNotFoundException, IOException {

        try {

            allFloodSensors4.addAll(Serialization.deserializeFloodNotification());

        } 
        
        catch (IOException e) {

            Serialization.Serializing(allFloodSensors4, FileName.FILE_FLOODNOTIFICATION);

        }
    }

    public void sClear() {

        sIDField.setText("");
        slocationField.setText("");
        sriverField.setText("");

    }

    public void wClear() {

        wsIDComboBox.setSelectedItem("Select Sensor ID");
        wlocationLabel.setText("Location");
        wriverLabel.setText("River");
        wwlevelField.setText("");

    }

    public void notifyWarning() {
    
        for(FloodSensor sensor1 : allFloodSensors3) {
            
            String nwater = sensor1.getWaterlevel();
            String nlocation = sensor1.getLocation();
            String nriver = sensor1.getRiver();
            
            if(nwater != null) {
                
                int nw = Integer.parseInt(nwater);

                for(FloodSensor sensor2 : allFloodSensors2) {

                    String warning = sensor2.getWarninglevel();
                    String location = sensor2.getLocation();
                    String river = sensor2.getRiver();

                    if(warning != null) {
                        
                        int w = Integer.parseInt(warning);

                        if(location.equals(nlocation)) {

                            if(river.equals(nriver)) {

                                if(nw >= w) {

                                    String cw = sensor1.getWaterlevel();
                                    String cl = sensor1.getLocation();
                                    String cr = sensor1.getRiver();
                                    String cs = sensor1.getSen_id();
                                    String cd = sensor1.getCdate();

                                    FloodSensor fsn = new FloodSensor();

                                    fsn.sen_id = cs;
                                    fsn.location = cl;
                                    fsn.river = cr;
                                    fsn.waterlevel = cw;
                                    fsn.cdate = cd;

                                    this.allFloodSensors4.add(fsn);

                                    try {

                                        Serialization.Serializing(allFloodSensors4, FileName.FILE_FLOODNOTIFICATION);
                                       
                                    } 

                                    catch(IOException ex) {

                                        Logger.getLogger(FloodPanel.class.getName()).log(Level.SEVERE, null, ex);

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void floodTableLoad() {
        
        data = new Vector<Vector<String>>();
        header = new Vector<String>();

        header.add("Sensor ID");
        header.add("Location");
        header.add("River");
        header.add("Water Level");

        for(FloodSensor sensor : allFloodSensors4) {
            
            Vector v = new Vector();
            
            v.add(sensor.getSen_id());
            v.add(sensor.getLocation());
            v.add(sensor.getRiver());
            v.add(sensor.getWaterlevel());
            
            data.add(v);
            
        }
        
        floodTable.setModel(new DefaultTableModel(data, header));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(floodTable.getModel());
        floodTable.setRowSorter(sorter);
        fTableScrollPane.setViewportView(floodTable);
        floodTable.setAutoCreateRowSorter(true);
        floodTable.setAutoscrolls(true);
        floodTable.getTableHeader().setReorderingAllowed(false);
    
    }
    
    public void floodTableLoad(String lo) {
        
        String location = lo;
        
        data = new Vector<Vector<String>>();
        header = new Vector<String>();

        header.add("Sensor ID");
        header.add("Location");
        header.add("River");
        header.add("Water Level");
        
        for(FloodSensor sensor : allFloodSensors4) {
            
            String l = sensor.getLocation();
            
            if(location.equals("")) {
                         
            }
            
            else if(l.equals(location)) {
            
                Vector v = new Vector();
            
                v.add(sensor.getSen_id());
                v.add(sensor.getLocation());
                v.add(sensor.getRiver());
                v.add(sensor.getWaterlevel());

                data.add(v);
                
            }
        }
        
        floodTable.setModel(new DefaultTableModel(data, header));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(floodTable.getModel());
        floodTable.setRowSorter(sorter);
        fTableScrollPane.setViewportView(floodTable);
        floodTable.setAutoCreateRowSorter(true);
        floodTable.setAutoscrolls(true);
        floodTable.getTableHeader().setReorderingAllowed(false);
    
    }
    
    public void sensorTableLoad() {
        
        data = new Vector<Vector<String>>();
        header = new Vector<String>();

        header.add("Sensor ID");
        header.add("Location");
        header.add("River");

        for(FloodSensor sensor : allFloodSensors1) {
            
            Vector v = new Vector();
            
            v.add(sensor.getSen_id());
            v.add(sensor.getLocation());
            v.add(sensor.getRiver());
            
            data.add(v);
            
        }
        
        sensorTable.setModel(new DefaultTableModel(data, header));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(sensorTable.getModel());
        sensorTable.setRowSorter(sorter);
        sTableScrollPane.setViewportView(sensorTable);
        sensorTable.setAutoCreateRowSorter(true);
        sensorTable.setAutoscrolls(true);
        sensorTable.getTableHeader().setReorderingAllowed(false);
    
    }
    
    public void sensorTableLoad(String se) {
        
        String sensorid = se;
        
        data = new Vector<Vector<String>>();
        header = new Vector<String>();

        header.add("Sensor ID");
        header.add("Location");
        header.add("River");
        
        for(FloodSensor sensor : allFloodSensors1) {
            
            String s = sensor.getSen_id();
            
            if(sensorid.equals("")) {
                         
            }
            
            else if(s.equals(sensorid)) {
            
                Vector v = new Vector();
            
                v.add(sensor.getSen_id());
                v.add(sensor.getLocation());
                v.add(sensor.getRiver());

                data.add(v);
                
            }
        }
        
        sensorTable.setModel(new DefaultTableModel(data, header));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(sensorTable.getModel());
        sensorTable.setRowSorter(sorter);
        sTableScrollPane.setViewportView(sensorTable);
        sensorTable.setAutoCreateRowSorter(true);
        sensorTable.setAutoscrolls(true);
        sensorTable.getTableHeader().setReorderingAllowed(false);
    
    }
    
    public void sensorwarningTableLoad() {
        
        data = new Vector<Vector<String>>();
        header = new Vector<String>();

        header.add("Sensor ID");
        header.add("Location");
        header.add("River");
        header.add("Warning Level");

        for(FloodSensor sensor : allFloodSensors2) {
            
            Vector v = new Vector();
            
            v.add(sensor.getSen_id());
            v.add(sensor.getLocation());
            v.add(sensor.getRiver());
            v.add(sensor.getWarninglevel());
            
            data.add(v);
            
        }
        
        warningTable.setModel(new DefaultTableModel(data, header));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(warningTable.getModel());
        warningTable.setRowSorter(sorter);
        fTableScrollPane1.setViewportView(warningTable);
        warningTable.setAutoCreateRowSorter(true);
        warningTable.setAutoscrolls(true);
        warningTable.getTableHeader().setReorderingAllowed(false);
    
    }
    
    public void sensorwarningTableLoad(String se) {
        
        String sensorid = se;
        
        data = new Vector<Vector<String>>();
        header = new Vector<String>();

        header.add("Sensor ID");
        header.add("Location");
        header.add("River");
        header.add("Warning Level");
        
        for(FloodSensor sensor : allFloodSensors2) {
            
            String s = sensor.getSen_id();
            
            if(sensorid.equals("")) {
                         
            }
            
            else if(s.equals(sensorid)) {
            
                Vector v = new Vector();
            
                v.add(sensor.getSen_id());
                v.add(sensor.getLocation());
                v.add(sensor.getRiver());
                v.add(sensor.getWarninglevel());

                data.add(v);
                
            }
        }
        
        warningTable.setModel(new DefaultTableModel(data, header));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(warningTable.getModel());
        warningTable.setRowSorter(sorter);
        fTableScrollPane1.setViewportView(warningTable);
        warningTable.setAutoCreateRowSorter(true);
        warningTable.setAutoscrolls(true);
        warningTable.getTableHeader().setReorderingAllowed(false);
    
    }
    
    public void locationTableLoad(String lo) {
        
        String location = lo;
        
        data = new Vector<Vector<String>>();
        header = new Vector<String>();

        header.add("Sensor ID");
        header.add("River");
        
        for(FloodSensor sensor : allFloodSensors1) {
            
            String l = sensor.getLocation();
            
            if(location.equals("")) {
                         
            }
            
            else if(l.equals(location)) {
            
                Vector v = new Vector();
            
                v.add(sensor.getSen_id());
                v.add(sensor.getRiver());

                data.add(v);
                
            }
        }
        
        locationTable.setModel(new DefaultTableModel(data, header));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(locationTable.getModel());
        locationTable.setRowSorter(sorter);
        lTableScrollPane1.setViewportView(locationTable);
        locationTable.setAutoCreateRowSorter(true);
        locationTable.setAutoscrolls(true);
        locationTable.getTableHeader().setReorderingAllowed(false);
    
    }
    
    public void sensorIDComboFill() {
        
        wsIDComboBox.removeAllItems();
        wsIDComboBox.addItem("Select Sensor ID");
        
        for(FloodSensor sensor : allFloodSensors1) {
            
            wsIDComboBox.addItem(sensor.getSen_id());
            
        }
    }
    
    public void sensorLableLoad(String wsID) {
    
        String wsensorID = wsID;
        
        for(FloodSensor sensor : allFloodSensors1) {
            
            String se = sensor.getSen_id();
            
            if(wsensorID.equals("Select Sensor ID")) {
            
                wlocationLabel.setText("Location");
                wriverLabel.setText("River");
                
            }
            
            else if(se.equals(wsensorID)) {
            
                wlocationLabel.setText(sensor.getLocation());
                wriverLabel.setText(sensor.getRiver());
                
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        floodPanel = new javax.swing.JPanel();
        fTableScrollPane = new javax.swing.JScrollPane();
        floodTable = new javax.swing.JTable();
        floodLabel = new javax.swing.JLabel();
        flocationField = new javax.swing.JTextField();
        fSearchButton = new javax.swing.JButton();
        flocationLabel = new javax.swing.JLabel();
        fwlevelLabel = new javax.swing.JLabel();
        fdescriptionLabel = new javax.swing.JLabel();
        sensorPanel = new javax.swing.JPanel();
        sIDLabel = new javax.swing.JLabel();
        sFIDLabel = new javax.swing.JLabel();
        sLIDLabel = new javax.swing.JLabel();
        sIDField = new javax.swing.JTextField();
        sAddButton = new javax.swing.JButton();
        sUpdateButton = new javax.swing.JButton();
        sDeleteButton = new javax.swing.JButton();
        sSearchButton = new javax.swing.JButton();
        sensorField = new javax.swing.JTextField();
        sensorLabel = new javax.swing.JLabel();
        sTableScrollPane = new javax.swing.JScrollPane();
        sensorTable = new javax.swing.JTable();
        sClearButton = new javax.swing.JButton();
        sriverField = new javax.swing.JTextField();
        slocationField = new javax.swing.JTextField();
        warningPanel = new javax.swing.JPanel();
        fNameLabel1 = new javax.swing.JLabel();
        fIDLabel1 = new javax.swing.JLabel();
        fConditionLabel1 = new javax.swing.JLabel();
        fDescriptionLabel1 = new javax.swing.JLabel();
        fTableScrollPane1 = new javax.swing.JScrollPane();
        warningTable = new javax.swing.JTable();
        wwlevelField = new javax.swing.JTextField();
        wDeleteButton = new javax.swing.JButton();
        wAddButton = new javax.swing.JButton();
        wUpdateButton = new javax.swing.JButton();
        floodLabel1 = new javax.swing.JLabel();
        wsensorField = new javax.swing.JTextField();
        wSearchButton = new javax.swing.JButton();
        wClearButton = new javax.swing.JButton();
        wsIDComboBox = new javax.swing.JComboBox<>();
        wlocationLabel = new javax.swing.JLabel();
        wriverLabel = new javax.swing.JLabel();
        locationPanel = new javax.swing.JPanel();
        locationLabel1 = new javax.swing.JLabel();
        locationField = new javax.swing.JTextField();
        lTableScrollPane1 = new javax.swing.JScrollPane();
        locationTable = new javax.swing.JTable();
        lSearchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 102));
        setPreferredSize(new java.awt.Dimension(1020, 680));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        floodPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        floodTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        floodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flood ID", "Flood Name", "Condition", "Description"
            }
        ));
        floodTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                floodTableMouseClicked(evt);
            }
        });
        fTableScrollPane.setViewportView(floodTable);

        floodPanel.add(fTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 970, 390));

        floodLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        floodLabel.setText("Location");
        floodLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        floodPanel.add(floodLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        flocationField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        flocationField.setPreferredSize(new java.awt.Dimension(190, 30));
        floodPanel.add(flocationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, -1));

        fSearchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fSearchButton.setText("Search");
        fSearchButton.setPreferredSize(new java.awt.Dimension(100, 30));
        fSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fSearchButtonActionPerformed(evt);
            }
        });
        floodPanel.add(fSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, -1, -1));

        flocationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        flocationLabel.setText("Location");
        flocationLabel.setPreferredSize(new java.awt.Dimension(500, 30));
        floodPanel.add(flocationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, -1, -1));

        fwlevelLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fwlevelLabel.setText("Water Level");
        fwlevelLabel.setPreferredSize(new java.awt.Dimension(500, 30));
        floodPanel.add(fwlevelLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 65, -1, -1));

        fdescriptionLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fdescriptionLabel.setText("Description");
        fdescriptionLabel.setPreferredSize(new java.awt.Dimension(500, 30));
        floodPanel.add(fdescriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 100, -1, -1));

        jTabbedPane1.addTab("Flood Notification", floodPanel);

        sensorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sIDLabel.setText("Sensor ID");
        sIDLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        sensorPanel.add(sIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, -1, -1));

        sFIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sFIDLabel.setText("Location");
        sFIDLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        sensorPanel.add(sFIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, -1, -1));

        sLIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sLIDLabel.setText("River");
        sLIDLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        sensorPanel.add(sLIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 95, -1, -1));

        sIDField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sIDField.setPreferredSize(new java.awt.Dimension(190, 30));
        sensorPanel.add(sIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 25, -1, -1));

        sAddButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sAddButton.setText("Add");
        sAddButton.setPreferredSize(new java.awt.Dimension(100, 30));
        sAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sAddButtonActionPerformed(evt);
            }
        });
        sensorPanel.add(sAddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        sUpdateButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sUpdateButton.setText("Update");
        sUpdateButton.setPreferredSize(new java.awt.Dimension(100, 30));
        sUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sUpdateButtonActionPerformed(evt);
            }
        });
        sensorPanel.add(sUpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        sDeleteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sDeleteButton.setText("Delete");
        sDeleteButton.setPreferredSize(new java.awt.Dimension(100, 30));
        sDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sDeleteButtonActionPerformed(evt);
            }
        });
        sensorPanel.add(sDeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, -1, -1));

        sSearchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sSearchButton.setText("Search");
        sSearchButton.setPreferredSize(new java.awt.Dimension(100, 30));
        sSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sSearchButtonActionPerformed(evt);
            }
        });
        sensorPanel.add(sSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, -1, -1));

        sensorField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sensorField.setPreferredSize(new java.awt.Dimension(190, 30));
        sensorPanel.add(sensorField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, -1));

        sensorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sensorLabel.setText("Sensor ID");
        sensorLabel.setPreferredSize(new java.awt.Dimension(150, 30));
        sensorPanel.add(sensorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        sensorTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sensorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sensor ID", "Flood ID", "Location ID", "Description"
            }
        ));
        sensorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sensorTableMouseClicked(evt);
            }
        });
        sTableScrollPane.setViewportView(sensorTable);

        sensorPanel.add(sTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 970, 350));

        sClearButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sClearButton.setText("Clear");
        sClearButton.setPreferredSize(new java.awt.Dimension(100, 30));
        sClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sClearButtonActionPerformed(evt);
            }
        });
        sensorPanel.add(sClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        sriverField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sriverField.setPreferredSize(new java.awt.Dimension(190, 30));
        sensorPanel.add(sriverField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 95, -1, -1));

        slocationField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        slocationField.setPreferredSize(new java.awt.Dimension(190, 30));
        sensorPanel.add(slocationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jTabbedPane1.addTab("Sensor Management", sensorPanel);

        warningPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fNameLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fNameLabel1.setText("Location");
        fNameLabel1.setPreferredSize(new java.awt.Dimension(150, 30));
        warningPanel.add(fNameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, -1, -1));

        fIDLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fIDLabel1.setText("Sensor ID");
        fIDLabel1.setPreferredSize(new java.awt.Dimension(150, 30));
        warningPanel.add(fIDLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, -1, -1));

        fConditionLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fConditionLabel1.setText("River");
        fConditionLabel1.setPreferredSize(new java.awt.Dimension(150, 30));
        warningPanel.add(fConditionLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 95, -1, -1));

        fDescriptionLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fDescriptionLabel1.setText("Warning Level");
        fDescriptionLabel1.setPreferredSize(new java.awt.Dimension(150, 30));
        warningPanel.add(fDescriptionLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 135, -1, -1));

        warningTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        warningTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flood ID", "Flood Name", "Condition", "Description"
            }
        ));
        fTableScrollPane1.setViewportView(warningTable);

        warningPanel.add(fTableScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 970, 290));

        wwlevelField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wwlevelField.setPreferredSize(new java.awt.Dimension(190, 30));
        warningPanel.add(wwlevelField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 135, -1, -1));

        wDeleteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wDeleteButton.setText("Delete");
        wDeleteButton.setPreferredSize(new java.awt.Dimension(100, 30));
        wDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wDeleteButtonActionPerformed(evt);
            }
        });
        warningPanel.add(wDeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, -1, -1));

        wAddButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wAddButton.setText("Add");
        wAddButton.setPreferredSize(new java.awt.Dimension(100, 30));
        wAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wAddButtonActionPerformed(evt);
            }
        });
        warningPanel.add(wAddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        wUpdateButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wUpdateButton.setText("Update");
        wUpdateButton.setPreferredSize(new java.awt.Dimension(100, 30));
        wUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wUpdateButtonActionPerformed(evt);
            }
        });
        warningPanel.add(wUpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        floodLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        floodLabel1.setText("Sensor ID");
        floodLabel1.setPreferredSize(new java.awt.Dimension(150, 30));
        warningPanel.add(floodLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        wsensorField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wsensorField.setPreferredSize(new java.awt.Dimension(190, 30));
        warningPanel.add(wsensorField, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, -1));

        wSearchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wSearchButton.setText("Search");
        wSearchButton.setPreferredSize(new java.awt.Dimension(100, 30));
        wSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wSearchButtonActionPerformed(evt);
            }
        });
        warningPanel.add(wSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, -1, -1));

        wClearButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wClearButton.setText("Clear");
        wClearButton.setPreferredSize(new java.awt.Dimension(100, 30));
        wClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wClearButtonActionPerformed(evt);
            }
        });
        warningPanel.add(wClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        wsIDComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wsIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Sensor ID" }));
        wsIDComboBox.setPreferredSize(new java.awt.Dimension(190, 30));
        wsIDComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                wsIDComboBoxMouseReleased(evt);
            }
        });
        wsIDComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wsIDComboBoxActionPerformed(evt);
            }
        });
        warningPanel.add(wsIDComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 25, -1, -1));

        wlocationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wlocationLabel.setText("Location");
        wlocationLabel.setPreferredSize(new java.awt.Dimension(190, 30));
        warningPanel.add(wlocationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        wriverLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        wriverLabel.setText("River");
        wriverLabel.setPreferredSize(new java.awt.Dimension(190, 30));
        warningPanel.add(wriverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 95, -1, -1));

        jTabbedPane1.addTab("Warning Management", warningPanel);

        locationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        locationLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        locationLabel1.setText("Location Name");
        locationLabel1.setPreferredSize(new java.awt.Dimension(150, 30));
        locationPanel.add(locationLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        locationField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationField.setPreferredSize(new java.awt.Dimension(190, 30));
        locationPanel.add(locationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        locationTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location ID", "Location Name", "Coordinates", "Description"
            }
        ));
        lTableScrollPane1.setViewportView(locationTable);

        locationPanel.add(lTableScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 970, 500));

        lSearchButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lSearchButton.setText("Search");
        lSearchButton.setPreferredSize(new java.awt.Dimension(100, 30));
        lSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lSearchButtonActionPerformed(evt);
            }
        });
        locationPanel.add(lSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jTabbedPane1.addTab("Location ", locationPanel);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1000, 620));

        addButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addButton.setText("Add Water Level");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, -1));

        titleLabel.setFont(new java.awt.Font("Palatino", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Flood Sensor Section");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 1020, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void fSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fSearchButtonActionPerformed

        String location = locationField.getText().toString();

        floodTableLoad(location);
        
        locationField.setText("");

    }//GEN-LAST:event_fSearchButtonActionPerformed

    private void sAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sAddButtonActionPerformed

        String ssensorID = sIDField.getText().toString();
        String slocation = slocationField.getText().toString();
        String sriver = sriverField.getText().toString();

        FloodSensor fs2 = new FloodSensor();

        fs2.sen_id = ssensorID;
        fs2.location = slocation;
        fs2.river = sriver;

        this.allFloodSensors1.add(fs2);

        try {

            Serialization.Serializing(allFloodSensors1, FileName.FILE_FLOODSENSOR);

            JOptionPane.showMessageDialog(null, "Adding Successful!");
            sensorTableLoad();
            
        } 
        
        catch(IOException ex) {

            Logger.getLogger(FloodPanel.class.getName()).log(Level.SEVERE, null, ex);

        }

        sClear();

    }//GEN-LAST:event_sAddButtonActionPerformed

    private void sUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sUpdateButtonActionPerformed

        String ssensorID = sIDField.getText();
        String slocation = slocationField.getText();
        String sriver = sriverField.getText();

        sensorTableLoad();
        sClear();

    }//GEN-LAST:event_sUpdateButtonActionPerformed

    private void sSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sSearchButtonActionPerformed

        String sensor = sensorField.getText();

        sensorTableLoad(sensor);
        
        sensorField.setText("");

    }//GEN-LAST:event_sSearchButtonActionPerformed

    private void sDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sDeleteButtonActionPerformed

        String sen = sensorField.getText();

        FloodSensor fss = new FloodSensor();
        
        for(FloodSensor sensor : allFloodSensors1) {
            
            String s = sensor.getSen_id();
            
            if(sen.equals("")) {
                         
            }
            
            else if(!(s.equals(sen))) {
            
                fss.sen_id = sensor.getSen_id();
                fss.location = sensor.getLocation();
                fss.river = sensor.getRiver();

                this.allFloodSensors1.add(fss);
                
            }
        }
       
        try {

            Serialization.Serializing(allFloodSensors1, FileName.FILE_FLOODSENSOR);

            JOptionPane.showMessageDialog(null, "Deleting Successful!");
            sensorTableLoad();
            
        } 
        
        catch(IOException ex) {

            Logger.getLogger(FloodPanel.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        sensorField.setText("");
        
        sClear();

    }//GEN-LAST:event_sDeleteButtonActionPerformed

    private void sClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sClearButtonActionPerformed

        sClear();

    }//GEN-LAST:event_sClearButtonActionPerformed

    private void lSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lSearchButtonActionPerformed

        String location = locationField.getText();

        locationTableLoad(location);
        
        locationField.setText("");

    }//GEN-LAST:event_lSearchButtonActionPerformed

    private void wDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wDeleteButtonActionPerformed

        String sensor = wsensorField.getText();

        wsensorField.setText("");
        wClear();

    }//GEN-LAST:event_wDeleteButtonActionPerformed

    private void wAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wAddButtonActionPerformed

        String wsensorID = wsIDComboBox.getSelectedItem().toString();
        String wlocation = wlocationLabel.getText().toString();
        String wriver = wriverLabel.getText().toString();
        String wwlevel = wwlevelField.getText().toString();

        FloodSensor fs3 = new FloodSensor();

        fs3.sen_id = wsensorID;
        fs3.location = wlocation;
        fs3.river = wriver;
        fs3.warninglevel = wwlevel;
        
        this.allFloodSensors2.add(fs3);

        try {

            Serialization.Serializing(allFloodSensors2, FileName.FILE_FLOODSENSORWARNING);

            JOptionPane.showMessageDialog(null, "Adding Successful!");
            sensorwarningTableLoad();
            
        } 
        
        catch(IOException ex) {

            Logger.getLogger(FloodPanel.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        wClear();

    }//GEN-LAST:event_wAddButtonActionPerformed

    private void wUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wUpdateButtonActionPerformed

        String wsensorID = wsIDComboBox.getSelectedItem().toString();
        String wlocation = wlocationLabel.getText();
        String wriver = wriverLabel.getText();
        String wwlevel = wwlevelField.getText();

        wClear();

    }//GEN-LAST:event_wUpdateButtonActionPerformed

    private void wSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wSearchButtonActionPerformed

        String sensor = wsensorField.getText();

        sensorwarningTableLoad(sensor);
        
        wsensorField.setText("");

    }//GEN-LAST:event_wSearchButtonActionPerformed

    private void wClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wClearButtonActionPerformed

        wClear();

    }//GEN-LAST:event_wClearButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        AddwaterLevel AWL = null;
        
        try {
            
            AWL = new AddwaterLevel();
        
        } 
        
        catch(ClassNotFoundException ex) {
        
            Logger.getLogger(FloodPanel.class.getName()).log(Level.SEVERE, null, ex);
        
        } 
        
        catch(IOException ex) {
            
            Logger.getLogger(FloodPanel.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        AWL.setVisible(true);

    }//GEN-LAST:event_addButtonActionPerformed

    private void floodTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_floodTableMouseClicked

        int r = floodTable.getSelectedRow();

        String location = floodTable.getValueAt(r, 1).toString();
        String wlevel = floodTable.getValueAt(r, 3).toString();

        int wl = Integer.parseInt(wlevel);
        
        if(wl > 90) {
            
            flocationLabel.setText(location);
            fwlevelLabel.setText(wlevel);
            fdescriptionLabel.setText("Very Danger!");
        
        }
        
        else if(wl > 80) {
        
            flocationLabel.setText(location);
            fwlevelLabel.setText(wlevel);
            fdescriptionLabel.setText("Danger!");
        
        }
        
        else {
        
            flocationLabel.setText(location);
            fwlevelLabel.setText(wlevel);
            fdescriptionLabel.setText("Low Danger!");
        
        }
    }//GEN-LAST:event_floodTableMouseClicked

    private void wsIDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wsIDComboBoxActionPerformed
        
    }//GEN-LAST:event_wsIDComboBoxActionPerformed

    private void wsIDComboBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wsIDComboBoxMouseReleased
        
        String ws = wsIDComboBox.getSelectedItem().toString();
        
        sensorLableLoad(ws);
        
    }//GEN-LAST:event_wsIDComboBoxMouseReleased

    private void sensorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sensorTableMouseClicked
        // TODO add your handling code here:
        
         DefaultTableModel model = (DefaultTableModel) sensorTable.getModel();
        int sectedRowIndex = sensorTable.getSelectedRow();

        sIDField.setText(model.getValueAt(sectedRowIndex, 0).toString());
        slocationField.setText(model.getValueAt(sectedRowIndex, 1).toString());
        sriverField.setText(model.getValueAt(sectedRowIndex, 2).toString());
    }//GEN-LAST:event_sensorTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel fConditionLabel1;
    private javax.swing.JLabel fDescriptionLabel1;
    private javax.swing.JLabel fIDLabel1;
    private javax.swing.JLabel fNameLabel1;
    private javax.swing.JButton fSearchButton;
    private javax.swing.JScrollPane fTableScrollPane;
    private javax.swing.JScrollPane fTableScrollPane1;
    private javax.swing.JLabel fdescriptionLabel;
    private javax.swing.JTextField flocationField;
    private javax.swing.JLabel flocationLabel;
    private javax.swing.JLabel floodLabel;
    private javax.swing.JLabel floodLabel1;
    private javax.swing.JPanel floodPanel;
    private javax.swing.JTable floodTable;
    private javax.swing.JLabel fwlevelLabel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lSearchButton;
    private javax.swing.JScrollPane lTableScrollPane1;
    private javax.swing.JTextField locationField;
    private javax.swing.JLabel locationLabel1;
    private javax.swing.JPanel locationPanel;
    private javax.swing.JTable locationTable;
    private javax.swing.JButton sAddButton;
    private javax.swing.JButton sClearButton;
    private javax.swing.JButton sDeleteButton;
    private javax.swing.JLabel sFIDLabel;
    private javax.swing.JTextField sIDField;
    private javax.swing.JLabel sIDLabel;
    private javax.swing.JLabel sLIDLabel;
    private javax.swing.JButton sSearchButton;
    private javax.swing.JScrollPane sTableScrollPane;
    private javax.swing.JButton sUpdateButton;
    private javax.swing.JTextField sensorField;
    private javax.swing.JLabel sensorLabel;
    private javax.swing.JPanel sensorPanel;
    private javax.swing.JTable sensorTable;
    private javax.swing.JTextField slocationField;
    private javax.swing.JTextField sriverField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton wAddButton;
    private javax.swing.JButton wClearButton;
    private javax.swing.JButton wDeleteButton;
    private javax.swing.JButton wSearchButton;
    private javax.swing.JButton wUpdateButton;
    private javax.swing.JPanel warningPanel;
    private javax.swing.JTable warningTable;
    private javax.swing.JLabel wlocationLabel;
    private javax.swing.JLabel wriverLabel;
    private javax.swing.JComboBox<String> wsIDComboBox;
    private javax.swing.JTextField wsensorField;
    private javax.swing.JTextField wwlevelField;
    // End of variables declaration//GEN-END:variables
}
