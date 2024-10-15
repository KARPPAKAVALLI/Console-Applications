package mvvm.console.taxi;

public class BookingDTO {
    CustomerDTO customerDTO;
    char pickLocation;
    char dropLocation;
    int time;

    public BookingDTO(int custid, char pickLocation, char dropLocation, int time) {
        this.pickLocation = pickLocation;
        this.dropLocation = dropLocation;
        this.time = time;
        customerDTO = new CustomerDTO(custid);
    }
}
