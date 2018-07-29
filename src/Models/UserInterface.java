/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sanduni
 */
public class UserInterface implements Serializable {

    public UserInterface(ArrayList<SensorStation> sensorStations, ArrayList<SensorMonitor> sensorMinitors) {
        this.sensorStations = sensorStations;
        this.sensorMinitors = sensorMinitors;
    }
    private static Mothership motherShip = null; 
    private ArrayList<SensorStation> sensorStations;
    private ArrayList<SensorMonitor> sensorMinitors;
    private static SensorStation currentSensorStation = null;
    private static SensorMonitor currentSensorMonitor = null;

    public static Mothership getMotherShip() {
        return motherShip;
    }

    public static void setMotherShip(Mothership motherShip) {
        UserInterface.motherShip = motherShip;
    }

    public ArrayList<SensorStation> getSensorStations() {
        return sensorStations;
    }

    public void setSensorStations(ArrayList<SensorStation> sensorStations) {
        this.sensorStations = sensorStations;
    }

    public ArrayList<SensorMonitor> getSensorMinitors() {
        return sensorMinitors;
    }

    public void setSensorMinitors(ArrayList<SensorMonitor> sensorMinitors) {
        this.sensorMinitors = sensorMinitors;
    }

    public static SensorStation getCurrentSensorStation() {
        return currentSensorStation;
    }

    public static void setCurrentSensorStation(SensorStation currentSensorStation) {
        UserInterface.currentSensorStation = currentSensorStation;
    }

    public static SensorMonitor getCurrentSensorMonitor() {
        return currentSensorMonitor;
    }

    public static void setCurrentSensorMonitor(SensorMonitor currentSensorMonitor) {
        UserInterface.currentSensorMonitor = currentSensorMonitor;
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
