package parkinglot.displayfreeslots;

import parkinglot.model.ParkingLot;
import parkinglot.model.ParkingLotHelper;
import parkinglot.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class DisplayFreeSlotsViewModel {
    DisplayFreeSlots displayFreeSlots;
    public DisplayFreeSlotsViewModel(DisplayFreeSlots displayFreeSlots) {
        this.displayFreeSlots = displayFreeSlots;
    }

    public void getFreeSlots(String type, String parkingLotId){
        VehicleType vehicleType = VehicleType.valueOf(type);
        ParkingLot parkingLot = ParkingLotHelper.getInstance().getParkingLot(parkingLotId);
        boolean[][] parked = parkingLot.getSlotsTaken();
        switch (vehicleType){
            case TRUCK:
                getTruckSlots(parked);
                break;
            case BIKE:
                getBikeSlots(parked);
                break;
            case CAR:
                getCarSlots(parked);
                break;
        }
    }

    private void getTruckSlots(boolean[][] parked){
        for(int i = 0; i < parked.length; i++){
            List<Integer> slots = new ArrayList<>();
            if(!parked[i][0])
                slots.add(1);
            displayFreeSlots.displayFreeSlots("TRUCK", i + 1, slots);
        }
    }

    private void getBikeSlots(boolean[][] parked){
        for(int i = 0; i < parked.length; i++){
            List<Integer> slots = new ArrayList<>();
            for(int j = 1; j <= 2; j++){
                if(!parked[i][j])
                    slots.add(j + 1);
            }
            displayFreeSlots.displayFreeSlots("BIKE", i + 1, slots);
        }
    }

    private void getCarSlots(boolean[][] parked){
        for(int i = 0; i < parked.length; i++){
            List<Integer> slots = new ArrayList<>();
            for(int j = 3; j < parked[0].length; j++){
                if(!parked[i][j])
                    slots.add(j + 1);
            }
            displayFreeSlots.displayFreeSlots("CAR", i + 1, slots);
        }
    }
}
