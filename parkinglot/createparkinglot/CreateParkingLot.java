package parkinglot.createparkinglot;

import java.util.Scanner;

public class CreateParkingLot {

    Scanner sc;
    CreateParkingLotViewModel createParkingLotViewModel;
    public CreateParkingLot(){
        sc = new Scanner(System.in);
        this.createParkingLotViewModel = new CreateParkingLotViewModel(this);
    }
    //create_parking_lot <parking_lot_id> <no_of_floors>
    //<no_of_slots_per_floor>

    public void getParkingLotDetails(){
        String parkingLotId = sc.next();
        int no_of_floors = sc.nextInt();
        int no_of_slots_per_floor = sc.nextInt();
        createParkingLotViewModel.addParkingLot(parkingLotId, no_of_floors, no_of_slots_per_floor);
    }
}
