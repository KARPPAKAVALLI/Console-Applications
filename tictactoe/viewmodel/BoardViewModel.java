package mvvm.tictactoe.viewmodel;

import mvvm.tictactoe.model.BoardModel;
import mvvm.tictactoe.view.BoardView;

public class BoardViewModel {
    //
    BoardModel boardModel;
    BoardView boardView;
    public BoardViewModel(){
        boardModel = BoardModel.getBoardModelInstance();
        boardView = BoardView.getBoardViewInstance();
    }
    public void handlePlayerMove(){
        int[] position = boardView.getPlayerInput();
        int row = position[0], col = position[1];
        if(boardModel.playMove(row, col)){
            if(boardModel.isWin(row, col)){
                String result = "Congratulations, " + ((boardModel.getLetter() == 'X') ? "Player 2 (O)" : "Player 1 (X)") +" wins!";
                boardView.printResult(result);
                boardView.displayBoard(boardModel.getBoard());
                System.exit(0);
            }
            if(boardModel.isGameOver()){
                boardView.printResult("Game Over : Draw");
                boardView.displayBoard(boardModel.getBoard());
                System.exit(0);
            }
        }
        else{
            boardView.printResult("Invalid Move!!!");
        }
        boardView.displayBoard(boardModel.getBoard());
    }
}
