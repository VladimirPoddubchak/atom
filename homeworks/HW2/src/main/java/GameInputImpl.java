import java.util.Scanner;

public class GameInputImpl implements GameInput {

    private static String word;
    private static String answer;
    private static Scanner in = new Scanner(System.in);



    @Override
    public String inputWord() {
        word = in.nextLine();
        while (!checkInputWord(word)){
            System.out.println("Invalid input. Try again.");
            word = in.nextLine();
        }
        return word;
    }

    @Override
    public boolean inputYN() {
        answer = in.nextLine();
        while (!checkInputYN(answer)){
            System.out.print("Invalid input. Try again. Y/N:");
            answer = in.nextLine();
        }
        return answer.toLowerCase().matches("y");
    }

    @Override
    public boolean checkInputWord(String inputWord) {
        return inputWord.toLowerCase().matches("[a-z]+");

    }

    @Override
    public boolean checkInputYN(String answer) {
        return answer.toLowerCase().matches("[yn]");
    }
}
