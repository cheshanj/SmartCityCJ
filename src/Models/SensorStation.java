/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Models.Location;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Sanduni
 */
public class SensorStation implements Serializable  {

    public SensorStation(String stationID, List<SensorMonitor> sensorsMonitors) {
        this.stationID = stationID;
        this.sensorsMonitors = sensorsMonitors;
    }
    
    public SensorStation(String stationID) {
        this.stationID = stationID;
        this.sensorsMonitors = new ArrayList<>();
    }
    
    private String stationID;
    private String stationName;
    private String stationLocationName;
    private String description;
    private List<SensorMonitor> sensorsMonitors;
    private static Mothership observer = null;
    private String stationType;
    public static int stationCount = 0;

    public SensorStation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public List<SensorMonitor> getSensorsMonitors() {
        return sensorsMonitors;
    }

    public void setSensorsMonitors(List<SensorMonitor> SensorsMonitors) {
        this.sensorsMonitors = SensorsMonitors;
    }

    public static Mothership getObserver() {
        return observer;
    }

    public static void setObserver(Mothership observer) {
        SensorStation.observer = observer;
    }

   public void addNewSensorMonitor(SensorMonitor monitor) {
       this.sensorsMonitors.add(monitor);
   }

   public void removeNewSensorMonitor(SensorMonitor monitor) {
       this.sensorsMonitors.remove(monitor);
   }
   
   /**
     * @return the stationType
     */
    public String getStationType() {
        return stationType;
    }

    /**
     * @param stationType the stationType to set
     */
    public void setStationType(String stationType) {
        this.stationType = stationType;
    }
    
   /**
     * @return the stationName
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * @param stationName the stationName to set
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * @return the stationLocationName
     */
    public String getStationLocationName() {
        return stationLocationName;
    }

    /**
     * @param stationLocationName the stationLocationName to set
     */
    public void setStationLocationName(String stationLocationName) {
        this.stationLocationName = stationLocationName;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(stationCount));
    }
    
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException  {
        ois.defaultReadObject();
        stationCount = (Integer)ois.readObject();     
    }
}
