package parkinglot.model;

import java.util.HashMap;

public class ParkingLotHelper {
    //create new parking lot
    //add new lot to hm

    private static ParkingLotHelper parkingLotHelper;
    HashMap<String, ParkingLot> parkingLots;
    private ParkingLotHelper(){
        parkingLots = new HashMap<>();
    }

    public static ParkingLotHelper getInstance(){
        if(parkingLotHelper == null)
            parkingLotHelper = new ParkingLotHelper();
        return parkingLotHelper;
    }

    public ParkingLot getParkingLot(String parkingLotId){
        return parkingLots.get(parkingLotId);
    }

    public void addParkingLot(String parkingLotId, int no_of_floors, int no_of_slots_per_floor){
        ParkingLot parkingLot = new ParkingLot(parkingLotId, no_of_floors, no_of_slots_per_floor);
        parkingLots.put(parkingLotId, parkingLot);
    }
}
