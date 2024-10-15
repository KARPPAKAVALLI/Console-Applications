package noarchi.nqueens;

public class Main {
    public static void main(String[] args) {
        NQueens queens = new NQueens(8);
        queens.backtrack(0);
        System.out.println(queens.count);
    }
}
