/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cleaning;

import Common.GenerateIDs;

import Cleaning.RepairsUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HiM
 */
public class MaintenanceDAO {

    public void SubmitButton(GetSetForMaintenance m) {
//        FileWriter fw = null;
//        try {
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//
//            String finalCode = null;
//
//            //creating a file
//            File f1 = new File("codeincrementfiles/MaintenanceCodeIncrementFile.txt");
//            f1.createNewFile();
//
//            //reading  from the file
//            FileReader fr = new FileReader("codeincrementfiles/MaintenanceCodeIncrementFile.txt");
//            BufferedReader br = new BufferedReader(fr);
//            String line;
//
//            while ((line = br.readLine()) != null) {	//throws IOException
//                GenerateIDs gi = new GenerateIDs();
//                int itemNum = gi.findNum(line);
//                itemNum++;
//                String item = "Rec_";
//                finalCode = (item + itemNum);
//                fw = new FileWriter("codeincrementfiles/MaintenanceCodeIncrementFile.txt");
//                fw.write(finalCode);
//                fw.flush();
//            }
////            String querry = "SELECT MAchineCondition FROM  Purifying_Machine";
////            ResultSet rs = s.executeQuery(line);
//            
//            if (m.getId().equals("<Select>") || m.getType().equals("<Select>") || m.getCondition().equals("<Select>")) {
//                JOptionPane.showMessageDialog(null, "Select the correct machine ID");
//            } else {
//
//                s.executeUpdate("INSERT INTO Maint_Rec (recordID , Machin_id , M_type , M_condition , M_location , M_estbDate , M_untPrice , M_note , Maint_Rec_STATUS)  "
//                        + "VALUES( '" + finalCode + "','" + m.getId() + "','" + m.getType() + "','" + m.getCondition() + "','" + m.getLocation() + "','" + m.getDate() + "','" + m.getUnitPrice() + "','" + m.getNote() + "','" + "Active" + "')");
//                s.executeUpdate("UPDATE Purifying_Machine SET MachineCondition = '" + m.getCondition() + "'WHERE PurifierID = '" + m.getId() + "' ");
//                s.executeUpdate("UPDATE Sales SET S_dispatch = '" + "Cleared" + "'WHERE salesID = '" + m.getSalesID()+ "' ");
//                //s.executeUpdate(query);
//
//            }
//
//        } catch (ClassNotFoundException | SQLException | IOException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    //================================================================================================================

    public ArrayList getIDs(String catName) {

        ArrayList machineIDList = null;

//        try {
//
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//
//            GetSetForMaintenance g = new GetSetForMaintenance();
//
//            String querry = "SELECT MachineCondition FROM  Purifying_Machine WHERE Type = '" + catName + "' ";
//            ResultSet rs1 = s.executeQuery(querry);
//            String mCond = null;
//
//            while (rs1.next()) {
//                mCond = rs1.getString(1);
//            }
//
//            //if (mCond.equals("Damaged")|| mCond.equals("Under Repair")) {
//            //g.setCondition(mCond);
//
//            String query2 = "SELECT  PurifierID FROM Purifying_Machine WHERE Type = '" + catName + "' AND Purifying_Machine_STATUS ='" + "Active" + "' ";
//
//            System.out.println(query2);
//            ResultSet rs2 = s.executeQuery(query2);
//
//            machineIDList = new ArrayList();
//
//            while (rs2.next()) {
//                String machineID = rs2.getString(1);
//                System.out.println(machineID);
//                machineIDList.add(machineID);
//            }
//
//            //}
//
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return machineIDList;

    }

    //================================================================================================================
    public ArrayList getCategories() {
        ArrayList machineCatList = null;

//        try {
//
//
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//
//            String query = "SELECT DISTINCT Type FROM Purifying_Machine";
//
//            ResultSet rs = s.executeQuery(query);
//
//            machineCatList = new ArrayList();
//
//            while (rs.next()) {
//                String catName = rs.getString(1);
//                System.out.println(catName);
//                machineCatList.add(catName);
//            }
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return machineCatList;

    }

    //=======================
    public void getDetailsForID(GetSetForMaintenance g) {
//        try {
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//
//            String querry = "SELECT M_condition, M_location FROM Maint_Rec WHERE Machin_id = '" + g.getId() + "' AND Maint_Rec_STATUS = '" + "Active" + "' ";
//            ResultSet rs = s.executeQuery(querry);
//
//            while (rs.next()) {
//                g.setCondition(rs.getString(1));
//                g.setLocation(rs.getString(2));
//            }
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    //================================================================================================================
    public Vector fillDetails(GetSetForMaintenance g) {

        Vector<Vector<String>> machineVec = null;
        Vector<String> machineDetails = null;
        //GetSetForMaintenance g = new GetSetForMaintenance();
//        try {
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//            MaintenancePanel mp = new MaintenancePanel();
//
//            String querry = "SELECT Maint_Rec_STATUS FROM  Maint_Rec WHERE Machin_id = '" + g.getTxtSearch() + "' ";
//            ResultSet rs1 = s.executeQuery(querry);
//            String mCond = null;
//
//            while (rs1.next()) {
//                mCond = rs1.getString(1);
//            }
//
//            System.out.println("mCond ========= " + mCond);
//            machineVec = new Vector<Vector<String>>();
//
//            if (mCond.equals("Active")) {
//
//                String query = "SELECT * FROM Maint_Rec where Machin_id = '" + g.getTxtSearch() + "' AND Maint_Rec_STATUS ='" + "Active" + "' ";
//
//
//                ResultSet rs = s.executeQuery(query);
//                while (rs.next()) {
//                    //price = rs.getString("Price");
//                    machineDetails = new Vector<>();
//                    machineDetails.add(rs.getString(2));
//                    machineDetails.add(rs.getString(3));
//                    machineDetails.add(rs.getString(4));
//                    machineDetails.add(rs.getString(5));
//                    machineDetails.add(rs.getString(6));
//                    machineDetails.add(rs.getString(9));
//
//                    machineVec.add(machineDetails);
//
//                }
//            } else {
//
//                String query = "SELECT * FROM Maint_Rec where Machin_id = '" + g.getTxtSearch() + "' AND Maint_Rec_STATUS ='" + "Inactive" + "' ";
//                ResultSet rs = s.executeQuery(query);
//                while (rs.next()) {
//                    machineDetails = new Vector<>();
//                    machineDetails.add("");
//                    machineDetails.add("");
//                    machineDetails.add("");
//                    machineDetails.add("");
//                    machineDetails.add("");
//                    machineDetails.add("");
//
//                    machineVec.add(machineDetails);
//
//                    JOptionPane.showMessageDialog(mp, "No record found...!");
//                }
//
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return machineVec;

    }

    //================================================================================================================
    public void SearchButton(GetSetForMaintenance g) {
//        try {
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//
//            //GetSetForMaintenance g = new GetSetForMaintenance();
//
//            String query2 = "SELECT * FROM Maint_Rec where Machin_id = '" + g.getTxtSearch() + "' AND Maint_Rec_STATUS ='" + "Active" + "' ";
//            String query = "SELECT * FROM Maint_Rec where Machin_id = '" + g.getId() + "' OR Machin_id = '" + g.getTxtSearch() + "' AND Maint_Rec_STATUS ='" + "Active" + "' ";
//            ResultSet rs = s.executeQuery(query2);
//            while (rs.next()) {
//                g.setTypeDAO(rs.getString(3));
//                g.setIdDAO(rs.getString(2));
//
//                g.setCondition(rs.getString(4));
//                g.setLocation(rs.getString(5));
//                g.setDate(rs.getString(6));
//                g.setNote(rs.getString(8));
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void SearchButtonFromRId(GetSetForMaintenance g) {
//        try {
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//
//            //GetSetForMaintenance g = new GetSetForMaintenance();
//
//            String query2 = "SELECT * FROM Maint_Rec where M_Repair_ID = '" + g.getRepairID() + "' AND Maint_Rec_STATUS ='" + "Active" + "' ";
//            String query = "SELECT * FROM Maint_Rec where Machin_id = '" + g.getId() + "' OR Machin_id = '" + g.getTxtSearch() + "' AND Maint_Rec_STATUS ='" + "Active" + "' ";
//            ResultSet rs = s.executeQuery(query2);
//            while (rs.next()) {
//                g.setTypeDAO(rs.getString(3));
//                g.setIdDAO(rs.getString(2));
//                g.setCondition(rs.getString(4));
//                g.setLocation(rs.getString(5));
//                g.setDate(rs.getString(6));
//                g.setNote(rs.getString(8));
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    //================================================================================================================

    public void RepairButton(GetSetForMaintenance m) {
//        try {
//            MaintenancePanel mp = new MaintenancePanel();
//            String id = m.getId();
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//            ResultSet rs = s.executeQuery("SELECT Machin_id FROM Maint_Rec WHERE Machin_id = '" + id + "'");
//
//            String m_id = null;
//
//            System.out.println(id);
//            while (rs.next()) {
//                m_id = rs.getString("Machin_id");
//            }
//
////            String checkID = null;
////            ResultSet rs2 = s.executeQuery("SELECT Machin_id FROM Maint_Rec WHERE Machin_id='" + m.getMidForRepair() + "'");
////
////            while (rs2.next()) {
////                checkID = rs2.getString(1);
////            }
//
//            if (m_id.equals(id)) {
//                RepairsUI rui = new RepairsUI();
//                rui.setLocationRelativeTo(rui);
//                rui.RepairsUI(id);
//                rui.setVisible(true);
//            } else {
//                JOptionPane.showMessageDialog(mp, "Machine ID not found in records...!");
//            }
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    //================================================================================================================
    public void DeleteButton(GetSetForMaintenance m) {
//        try {
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//            String id = m.getId();
//            ResultSet rs = s.executeQuery("SELECT Machin_id FROM Maint_Rec WHERE Machin_id = '" + id + "'");
//
//            String m_id = null;
//
//            while (rs.next()) {
//                m_id = rs.getString("Machin_id");
//            }
//            if (m.getId().equals("<Select>")) {
//                JOptionPane.showMessageDialog(null, "Select the machine ID");
//            }
//            
//            else if (m_id.equals(id)) {
//                //will update Maint_Rec table
//                s.executeUpdate("UPDATE Maint_Rec SET Maint_Rec_STATUS = '" + "Inactive" + "'WHERE Machin_id = '" + m.getId() + "' ");
//                //will update Repairs table
//                s.executeUpdate("UPDATE Repairs SET Repairs_STATUS = '" + "Inactive" + "'WHERE M_id = '" + m.getId() + "' ");
//                //will update Purifying_Machine table
//                s.executeUpdate("UPDATE Purifying_Machine SET Purifying_Machine_STATUS = '" + "Inactive" + "'WHERE PurifierID = '" + m.getId() + "' ");
//
//            } else {
//                JOptionPane.showMessageDialog(null, "A record for this machine ID does not exist...!");
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }


    //================================================================================================================
    //Method for Submit button of RepairsUI
    public void SubmitOfRepair(GetSetForMaintenance m) {
//        FileWriter fw = null;
//        try {
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//
//            String finalCode = null;
//
//            File f1 = new File("RepairsCodeIncrementFile.txt");
//            f1.createNewFile();
//
//            //reading  from the file
//            FileReader fr = new FileReader("RepairsCodeIncrementFile.txt");
//            BufferedReader br = new BufferedReader(fr);
//            String line;
//
//            while ((line = br.readLine()) != null) {	//throws IOException
//                GenerateIDs gi = new GenerateIDs();
//                int itemNum = gi.findNum2(line);
//                itemNum++;
//                String item = "RPA_";
//                finalCode = (item + itemNum);
//
//                //write into the file
//                fw = new FileWriter("RepairsCodeIncrementFile.txt");
//                fw.write(finalCode);
//                fw.flush();
//            }
//
//
//            if (m.getId().equals("<Select>")) {
//                JOptionPane.showMessageDialog(null, "Select the machine ID");
//            } else {
//
//
//                s.executeUpdate("INSERT INTO Repairs VALUES('" + finalCode + "','" + m.getMidForRepair() + "','" + m.getFilterType() + "','" + m.getOtherChanges() + "','" + m.getEmployee() + "','" + m.getRepairDate() + "','" + m.getRepairResult() + "','" + "Active" + "')");
//
//                JOptionPane.showMessageDialog(null, "Record submited...!");
//
//
//
//            }
//
//        } catch (ClassNotFoundException | SQLException | IOException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    //================================================================================================================
    public ArrayList getPrices(String machineID) {

        ArrayList machinePriceList = null;

//        try {
//
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//
//            GetSetForMaintenance g = new GetSetForMaintenance();
//
//            String query2 = "SELECT  Price FROM Purifying_Machine WHERE PurifierID = '" + machineID + "' ";
//            ResultSet rs2 = s.executeQuery(query2);
//
//            machinePriceList = new ArrayList();
//
//            while (rs2.next()) {
//                String price = rs2.getString(1);
//                System.out.println(price);
//                machinePriceList.add(price);
//            }
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return machinePriceList;

    }

    //================================================================================================================
    public Vector getDetailsForID(String id) {
        Vector<Vector<String>> machineVec = null;
        Vector<String> machineDetails = null;
//        try {
//
//            //GetSetForMaintenance g = new GetSetForMaintenance();
//
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//
//            machineVec = new Vector<Vector<String>>();
//
//            String query = "SELECT * FROM Purifying_Machine where PurifierID = '" + id + "' ";
//
//            ResultSet rs = s.executeQuery(query);
//            while (rs.next()) {
//                //price = rs.getString("Price");
//                machineDetails = new Vector<>();
//                machineDetails.add(rs.getString(1));
//                machineDetails.add(rs.getString(7));
//                machineDetails.add(rs.getString(8));
//                machineDetails.add(rs.getString(9));
////                machineDetails.add(rs.getString(6));
////                machineDetails.add(rs.getString(9));
//
//                machineVec.add(machineDetails);
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return machineVec;
    }

    public Vector loadNewClients() {
        Vector<Vector<String>> clientVec = null;
        Vector<String> clientDetails = null;
//        try {
//
//
//            Connection c = Db.mycon();
//            Statement s = c.createStatement();
//
//            clientVec = new Vector<Vector<String>>();
//
//            String query = "SELECT * FROM Sales WHERE S_dispatch = '" + "Uncleared" + "' AND Sales_STATUS = '"+"Active"+"' ";
//
//            ResultSet rs = s.executeQuery(query);
//            while (rs.next()) {
//                //price = rs.getString("Price");
//                clientDetails = new Vector<>();
//                clientDetails.add(rs.getString(1));
//                clientDetails.add(rs.getString(2));
//                clientDetails.add(rs.getString(5));
//                clientDetails.add(rs.getString(6));
//                clientDetails.add(rs.getString(9));
//                //clientDetails.add(rs.getString(15));
//                clientDetails.add(rs.getString(8));
//                
//                clientVec.add(clientDetails);
//            }
//
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(MaintenanceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return clientVec;
    }
}
//==============

