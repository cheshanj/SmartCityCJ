/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import Models.SensorMonitor;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Sanduni
 */
public class Clock extends Observable {
    private static Clock single_instance = null;
    
    public String s;
    public Double notifyFrequncy;
    public List<SensorMonitor> observers;
 
    // private constructor restricted to this class itself
    public Clock() {
        s = "Hello I am a string part of Singleton class";
    }
 
    // static method to create instance of Singleton class
    public static Clock getInstance() {
        if (single_instance == null)
            single_instance = new Clock();
        return single_instance;
    }
    
    public void registerObserver(SensorMonitor monitor) {
        observers.add(monitor);
        setChanged();
        notifyObservers();
    }
    
    public void unregisterObserver(SensorMonitor monitor) {
        observers.remove(monitor);
        setChanged();
        notifyObservers();
    }
    
//    private void notifyObservers() {
//        
//    }
    
    private void trackTime() {
        
    }
    
    public void waitForTime() {
        
    }
}
