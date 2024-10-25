package parkinglot.parkvehicle;



public class ParkVehicle {
    ParkVehicleViewModel parkVehicleViewModel;
    public ParkVehicle(){
        this.parkVehicleViewModel = new ParkVehicleViewModel(this);
    }

    public void getParkDetails(String parkingLotId, String type, String regNumber, String colour){
        parkVehicleViewModel.assignSlot(parkingLotId, type, regNumber, colour);
    }

    public void successfulParking(String ticketId){
        System.out.println("Parked Vehicle. Ticket ID:" + ticketId);
    }

    public void unsuccessfulParking(){
        System.out.println("Parking Lot Full");
    }
}
