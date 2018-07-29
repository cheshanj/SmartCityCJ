/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import Models.SensorMonitor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Himal Madhushan
 */
public class ParkingSlot  extends SensorMonitor implements Serializable {

    private String slotNo;
    private String slotId;
    private String suitableVehicle;
    private String price;
//    public static int slotCount = 0;

    public ParkingSlot(String SensorMonitorID, ArrayList<Double> coords, Boolean isActive, SensorType sensorType) {
        super(SensorMonitorID, coords, isActive, sensorType);
    }
    
    /**
     * @return the slot_name
     */
    public String getSlot_name() {
        return slotNo;
    }

    /**
     * @param slot_name the slot_name to set
     */
    public void setSlot_name(String slot_name) {
        this.slotNo = slot_name;
    }

    /**
     * @return the sensor_ID
     */
    public String getSensor_ID() {
        return slotId;
    }

    /**
     * @param sensor_ID the sensor_ID to set
     */
    public void setSensor_ID(String sensor_ID) {
        this.slotId = sensor_ID;
    }

    /**
     * @return the suitable
     */
    public String getSuitable() {
        return suitableVehicle;
    }

    /**
     * @param suitable the suitable to set
     */
    public void setSuitable(String suitable) {
        this.suitableVehicle = suitable;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(monitorCount));
    }
    
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException  {
        ois.defaultReadObject();
        monitorCount = (Integer)ois.readObject();     
    }
}
