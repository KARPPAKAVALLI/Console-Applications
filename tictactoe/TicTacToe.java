package noarchi.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    char board[][]={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
    private void printBoard(){
        for (int i=0;i<3;i++){
            System.out.println(board[i][0]+" | "+board[i][1]+" | "+board[i][2]+" | ");
            System.out.println("_ + _ + _");
        }
        System.out.println();
    }
    private int getRow(int position){
        switch (position){
            case 1:
            case  2:
            case 3:
                return 0;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 2;
        }
        return -1;
    }
    private int getCol(int position){
        switch (position){
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 3;
        }
        return -1;
    }
    private void userInput(){
        System.out.println("Where do you like to play (1 to 9) ? ");
        Scanner sc=new Scanner(System.in);
        int position=sc.nextInt();
        if(check(position)){
            placeMove(position,'X');
            if(checkResult(position,'X')){
                System.out.println("User Won!!!");
                System.exit(1);
            }
        }
        else
            System.out.println("Error space taken!!!");
    }
    private void computerInput(){
        Random random=new Random();
        while (true){
            int position= random.nextInt(9);
            if(check(position)){
                System.out.println("Computer played at "+position);
                placeMove(position,'O');
                if(checkResult(position,'O')){
                    System.out.println("Computer won!!!");
                    System.exit(1);
                }
                break;
            }
        }
    }
    private int solve(int position){
        int row=getRow(position);
        int col=getCol(position);
        int xcount=0,space=0,winIndex=-1;
        for(int i=0;i<3;i++){
            if(board[i][row]=='X'){
                xcount++;
            }
            else if(board[i][row]==' '){
                winIndex=i;
                space++;
            }
        }
        if(xcount==space+1){

        }
        return -1;
    }
    private boolean check(int position){
        switch (position){
            case 1:
                return board[0][0]==' ';
            case 2:
                return board[0][1]==' ';
            case 3:
                return board[0][2]==' ';
            case 4:
                return board[1][0]==' ';
            case 5:
                return board[1][1]==' ';
            case 6:
                return board[1][2]==' ';
            case 7:
                return board[2][0]==' ';
            case 8:
                return board[2][1]==' ';
            case 9:
                return board[2][2]==' ';
            default:
                return false;
        }
    }
    private void placeMove(int position, char c){
        switch (position){
            case 1:
                board[0][0]=c;
                break;
            case 2:
                board[0][1]=c;
                break;
            case 3:
                board[0][2]=c;
                break;
            case 4:
                board[1][0]=c;
                break;
            case 5:
                board[1][1]=c;
                break;
            case 6:
                board[1][2]=c;
                break;
            case 7:
                board[2][0]=c;
                break;
            case 8:
                board[2][1]=c;
                break;
            case 9:
                board[2][2]=c;
                break;
            default:
                System.out.println("Enter only given values!!!");
        }
    }
    private boolean checkResult(int position,char c){

        int row=0,col=0;
        switch (position){
            case 1:
                row=0;
                col=0;
                break;
            case  2:
                row =0;
                col=1;
                break;
            case 3:
                row =0;
                col=2;
                break;
            case 4:
                row =1;
                col=0;
                break;
            case 5:
                row =1;
                col=1;
                break;
            case 6:
                row =1;
                col=2;
                break;
            case 7:
                row =2;
                col=0;
                break;
            case 8:
                row =2;
                col=1;
                break;
            case 9:
                row =2;
                col=2;
                break;
        }

        if(board[0][col]==c && board[1][col]==c && board[2][col]==c)
            return true;
        if(board[row][0]==c && board[row][1]==c && board[row][2]==c)
            return true;
        if(row==col || row==Math.abs(2-col) || col==Math.abs(row-2)){
            if(board[0][0]==c && board[1][1]==c && board[2][2]==c)
                return true;
            if (board[0][2]==c && board[1][1]==c && board[2][0]==c)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game1=new TicTacToe();
        int moves=0;
        game1.printBoard();
        while (moves<9){
            game1.userInput();
            game1.printBoard();
            moves++;
            game1.computerInput();
            game1.printBoard();
            moves++;
        }
    }
}
