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
public class PublicInterface implements Serializable {
     private String ID;
     public static List<EmbellishedData> data = null;

    public PublicInterface() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public static List<EmbellishedData> getData() {
        return data;
    }

    public static void setData(List<EmbellishedData> data) {
        PublicInterface.data = data;
    }
   
}
