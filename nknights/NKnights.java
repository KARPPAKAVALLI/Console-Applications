package noarchi.nknights;

import java.util.Arrays;

public class NKnights {
    int n;
    char[][] board;
    int knights;
    NKnights(int n, int knights){
        this.n = n;
        this.knights = knights;
        board = new char[n][n];
        for(char[] i : board){
            Arrays.fill(i,'X');
        }
    }
    void backtrack(int row, int col){
        if(this.knights == 0){
            display();
            System.out.println();
            return;
        }
        if(row == n){
            return;
        }
        if(col == n){
            backtrack(row + 1, 0);
            return;
        }

        if(isSafe(row,col)){
            board[row][col] = 'K';
            this.knights--;
            backtrack(row, col + 1);
            this.knights++;
            board[row][col] = 'X';
        }
        backtrack(row, col + 1);
    }

    private boolean isSafe(int row, int col) {
        int[][] direction = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        for(int[] d : direction){
            int i = row + d[0];
            int j = col + d[1];
            if(i >= 0 && j >= 0 && i < n && j < n && board[i][j] == 'K'){
                return false;
            }
        }
        return true;
    }

    private void display() {
        for (char[] i : board){
            System.out.println(Arrays.toString(i));
        }
    }
}
