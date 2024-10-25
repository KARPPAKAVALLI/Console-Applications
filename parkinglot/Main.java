package parkinglot;

import parkinglot.createparkinglot.CreateParkingLot;
import parkinglot.displayfreecount.DisplayFreeCount;
import parkinglot.displayfreeslots.DisplayFreeSlots;
import parkinglot.displayoccupiedslots.DisplayOccupiedSlots;
import parkinglot.parkvehicle.ParkVehicle;
import parkinglot.unparkvehicle.UnParkVehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CreateParkingLot createParkingLot = new CreateParkingLot();
        createParkingLot.getParkingLotDetails();

        System.out.println("PARKING LOT ID");
        Scanner sc = new Scanner(System.in);
        String parkingLotId = sc.next();
        sc.nextLine();
        String[] query = sc.nextLine().split(" ");
        while (query.length != 1){
            if(query[0].equals("park_vehicle")){
                new ParkVehicle().getParkDetails(parkingLotId, query[1], query[2], query[3]);
            } else if (query[0].equals("unpark_vehicle")) {
                new UnParkVehicle().getTicketId(parkingLotId, query[1]);
            } else if (query[0].equals("display")) {
                if(query[1].equals("free_count")){
                    new DisplayFreeCount().getVehicleType(parkingLotId, query[2]);
                } else if (query[1].equals("free_slots")) {
                    new DisplayFreeSlots().getVehicleType(parkingLotId, query[2]);
                } else if (query[1].equals("occupied_slots")) {
                    new DisplayOccupiedSlots().getVehicleType(parkingLotId, query[2]);
                }
            }
            query = sc.nextLine().split(" ");
        }
    }
}
