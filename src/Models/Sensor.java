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
 * @author Sanduni
 */
public class Sensor implements Serializable {

    public static int sensorCount = 0;
    private String sensorID;
    private SensorType sensorType;
    
    /**
     * @param sensorType the sensorType to set
     */
    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public Sensor(String sensorID, SensorType sensorTpye) {
        this.sensorID = sensorID;
        this.sensorType = sensorTpye;
    }
    
    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }
    
    /**
     * @return the sensorType
     */
    public SensorType getSensorType() {
        return sensorType;
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(sensorCount));
    }
    
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException  {
        ois.defaultReadObject();
        sensorCount = (Integer)ois.readObject();     
    }
}