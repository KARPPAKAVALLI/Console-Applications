package mvvm.console.taxi;

import java.util.Scanner;

public class TaxiServiceView {
    Scanner sc;
    TaxiServiceView(){
        sc = new Scanner(System.in);
    }
    public int getNumOfTaxis(){
        System.out.println("Enter total number of taxis:");
        return sc.nextInt();
    }
    public int getNumOfPts(){
        System.out.println("Enter total number of points:");
        return sc.nextInt();
    }
    public BookingDTO getBookingDetails(){
        System.out.println("Customer ID:");
        int custId = sc.nextInt();
        System.out.println("Pickup Point:");
        char pick = sc.next().charAt(0);
        System.out.println("Drop Point:");
        char drop = sc.next().charAt(0);
        System.out.println("Pickup Time:");
        int time = sc.nextInt();
        return new BookingDTO(custId, pick, drop, time);
    }

    public void displayOutPut(String outputstring){
        if(outputstring.equals("No taxi is allocated")){
            System.out.println(outputstring);
        }
        else{
            System.out.println("Taxi can be allocated.");
            System.out.println(outputstring + " is allocated.");
        }
    }

//    public void displayBookingDetails(BookingDTO bookingDTO){
//        System.out.println("BookingID   CustomerID    From    To      Pickuptime      DropTime     Amount");
//
//    }
}
