/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetOfModels;

import java.util.Vector;
import Models.Vehicle;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Cheshan Shaleekshana
 */
public class SetOfVehicles extends Vector<Vehicle> {

    public SetOfVehicles() {
        super();
    }

    public void addVehicle(Vehicle aVehicle) {

        super.add(aVehicle);
    }

    public boolean removeJourney(Vehicle rm) {
        return super.removeElement(rm);//remove(rm);
    }

    public boolean VehicleExists(String vehicleID) {
        System.out.println(vehicleID);
        boolean exists = false;
        for (Vehicle vehicle : this) {
            System.out.println("printint Journey: " + vehicle);
            if (vehicle.getvehicleID().equals(vehicleID)) {
                exists = true;
                System.out.println("Journey ID: " + vehicleID + " already exists.");
            }
        }
        return exists;
    }

    public SetOfVehicles getParamedicVehicle() {
        SetOfVehicles vehicles = new SetOfVehicles();
        for (Vehicle vehicle : this) {

            if (!vehicle.getvehicleID().equals("")) {
      
                 vehicles.add(vehicle);
            }
           

        }
        return vehicles;
    }
}
