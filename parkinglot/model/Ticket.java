package parkinglot.model;

public class Ticket {
    String parkingLotId;
    int floorNumber;
    int slotNumber;

    String ticketId;
    public Ticket(String parkingLotId, int floorNumber, int slotNumber) {
        this.parkingLotId = parkingLotId;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.ticketId = parkingLotId+"_"+floorNumber+"_"+slotNumber;
    }

    public String getTicketId(){
        return ticketId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
