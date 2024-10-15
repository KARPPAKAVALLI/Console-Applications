package mvvm.console.taxi;

import java.util.ArrayList;
import java.util.Arrays;

public class TaxiServiceModel {
    ArrayList<TaxiDTO> taxis;
    int totTaxi;
    int totPoints;
    boolean[][] schedule;
    char[][] position;
    TaxiServiceModel(int totTaxi, int totPoints){
        this.totTaxi = totTaxi;
        this.totPoints = totPoints;
        this.schedule = new boolean[this.totTaxi][24];
        for (boolean i[] : schedule)
            Arrays.fill(i,true);
        this.taxis = new ArrayList<>();
        for(int i = 0; i < totTaxi; i++){
            this.taxis.add(new TaxiDTO());
        }
    }

    public String allocateTaxi(BookingDTO bookingDTO){
        return allocateTaxi(bookingDTO.customerDTO.getCustomerid(), bookingDTO.pickLocation, bookingDTO.dropLocation, bookingDTO.time);
    }

    public String allocateTaxi(int custID, char pickLocation, char dropLocation, int time){
        int closerDist = this.totPoints + 1;
        TaxiDTO assignedTaxi = null;
        int pick = getLocationIndex(pickLocation), drop = getLocationIndex(dropLocation);
        for(int i = 0; i < this.totTaxi; i++){
            boolean curravail = true;
            for (int j = time; j <= time + (drop - pick); j++){
                if (!schedule[i][j]){
                    curravail = false;
                    break;
                }
            }
            if(!curravail)
                continue;
            int currDist = Math.abs(getLocationIndex(taxis.get(i).getCurrLocation()) - pick);
            if(currDist < closerDist){
                assignedTaxi = taxis.get(i);
                closerDist = currDist;
            }
            else if(currDist == closerDist){
                if(assignedTaxi != null && taxis.get(i).getEarning() < assignedTaxi.getEarning()){
                    assignedTaxi = taxis.get(i);
                }
            }
        }
        if(assignedTaxi == null){
            return "No taxi is allocated";
        }
        for (int j = time; j < time + (drop - pick); j++){
            schedule[taxis.indexOf(assignedTaxi)][j] = false;
        }
        updateEarning(assignedTaxi,pick,drop);
        updatePosition(assignedTaxi, dropLocation);
        return "Taxi-" + (taxis.indexOf(assignedTaxi) + 1);
    }

    private int getLocationIndex(char location) {
        return location - 'A';
    }

    private void updateEarning(TaxiDTO taxi, int pick, int drop){
        int totKm = (drop - pick) * 15;
        taxi.setEarning(100 + (totKm - 5) * 10);
    }

    private void updatePosition(TaxiDTO assignedTaxi, char dropLocation) {
        assignedTaxi.setCurrLocation(dropLocation);
    }
}
