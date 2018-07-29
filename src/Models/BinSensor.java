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
import java.util.ArrayList;

/**
 *
 * @author Sanduni
 */
public class BinSensor extends SensorMonitor implements Serializable {
    
    private Double binSizeInFeet;
    private String binType;
    private String binName;
    
    public BinSensor(String SensorMonitorID, ArrayList<Double> coords, Boolean isActive, SensorType sensorType) {
        super(SensorMonitorID, coords, isActive, sensorType);
    }
    
    /**
     * @return the binSizeInFeet
     */
    public Double getBinSizeInFeet() {
        return binSizeInFeet;
    }

    /**
     * @param binSizeInFeet the binSizeInFeet to set
     */
    public void setBinSizeInFeet(Double binSizeInFeet) {
        this.binSizeInFeet = binSizeInFeet;
    }

    /**
     * @return the binType
     */
    public String getBinType() {
        return binType;
    }

    /**
     * @param binType the binType to set
     */
    public void setBinType(String binType) {
        this.binType = binType;
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(monitorCount));
    }
    
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException  {
        ois.defaultReadObject();
        monitorCount = (Integer)ois.readObject();     
    }

    /**
     * @return the binName
     */
    public String getBinName() {
        return binName;
    }

    /**
     * @param binName the binName to set
     */
    public void setBinName(String binName) {
        this.binName = binName;
    }
}
