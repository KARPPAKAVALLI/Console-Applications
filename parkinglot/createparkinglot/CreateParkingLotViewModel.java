package parkinglot.createparkinglot;

import parkinglot.model.ParkingLotHelper;

public class CreateParkingLotViewModel {

    CreateParkingLot createParkingLot;
    public CreateParkingLotViewModel(CreateParkingLot createParkingLot) {
        this.createParkingLot = createParkingLot;
    }

    public void addParkingLot(String parkingLotId, int no_of_floors, int no_of_slots_per_floor){
        ParkingLotHelper.getInstance().addParkingLot(parkingLotId, no_of_floors, no_of_slots_per_floor);
    }
}
