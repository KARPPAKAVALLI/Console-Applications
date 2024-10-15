package mvvm.console.lift;

import java.util.Scanner;

public class LiftServiceView {
    public static LiftServiceView liftServiceView;
    private LiftServiceView(){

    }
    public static LiftServiceView getInstance(){
        if(liftServiceView == null)
            liftServiceView = new LiftServiceView();
        return liftServiceView;
    }
    public int getUserCurrFloor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Your current floor:");
        return sc.nextInt();
    }
    public int getUserToFloor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Your destination floor:");
        return sc.nextInt();
    }
    public void displayLiftCurrPositions(int[] positions){
        System.out.println("L1 L2 L3 L4 L5");
        for (int i:positions) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
