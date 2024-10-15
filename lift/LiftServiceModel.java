package mvvm.console.lift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LiftServiceModel {
    public static LiftServiceModel liftServiceModel;
    Lift lift1, lift2, lift3, lift4, lift5;
    List<Lift> lifts;
    private LiftServiceModel(){
        //create 5 lifts
        lift1 = new Lift();
        lift2 = new Lift();
        lift3 = new Lift();
        lift4 = new Lift();
        lift5 = new Lift();
        lifts = new ArrayList<>(Arrays.asList(lift1, lift2, lift3, lift4, lift5));
    }
    public static LiftServiceModel getInstance(){
        if(liftServiceModel == null)
            liftServiceModel = new LiftServiceModel();
        return liftServiceModel;
    }
    public void assignLift(int userCurrentFloor, int userToFloor){
        int minDist = 11;
        Lift assignedLift = null;
        char direction = userToFloor > userCurrentFloor ? 'U' : 'D';
        if(userCurrentFloor <= 5 && userToFloor <= 5){
            //options : lift 1, 2, 5
            Lift[] availLifts = {lift1, lift2};
            for(int i = 0; i < 2; i++){
                if(availLifts[i].isMaintanence()){
                    continue;
                }
                int dist = Math.abs(availLifts[i].getCurrentPosition() - userCurrentFloor);
                if(dist < minDist){
                    minDist = dist;
                    assignedLift = availLifts[i];
                }
                else if(dist == minDist){
                    if(assignedLift != null && assignedLift.getDirection() != direction && availLifts[i].getDirection() == direction){
                        assignedLift = availLifts[i];
                    }
                }
            }
            if (assignedLift == null){
                if(!lift5.isMaintanence()){
                    //assign lift 5
                    assignedLift = lift5;
                }
            }
        } else if ((userCurrentFloor >= 6 || userCurrentFloor == 0) && (userToFloor >= 6 || userToFloor == 0)) {
            //options : lift 3, 4, 5
            Lift[] availLifts = {lift3, lift4};
            for(int i = 0; i < 2; i++){
                if(availLifts[i].isMaintanence()){
                    continue;
                }
                int dist = Math.abs(availLifts[i].getCurrentPosition() - userCurrentFloor);
                if(dist < minDist){
                    minDist = dist;
                    assignedLift = availLifts[i];
                }
                else if(dist == minDist){
                    if(assignedLift != null && assignedLift.getDirection() != direction && availLifts[i].getDirection() == direction){
                        assignedLift = availLifts[i];
                    }
                }
            }
            if (assignedLift == null){
                if(!lift5.isMaintanence()){
                    //assign lift 5
                    assignedLift = lift5;
                }
            }
        }
        else {
            //option : lift 5
            if(!lift5.isMaintanence()){
                //assign lift 5
                assignedLift = lift5;
            }
        }
        if(assignedLift == null){
            return;
        }
        assignedLift.setCurrentPosition(userToFloor);
        assignedLift.setDirection(direction);
        if(userToFloor == 5 && assignedLift != lift5){
            assignedLift.setDirection('D');
        }
        if(userToFloor == 10){
            assignedLift.setDirection('D');
        }
    }

}
