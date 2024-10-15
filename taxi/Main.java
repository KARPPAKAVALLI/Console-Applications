package mvvm.console.taxi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaxiServiceViewModel obj = new TaxiServiceViewModel();
        int choice = 1;
        while (true){
            System.out.println("Enter Choice: ");
            choice = sc.nextInt();
            if(choice != 1)
                break;
            obj.handleInput();
        }
    }
}
