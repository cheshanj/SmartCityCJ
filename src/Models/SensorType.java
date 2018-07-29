/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Himal Madhushan
 */
public enum SensorType {
  FLOOD {
      public String toString() {
          return "FLOOD";
      }
  },
  CLEANING {
      public String toString() {
          return "CLEANING";
      }
  },
  TRAFFIC {
      public String toString() {
          return "TRAFFIC";
      }
  },
  PARKING {
      public String toString() {
          return "PARKING";
      }
  }
}
