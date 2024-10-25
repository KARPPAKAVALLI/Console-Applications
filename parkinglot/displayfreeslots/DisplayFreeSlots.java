package parkinglot.displayfreeslots;

import java.util.List;

public class DisplayFreeSlots {

    DisplayFreeSlotsViewModel displayFreeSlotsViewModel;
    public DisplayFreeSlots(){
        displayFreeSlotsViewModel = new DisplayFreeSlotsViewModel(this);
    }

    public void getVehicleType(String parkingLotId, String type){
        displayFreeSlotsViewModel.getFreeSlots(type, parkingLotId);
    }

    public void displayFreeSlots(String type, int floorNumber, List<Integer> slots){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < slots.size(); i++){
            sb.append(slots.get(i));
            if(i != slots.size() - 1)
                sb.append(',');
        }
        System.out.println("Free slots for " + type + " on Floor " + floorNumber + ": " + sb);
    }
}
