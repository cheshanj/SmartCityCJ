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
public class Journey implements Serializable {

    public String journeyID;
    public String driver;
    public String ambulance;
    public String date;
    public String time;
    public String hospital;
    public String hospitalLongatiude;
    public String hospitalLatitude;
    public String destination;
    public String destinationLongatude;
    public String destinationLatitude;

    private static int journeyCount = 0;

    public Journey() {

        journeyID = null;
        driver = null;
        ambulance = null;
        date = null;
        time = null;
        hospital = null;
        hospitalLongatiude = null;
        hospitalLatitude = null;
        destination = null;
        destinationLongatude = null;
        destinationLatitude = null;

    }

    public Journey(String journeyID, String driver, String ambulance, String date, String time, String hospital, String hospitalLongatiude, String hospitalLatitude, String destination, String destinationLongatude, String destinationLatitude) {

        this.journeyID = journeyID;
        this.driver = driver;
        this.ambulance = ambulance;
        this.date = date;
        this.time = time;
        this.hospital = hospital;
        this.hospitalLongatiude = hospitalLongatiude;
        this.hospitalLatitude = hospitalLatitude;
        this.destination = destination;
        this.destinationLongatude = destinationLongatude;
        this.destinationLatitude = destinationLatitude;

    }

    public Journey(String journeyID, String date, String time, String hospitalLongatiude, String hospitalLatitude, String destination, String destinationLongatude, String destinationLatitude) {

        this.journeyID = journeyID;
        this.date = date;
        this.time = time;
        this.hospitalLongatiude = hospitalLongatiude;
        this.hospitalLatitude = hospitalLatitude;
        this.destination = destination;
        this.destinationLongatude = destinationLongatude;
        this.destinationLatitude = destinationLatitude;

    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        journeyCount = (Integer) ois.readObject();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new Integer(journeyCount));
    }

    public Object getJourneyID() {

        return journeyID;
    }

    public Object getDriver() {
        return driver;
    }

    public Object getAmbulance() {
        return ambulance;
    }

    public Object getDate() {
        return date;
    }

    public Object getTime() {
        return time;
    }

    public Object getHospital() {
        return hospital;
    }

    public Object getHospitalLongatiude() {
        return hospitalLongatiude;
    }

    public Object getHospitalLatitude() {
        return hospitalLatitude;
    }

    public Object getDestination() {
        return destination;

    }

    public Object getDestinationLongatude() {
        return destinationLongatude;

    }

    public Object getDestinationLatitude() {
        return destinationLatitude;
    }
}
