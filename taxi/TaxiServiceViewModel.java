package mvvm.console.taxi;

public class TaxiServiceViewModel {
    TaxiServiceView taxiServiceView;
    TaxiServiceModel taxiServiceModel;

    TaxiServiceViewModel(){
        taxiServiceView = new TaxiServiceView();
        this.taxiServiceModel = new TaxiServiceModel(taxiServiceView.getNumOfTaxis(), taxiServiceView.getNumOfPts());
    }
    public void handleInput(){
        BookingDTO bookingDTO = taxiServiceView.getBookingDetails();
        String outputString  = taxiServiceModel.allocateTaxi(bookingDTO);
        taxiServiceView.displayOutPut(outputString);
    }
}
