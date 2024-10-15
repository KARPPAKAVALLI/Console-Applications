package mvvm.tictactoe.view;

import java.util.Scanner;

public class BoardView {
    private static BoardView boardView;
    private BoardView(){

    }

    public static BoardView getBoardViewInstance() {
        if(boardView == null)
            boardView = new BoardView();
        return boardView;
    }

    public void displayBoard(char[][] board){
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[] getPlayerInput(){
        Scanner sc =new Scanner(System.in);
        System.out.println("enter your move (row and column):");
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new int[]{row, col};
    }
    public void printResult(String result){
        System.out.println(result);
    }
}
