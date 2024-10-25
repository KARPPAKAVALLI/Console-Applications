package parkinglot.unparkvehicle;

import parkinglot.model.ParkingLot;
import parkinglot.model.ParkingLotHelper;
import parkinglot.model.Ticket;
import parkinglot.model.Vehicle;

import java.util.Map;

public class UnParkVehicleViewModel {
    UnParkVehicle unParkVehicle;
    UnParkVehicleViewModel(UnParkVehicle unParkVehicle){
        this.unParkVehicle = unParkVehicle;
    }
    public void unPark(String ticketId, String parkingLotId){
        ParkingLot parkingLot = ParkingLotHelper.getInstance().getParkingLot(parkingLotId);
        for (Map.Entry < Ticket, Vehicle> parked: parkingLot.getTickets().entrySet()) {
            if(parked.getKey().getTicketId().equals(ticketId)){
                Ticket ticket = parked.getKey();
                parkingLot.getSlotsTaken()[ticket.getFloorNumber() - 1][ticket.getSlotNumber() - 1] = false;
                parkingLot.getTickets().remove(ticket);
                String regNumber = parked.getValue().getRegNumber(), colour = parked.getValue().getColour();
                unParkVehicle.unParkSuccess(regNumber, colour);
                return;
            }
        }
        unParkVehicle.unParkUnSuccess();
    }
}
