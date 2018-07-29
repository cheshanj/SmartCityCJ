/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Sanduni
 */
import java.io.Serializable;

/**
 *
 * @author Dul
 */
public class FloodSensor implements Serializable {

 public String sen_id;
    public String location;
    public String river;
    public String waterlevel;
    public String cdate;
    public String warninglevel;

    public FloodSensor() {

        sen_id = null;
        location = null;
        river = null;
        waterlevel = null;
        cdate = null;
        warninglevel = null;

    }

    public FloodSensor(String sid, String slocation, String sriver) {

        sid = sen_id;
        slocation = location;
        sriver = river;

    }

    public FloodSensor(String sid, String slocation, String sriver, String swaterlevel, String scdate) {
        
        sid = sen_id;
        slocation = location;
        sriver = river;
        swaterlevel = waterlevel;
        scdate = cdate;
    
    }

    public FloodSensor(String sid, String slocation, String sriver, String swarninglevel) {
        
        sid = sen_id;
        slocation = location;
        sriver = river;
        swarninglevel = warninglevel;
        
    }

    public String getSen_id() {
        
        return sen_id;
    
    }

    public void setSen_id(String sen_id) {
    
        this.sen_id = sen_id;
    
    }

    public String getLocation() {
    
        return location;
    
    }

    public void setLocation(String location) {
    
        this.location = location;
    
    }

    public String getRiver() {
    
        return river;
    
    }

    public void setRiver(String river) {
    
        this.river = river;
    
    }

    public String getWaterlevel() {
    
        return waterlevel;
    
    }

    public void setWaterlevel(String waterlevel) {
    
        this.waterlevel = waterlevel;
    
    }

    public String getCdate() {
    
        return cdate;
    
    }

    public void setCdate(String cdate) {
    
        this.cdate = cdate;
    
    }

    public String getWarninglevel() {
    
        return warninglevel;
    
    }

    public void setWarninglevel(String warninglevel) {
    
        this.warninglevel = warninglevel;
    
    }

}
