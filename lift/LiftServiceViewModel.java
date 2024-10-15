package mvvm.console.lift;

public class LiftServiceViewModel {
    LiftServiceModel liftServiceModel;
    LiftServiceView liftServiceView;
    LiftServiceViewModel(){
        liftServiceModel = LiftServiceModel.getInstance();
        liftServiceView = LiftServiceView.getInstance();
    }

    public void handleUserInput(){
        liftServiceView.displayLiftCurrPositions(new int[]{liftServiceModel.lift1.getCurrentPosition(),
                liftServiceModel.lift2.getCurrentPosition(),
                liftServiceModel.lift3.getCurrentPosition(),
                liftServiceModel.lift4.getCurrentPosition(),
                liftServiceModel.lift5.getCurrentPosition()});
        int curr = liftServiceView.getUserCurrFloor();
        int dest = liftServiceView.getUserToFloor();
        liftServiceModel.assignLift(curr,dest);
        liftServiceView.displayLiftCurrPositions(new int[]{liftServiceModel.lift1.getCurrentPosition(),
                liftServiceModel.lift2.getCurrentPosition(),
                liftServiceModel.lift3.getCurrentPosition(),
                liftServiceModel.lift4.getCurrentPosition(),
                liftServiceModel.lift5.getCurrentPosition()});
    }
}
