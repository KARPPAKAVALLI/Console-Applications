package noarchi.minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MineSweeper mineSweeper=new MineSweeper(10);
        mineSweeper.displayBoard();
        while (true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter row 0 to 7");
            int row=sc.nextInt();
            System.out.println("Enter col 0 to 7");
            int col=sc.nextInt();
            mineSweeper.play(row,col);
        }
    }
}
