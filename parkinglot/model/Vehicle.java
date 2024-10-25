package parkinglot.model;

public class Vehicle {
    VehicleType type;
    String regNumber;
    String colour;

    public Vehicle(VehicleType type, String regNumber, String colour) {
        this.type = type;
        this.regNumber = regNumber;
        this.colour = colour;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getColour() {
        return colour;
    }
}
