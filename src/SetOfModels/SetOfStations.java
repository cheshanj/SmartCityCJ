/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetOfModels;

import java.util.Vector;
import Models.SensorStation;

/**
 *
 * @author Himal Madhushan
 */
public class SetOfStations extends Vector<SensorStation> {
    public SetOfStations() {
        super();
    }
    
    public boolean stationIdExists(String id) {
        boolean exists = false;
        for (SensorStation station : this) {
            System.out.println(station);
            if (station.getStationID().equals(id)) {
                exists = true;
            }
        }
        return exists;
    }
    
    public SetOfStations getStationsForDeparment(String department) {
        SetOfStations cleaning = new SetOfStations();
        for (SensorStation station : this) {
            if (station.getStationType().equals(department)) {
                cleaning.add(station);
            }
        }
        return cleaning;
    }
    
    public SensorStation getStationForName(String name) {
//        System.out.println("'"+name+"'");
        SensorStation selectedStation = null;
        for (SensorStation station : this) {
            System.out.println("'"+station.getStationName()+"'");
            if (station.getStationName().equals(name)) {
                selectedStation = station;
            }
        }
        return selectedStation;
    }
}
