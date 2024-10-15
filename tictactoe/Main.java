package mvvm.tictactoe;

import mvvm.tictactoe.viewmodel.BoardViewModel;

public class Main {
    public static void main(String[] args) {
        BoardViewModel game = new BoardViewModel();
        while (true){
            game.handlePlayerMove();
        }
    }
}
