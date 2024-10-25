package parkinglot.displayoccupiedslots;

import java.util.List;

public class DisplayOccupiedSlots {
    DisplayOccupiedSlotsViewModel displayOccupiedSlotsViewModel;
    public DisplayOccupiedSlots(){
        displayOccupiedSlotsViewModel = new DisplayOccupiedSlotsViewModel(this);
    }

    public void getVehicleType(String parkingLotId, String type){
        displayOccupiedSlotsViewModel.getOccupiedSlots(type, parkingLotId);
    }
    public void displayOccupiedSlots(String type, int floorNumber, List<Integer> slots) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < slots.size(); i++){
            sb.append(slots.get(i));
            if(i != slots.size() - 1)
                sb.append(',');
        }
        System.out.println("Occupied slots for " + type + " on Floor " + floorNumber + ": " + sb);
    }
}
