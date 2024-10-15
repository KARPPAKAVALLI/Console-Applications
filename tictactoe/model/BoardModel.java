package mvvm.tictactoe.model;


public class BoardModel {
        char [][] board;
        char letter;
        private static BoardModel boardModel;
        private BoardModel(){
                board = new char[][]{{'_','_','_'},{'_','_','_'},{'_','_','_'}};
                letter = 'X';
        }

        public char[][] getBoard() {
                return board;
        }

        public char getLetter() {
                return letter;
        }

        public static BoardModel getBoardModelInstance() {
                if(boardModel == null)
                        boardModel = new BoardModel();
                return boardModel;
        }

        public boolean playMove(int row, int col){
                if(row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != '_'){
                        return false;
                }
                else {
                        board[row][col] = letter;
                        letter = letter == 'X' ? 'O' : 'X';
                }
                return true;
        }
        public boolean isWin(int row, int col){
                char currLetter = board[row][col];
                boolean rowWin = true, colWin = true, diagWin = false;
                for(int i = 0; i < 3; i++){
                        if(board[row][i] != currLetter){ //row check
                                rowWin = false;
                        }
                        if(board[i][col] != currLetter){ //col check
                                colWin = false;
                        }
                }
                //diagonal check
                if(row == col || row == 2 - col || col == row -2){
                        if((board[0][0] == currLetter && board[1][1] == currLetter && board[2][2] == currLetter) ||
                        board[0][2] == currLetter && board[1][1] == currLetter && board[2][0] == currLetter){
                                diagWin = true;
                        }
                }
                return rowWin || colWin || diagWin;
        }
        public boolean isGameOver(){
                for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                                if(board[i][j] == '_') //empty cell found
                                        return false; //so, game not over
                        }
                }
                return true;
        }


}
