package noarchi.nknights;

public class Main {
    public static void main(String[] args) {
        NKnights knights = new NKnights(3,4);
        knights.backtrack(0,0);
    }
}
