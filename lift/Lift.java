package mvvm.console.lift;

public class Lift {
    private int currentPosition;
    private boolean isMaintanence;
    private char direction; //Can also use Enum

    public Lift(){
        this.currentPosition = 0;
        this.direction = 'U';
        this.isMaintanence = false;
    }

    public void setMaintanence(){
        isMaintanence = !isMaintanence;
        if(isMaintanence)
            currentPosition = -1;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setMaintanence(boolean maintanence) {
        isMaintanence = maintanence;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public boolean isMaintanence() {
        return isMaintanence;
    }

    public char getDirection() {
        return direction;
    }
}
