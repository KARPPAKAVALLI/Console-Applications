package parkinglot.displayfreecount;


public class DisplayFreeCount {
    DisplayFreeCountViewModel displayFreeCountViewModel;

    public DisplayFreeCount(){
        this.displayFreeCountViewModel = new DisplayFreeCountViewModel(this);
    }

    public void getVehicleType(String parkingLotId, String type){
        displayFreeCountViewModel.getFreeSlots(type, parkingLotId);
    }

    public void displaySlots(String vehicleType, int floorNumber, int slots){
        System.out.println("No. of free slots for " + vehicleType + " on Floor " + floorNumber + ": " + slots);
    }
}
