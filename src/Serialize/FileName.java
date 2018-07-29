/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialize;

/**
 *
 * @author Himal Madhushan
 */
public enum FileName {

    BOOKS {
        public String toString() {
            return "book.ser";
        }
    },
    USER {
        public String toString() {
            return "user.txt";
        }
    },
    STATION_PARKING {
        public String toString() {
            return "STATION_PARKING.txt";
        }
    },
    STATION_CLEANING {
        public String toString() {
            return "STATION_CLEANING.txt";
        }
    },
    STATION_FLOOD {
        public String toString() {
            return "STATION_FLOOD.txt";
        }
    },
    STATION_TRAFFIC {
        public String toString() {
            return "STATION_TRAFFIC.txt";
        }
    },
    MOTHERSHIP {
        public String toString() {
            return "mothership.txt";
        }
    },
    PARKINGSENSOR {
        public String toString() {
            return "parking_sensor.txt";
        }
    },
    PARKING {
        public String toString() {
            return "parking.txt";
        }
    },
    FILE_JOURNEY {
        public String toString() {
            return "journey.txt";
        }

    },
    FILE_VEHICLE {
        public String toString() {
            return "vehicle.txt";
        }

    },   FILE_FLOODSENSORWARNING {
        public String toString() {
            return "floodsensorwarning.ser";
        }
    },
     FILE_WATERLEVEL {
        public String toString() {
            return "FILE_WATERLEVEL.ser";
        }
    },
      FILE_FLOODSENSOR {
        public String toString() {
            return "floodsensor.ser";
        }
    },
        FILE_FLOODNOTIFICATION{
        public String toString() {
            return "FILE_FLOODNOTIFICATION.ser";
        }
    },
         FILE_FLOODLOCATION{
        public String toString() {
            return "FILE_FLOODLOCATION.ser";
        }
    }
}