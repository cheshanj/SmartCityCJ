/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetOfModels;

import java.util.Vector;
import Models.Journey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Cheshan Shaleekshana
 */
public class SetOfJourneys extends Vector<Journey> {

    public SetOfJourneys() {
        super();
    }

    public void addJourney(Journey aJourney) {

        super.add(aJourney);
    }

    public boolean removeJourney(Journey rm) {
        return super.removeElement(rm);//remove(rm);
    }

    public boolean JourneyExists(String journeyID) {
        System.out.println(journeyID);
        boolean exists = false;
        for (Journey journey : this) {
            System.out.println("printint Journey: " + journey);
            if (journey.getJourneyID().equals(journeyID)) {
                exists = true;
                System.out.println("Journey ID: " + journeyID + " already exists.");
            }
        }
        return exists;
    }

    

  

}
