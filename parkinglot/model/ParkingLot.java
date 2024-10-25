package parkinglot.model;

import java.util.HashMap;

public class ParkingLot {
    String id;
    int numberOfFloors;
    int slotsPerFloor;
    HashMap<Ticket, Vehicle> tickets;
    boolean[][] slotsTaken;

    public ParkingLot(String id, int numberOfFloors, int slotsPerFloor) {
        this.id = id;
        this.numberOfFloors = numberOfFloors;
        this.slotsPerFloor = slotsPerFloor;
        tickets = new HashMap<>();
        slotsTaken = new boolean[numberOfFloors][slotsPerFloor];
    }

    public void addNewTicket(Ticket ticket, Vehicle vehicle){
        tickets.put(ticket, vehicle);
    }

    public boolean[][] getSlotsTaken() {
        return slotsTaken;
    }

    public String getId() {
        return id;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getSlotsPerFloor() {
        return slotsPerFloor;
    }

    public HashMap<Ticket, Vehicle> getTickets() {
        return tickets;
    }
}
