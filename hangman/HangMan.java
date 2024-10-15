package noarchi.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HangMan{
    Map<String,String> wordFiles=new HashMap<>(Map.of("Animals","src/noarchi.hangman/Animals.txt","Colours","src/noarchi.hangman/Colours.txt"));
    List <String> keys=new ArrayList<>(wordFiles.keySet());
    List<String> words;
    Set<Character> playerGuesses=new HashSet<>();
    Set<Character> availChars=new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
    String toGuess;
    int wrongCount;

    private void setWords()throws FileNotFoundException{
        Random random=new Random();
        String key=keys.get(random.nextInt(keys.size()));
        String fileSrc=wordFiles.get(key);
        Scanner sc=new Scanner(new File(fileSrc));
        System.out.println("Your clue: "+key);
        words=new ArrayList<>();
        while (sc.hasNext()){
            words.add(sc.nextLine());
        }
    }
    private void displayHuman(int wc){
        System.out.println();
        System.out.println(" -----------");
        System.out.println(" |          |");
        if(wc>=1)
            System.out.println(" O");
        if (wc>=2)
            System.out.print("\\");
        if (wc>=3)
            System.out.println(" /");
        if (wc>=4)
            System.out.println(" | ");
        if (wc>=5)
            System.out.print("/");
        if (wc>=6)
            System.out.println(" \\");
    }
    private String getWord(){
        Random random=new Random();
        return words.get(random.nextInt(words.size()));
    }
    private void playerGuess(){
        System.out.println("Choose a Character: ");
        Scanner sc=new Scanner(System.in);
        char currGuess=Character.toLowerCase(sc.next().charAt(0));
        playerGuesses.add(currGuess);
    }
    private boolean check(){
        boolean f=true;
        boolean wrong=true;
        for(int i=0;i<toGuess.length();i++){
            if(playerGuesses.contains(toGuess.charAt(i))){
                System.out.print(toGuess.charAt(i)+" ");
                wrong=false;
            }
            else {
                f=false;
                System.out.print("_ ");
            }
        }
        if (wrong){
            this.wrongCount++;
            displayHuman(wrongCount);
        }
        System.out.println();
        return f;
    }

    private void displayChoiceChars(){
        for(char c='a';c<='z';c++){
            if(!playerGuesses.contains(c))
                System.out.print(c+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws FileNotFoundException{
        HangMan game1=new HangMan();
        game1.setWords();
        game1.toGuess= game1.getWord().toLowerCase();
        boolean won=false;
        while (game1.wrongCount<6){
            game1.displayChoiceChars();
            game1.playerGuess();
            if(game1.check()) {
                System.out.println("You won!!!");
                won = true;
                break;
            }
            System.out.println("Guesses left: "+(6-game1.wrongCount));
        }
        if(!won)
        System.out.println(game1.toGuess);
    }
}
