package parkinglot.unparkvehicle;



public class UnParkVehicle {
   UnParkVehicleViewModel unParkVehicleViewModel;

    public UnParkVehicle(){
        unParkVehicleViewModel = new UnParkVehicleViewModel(this);
    }

    public void getTicketId(String parkingLotId, String ticketId){
        unParkVehicleViewModel.unPark(ticketId, parkingLotId);
    }

    public void unParkSuccess(String regNumber, String colour){
        System.out.println("Unparked vehicle with Registration Number: " + regNumber + " and Color: " + colour);
    }

    public void unParkUnSuccess(){
        System.out.println("Invalid Ticket");
    }
}
