package mvvm.console.lift;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LiftServiceViewModel obj = new LiftServiceViewModel();
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("ENTER CHOICE:");
            choice = sc.nextInt();
            if(choice != 1)
                break;
            obj.handleUserInput();
        }
    }
}
