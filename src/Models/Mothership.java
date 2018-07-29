/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sanduni
 */
public class Mothership implements Serializable {

    public Mothership(String ID) {
        this.ID = ID;
    }
     private String ID;
    private static List<SensorStation> SensorStations = null;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public static List<SensorStation> getSensorStations() {
        return SensorStations;
    }

    public static void setSensorStations(List<SensorStation> SensorStations) {
        Mothership.SensorStations = SensorStations;
    }

   

   
}
