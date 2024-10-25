package parkinglot.parkvehicle;

import parkinglot.model.*;

public class ParkVehicleViewModel {
    ParkVehicle parkVehicle;
    ParkVehicleViewModel(ParkVehicle parkVehicle){
        this.parkVehicle = parkVehicle;
    }

    public void assignSlot(String parkingLotId, String vehicleType, String registerNumber, String colour){
        VehicleType type = VehicleType.valueOf(vehicleType);
        Vehicle vehicle = new Vehicle(type, registerNumber, colour);
        ParkingLot parkingLot = ParkingLotHelper.getInstance().getParkingLot(parkingLotId);
        Ticket ticket = null;
        if(type.equals(VehicleType.TRUCK)){
            ticket = truckSlot(parkingLot);
        } else if (type.equals(VehicleType.BIKE)) {
            ticket = bikeSlot(parkingLot);
        } else if (type.equals(VehicleType.CAR)) {
            ticket = carSlot(parkingLot);
        }
        if(ticket != null){
            parkingLot.addNewTicket(ticket, vehicle);
            parkVehicle.successfulParking(ticket.getTicketId());
        }
        else {
            parkVehicle.unsuccessfulParking();
        }
    }

    private Ticket truckSlot(ParkingLot parkingLot){
        for(int i = 0; i < parkingLot.getNumberOfFloors(); i++){
            if(!parkingLot.getSlotsTaken()[i][0]){
                parkingLot.getSlotsTaken()[i][0] = true;
                return new Ticket(parkingLot.getId(), i + 1, 1);
            }
        }
        return null;
    }

    private Ticket bikeSlot(ParkingLot parkingLot){
        for(int i = 0; i < parkingLot.getNumberOfFloors(); i++){
            for(int j = 1; j <= 2; j++){
                if(!parkingLot.getSlotsTaken()[i][j]){
                    parkingLot.getSlotsTaken()[i][j] = true;
                    return new Ticket(parkingLot.getId(), i + 1, j + 1);
                }
            }
        }
        return null;
    }

    private Ticket carSlot(ParkingLot parkingLot){
        for(int i = 0; i < parkingLot.getNumberOfFloors(); i++){
            for(int j = 3; j < parkingLot.getSlotsPerFloor(); j++){
                if(!parkingLot.getSlotsTaken()[i][j]){
                    parkingLot.getSlotsTaken()[i][j] = true;
                    return new Ticket(parkingLot.getId(), i + 1, j + 1);
                }
            }
        }
        return null;
    }
}
