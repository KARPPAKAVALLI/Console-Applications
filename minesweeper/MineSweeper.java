package noarchi.minesweeper;

import java.util.Random;

public class MineSweeper {
    char board[][];
    boolean choosen[][];
    private int mines;
    MineSweeper(int mines){
        this.board=new char[8][8];
        this.choosen=new boolean[8][8];
        this.mines=mines;
        setMines();
    }
    private void setMines(){
        Random random=new Random();
        int mineCount=0;
        while (mineCount<mines){
            int row=random.nextInt(8);
            int col=random.nextInt(8);
            if(this.board[row][col]!= 'X'){
                this.board[row][col]='X';
                mineCount++;
            }
        }
        placeNumbers();
    }
    private void placeNumbers() {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                int count=0;
                if (board[i][j]=='X')
                    continue;
                for (int k=-1;k<=1;k++){
                    for (int l=-1;l<=1;l++){
                        if(k==0 && l==0)
                            continue;
                        if(i+k>=0 && i+k<8 && j+l>=0 && j+l<8 && board[i+k][j+l]=='X'){
                            count++;
                        }
                    }
                }
                if(count!=0)
                    board[i][j]=(char) (count+'0');
                else
                    board[i][j]='-';
            }
        }
    }
    public void displayBoard(){
        System.out.print("    ");  // Initial spacing for column headers
        for (int i = 0; i < 8; i++) {
            System.out.printf("%3d ", i);  // Print column headers with 3 spaces for alignment
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {
            System.out.printf("%-3d", i);  // Print row header with left alignment
            for (int j = 0; j < 8; j++) {
                if (choosen[i][j]) {
                    System.out.printf(" %2c ", board[i][j]);  // Print chosen cell with 2 spaces for alignment
                } else {
                    System.out.print("  * ");  // Print hidden cell
                }
            }
            System.out.println();
        }
    }
    public void play(int row,int col){
        if(choosen[row][col]){
            System.out.println("Already choosen!!!");
            System.out.println("Choose again");
            return;
        }
        if(this.board[row][col]=='X'){
            System.out.println("Game Over!!!");
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++)
                    choosen[i][j]=true;
            }
            displayBoard();
            System.exit(0);
        }
        else if (this.board[row][col]!='-'){
            choosen[row][col]=true;
        }
        else {
            this.check(row,col);
        }
        displayBoard();
    }

    private void check(int row, int col) {
        if(row<0 || col<0 || row>=8 || col>=8)
            return;
        if(choosen[row][col])
            return;
        if(board[row][col]!='-'){
            choosen[row][col]=true;
            return;
        }
        choosen[row][col]=true;
        check(row-1,col);
        check(row+1,col);
        check(row,col-1);
        check(row,col+1);
        check(row-1,col-1);
        check(row+1,col+1);
        check(row-1,col+1);
        check(row+1,col-1);
    }
}
