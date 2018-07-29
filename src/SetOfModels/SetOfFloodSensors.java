/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetOfModels;

import Models.FloodSensor;
import java.util.Vector;

/**
 *
 * @author Praweenkg
 */
public class SetOfFloodSensors extends Vector<FloodSensor> {

    public SetOfFloodSensors() {
        super();
    }

    public void addFloodSensor(FloodSensor sensor) {
        super.add(sensor);
    }

    public boolean removeFloodSensor(FloodSensor rsensor) {

        return super.removeElement(rsensor);

    }

    public FloodSensor findSensorByID(int deleteSensorNo) {

        FloodSensor foundSensor = new FloodSensor();
        for (FloodSensor fSensor : this) {
            if (Integer.parseInt(fSensor.getSen_id()) == deleteSensorNo) {
                foundSensor = fSensor;

            }
        }
        System.out.println(deleteSensorNo);
        return foundSensor;
    }
}
