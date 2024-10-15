package mvvm.console.taxi;

public class TaxiDTO {
    private int earning;
    private char currLocation;
    private boolean available;

    TaxiDTO(){
        this.earning = 0;
        this.currLocation = 'A';
        this.available = true;
    }

    public int getEarning() {
        return earning;
    }

    public char getCurrLocation() {
        return currLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }

    public void setCurrLocation(char currLocation) {
        this.currLocation = currLocation;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
