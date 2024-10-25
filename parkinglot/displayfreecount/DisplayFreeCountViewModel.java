package parkinglot.displayfreecount;

import parkinglot.model.ParkingLot;
import parkinglot.model.ParkingLotHelper;
import parkinglot.model.VehicleType;

public class DisplayFreeCountViewModel {
    DisplayFreeCount displayFreeCount;
    public DisplayFreeCountViewModel(DisplayFreeCount displayFreeCount) {
        this.displayFreeCount = displayFreeCount;
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
            if(!parked[i][0])
                displayFreeCount.displaySlots("Truck", i + 1, 1);
            else
                displayFreeCount.displaySlots("Truck", i + 1, 0);
        }
    }

    private void getBikeSlots(boolean[][] parked){
        for(int i = 0; i < parked.length; i++){
            int slots = 0;
            for(int j = 1; j <= 2; j++){
                if(!parked[i][j])
                    slots++;
            }
            displayFreeCount.displaySlots("Bike", i + 1, slots);
        }
    }

    private void getCarSlots(boolean[][] parked){
        for(int i = 0; i < parked.length; i++){
            int slots = 0;
            for(int j = 3; j < parked[0].length; j++){
                if(!parked[i][j])
                    slots++;
            }
           displayFreeCount.displaySlots("Car", i + 1, slots);
        }
    }
}
