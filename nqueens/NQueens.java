package noarchi.nqueens;

import java.util.Arrays;

public class NQueens {
    int n;
    char[][] board;
    int count = 0;
    NQueens(int n){
        this.n = n;
        this.board = new char[n][n];
        for(char[] i : board){
            Arrays.fill(i,'X');
        }
    }

    public void backtrack(int row){
        if(row == n){
            count++;
            display();
            System.out.println();
            return;
        }
        for(int col = 0; col < n; col++){
            if(isSafe(row,col)){
                board[row][col] = 'Q';
                backtrack(row + 1);
                board[row][col] = 'X';
            }
        }
    }

    private boolean isSafe(int row, int col) {
        int i = row, j = col;
        while (i >= 0){
            if(board[i][col] == 'Q'){
                return false;
            }
            i--;
        }
        i = row;
        while (j >= 0 && i >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        i = row;
        j = col;
        while (j < n && i >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public void display(){
        for (char[] i : board){
            System.out.println(Arrays.toString(i));
        }
    }
}
