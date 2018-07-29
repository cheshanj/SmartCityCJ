/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialize;

import SetOfModels.SetOfFloodSensors;
import SetOfModels.SetOfUsers;
import SetOfModels.SetOfStations;
import SetOfModels.SetOfJourneys;
import SetOfModels.SetOfVehicles;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Himal Madhushan
 */
public class Serialization {

    public static void Serializing(Object obj, FileName filename) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(filename.toString());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            fos.close();
            oos.close();
            System.out.println(filename + " successfully Serialized !");
        } catch (IOException e) {
        }
    }

    public static SetOfUsers deserializeUsers() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FileName.USER.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfUsers users = (SetOfUsers) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.USER.toString() + " successfully Deserialized !");
        return users;
    }

    public static SetOfUsers deserializeSensorMonitors() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FileName.USER.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfUsers users = (SetOfUsers) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.USER.toString() + " successfully Deserialized !");
        return users;
    }
    
    public static SetOfStations deserializeParkingStations() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FileName.STATION_PARKING.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfStations stations = (SetOfStations) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.STATION_PARKING.toString() + " successfully Deserialized !");
        return stations;
    }
    
    public static SetOfStations deserializeCleaningStations() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FileName.STATION_CLEANING.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfStations stations = (SetOfStations) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.STATION_CLEANING.toString() + " successfully Deserialized !");
        return stations;
    }
    
    public static SetOfStations deserializeTrafficStations() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FileName.STATION_TRAFFIC.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfStations stations = (SetOfStations) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.STATION_TRAFFIC.toString() + " successfully Deserialized !");
        return stations;
    }
    
    public static SetOfStations deserializeFloodStations() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FileName.STATION_FLOOD.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfStations stations = (SetOfStations) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.STATION_FLOOD.toString() + " successfully Deserialized !");
        return stations;
    }
    
    public static SetOfUsers deserializeMothership() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FileName.USER.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfUsers users = (SetOfUsers) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.USER.toString() + " successfully Deserialized !");
        return users;
    }

    public static SetOfJourneys deserializeJourneys() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FileName.FILE_JOURNEY.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfJourneys journey = (SetOfJourneys) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.FILE_JOURNEY.toString() + " successfully Deserialized !");
        return journey;
    }

    public static SetOfVehicles deserializeVehicles() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(FileName.FILE_VEHICLE.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfVehicles vehicle = (SetOfVehicles) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.FILE_VEHICLE.toString() + " successfully Deserialized !");
        return vehicle;
    }
    
      public static SetOfFloodSensors deserializeFloodSensorsWarning() throws IOException, ClassNotFoundException {
        
        FileInputStream fis = new FileInputStream(FileName.FILE_FLOODSENSORWARNING.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfFloodSensors FSensors = (SetOfFloodSensors) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.FILE_FLOODSENSORWARNING.toString() + " successfully Deserialized !");
        return FSensors;
    
    }
      
      
         public static SetOfFloodSensors deserializeWaterlevel() throws IOException, ClassNotFoundException {
        
        FileInputStream fis = new FileInputStream(FileName.FILE_WATERLEVEL.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfFloodSensors FSensors = (SetOfFloodSensors) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.FILE_WATERLEVEL.toString() + " successfully Deserialized !");
        return FSensors;
    
    }
          public static SetOfFloodSensors deserializeFloodSensors() throws IOException, ClassNotFoundException {
        
        FileInputStream fis = new FileInputStream(FileName.FILE_FLOODSENSOR.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfFloodSensors FSensors = (SetOfFloodSensors) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.FILE_FLOODSENSOR.toString() + " successfully Deserialized !");
        return FSensors;
    
    }
          
              public static SetOfFloodSensors deserializeFloodNotification() throws IOException, ClassNotFoundException {
        
        FileInputStream fis = new FileInputStream(FileName.FILE_FLOODNOTIFICATION.toString());
        ObjectInputStream ois = new ObjectInputStream(fis);
        SetOfFloodSensors FSensors = (SetOfFloodSensors) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(FileName.FILE_FLOODNOTIFICATION.toString() + " successfully Deserialized !");
        return FSensors;
    
    }
        
    }
