//package com.academy.travelapp;
//
//public class Factory {
//	public static Cat createCat(String name) {
//		throw new RuntimeException("Not supported yet!");
//	}
//
//	public static Dog createDog(String name) {
//		throw new RuntimeException("Not supported yet!");
//	}
//
//	public static Owner createOwner(String name, String town) {
//		throw new RuntimeException("Not supported yet!");
//	}
//}

package com.academy.travelapp;



import java.util.UUID;



public class Factory {
    public static createCustomer(String name) {
        return new CustomerDB(name);
    }



   public static TrainTickets createTrainTickets(String stationStart, String stationStops, int numberOfStationStops) {
        return new TrainTicketsDB();
    }



   public static BusTickets createBusTickets(String name, String town) {
        return new BusTicketsDB();
    }
    
    public static BusTickets loadedBusTickets(UUID uuid, int price, String stationStart, String StationEnd) {
        return new BusTicketsDB();
    }
    
    public static TrainTickets loadedTrainTickets(UUID uuid, int price, String StationStart, String StationEnd) {
        return new TrainTicketsDB();
    }
}