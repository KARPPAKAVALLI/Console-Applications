package mvvm.console.taxi;

public class CustomerDTO {
    private int customerid;
    CustomerDTO(int customerid){
        this.customerid = customerid;
    }

    public int getCustomerid() {
        return customerid;
    }
}
