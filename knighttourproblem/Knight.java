package noarchi.knighttourproblem;

import java.util.Arrays;

public class Knight {
    int m;
    int n;
    int start;
    int end;
    boolean[][] visited;
    int[][] board;
    static final int[][] direction = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    Knight(int m, int n, int start, int end){
        this.m = m;
        this.n = n;
        this.start = start;
        this.end = end;
        this.visited = new boolean[m][n];
        this.board = new int[m][n];
        this.backtrack(start,end,1);
    }
    void backtrack(int row, int col, int steps){
        if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col]){
            return;
        }
        board[row][col] = steps;
        visited[row][col] = true;
        if(steps == m*n){
            return;
        }
        for(int[] d : direction){
            backtrack(row + d[0], col + d[1], steps + 1);
        }
    }

    void display(){
        for(int[] i : board){
            System.out.println(Arrays.toString(i));
        }
    }
}
