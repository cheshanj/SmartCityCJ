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
 * @author Cheshan Shaleekshana
 */
public class Vehicle implements Serializable {

    public String vehicleID;
    public String licencePlateNumber;
    public String regNumberGov;
    public String ownership;

    private static int vehicleCount = 0;

    public Vehicle() {
        vehicleID = null;
        licencePlateNumber = null;
        regNumberGov = null;
        ownership = null;
    }
    
    public Vehicle(String vehicleID,String licencePlateNumber,String regNumberGov,String ownership) {
        this.vehicleID = vehicleID;
        this.licencePlateNumber= licencePlateNumber;
        this.regNumberGov = regNumberGov;
        this.ownership=ownership;
    }
    
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        vehicleCount = (Integer) ois.readObject();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(vehicleCount));
    }

    public Object getvehicleID() {
        return vehicleID;
    }
    
    public Object getLicencePlateNumber()
    {
    return licencePlateNumber;
    }
    
    public Object getRegNumberGov()
    {
    return regNumberGov;
    }
    public Object getOwnership()
    {
    return ownership;
    }

}
