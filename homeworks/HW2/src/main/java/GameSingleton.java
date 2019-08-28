public class GameSingleton implements Game{
    private final int MAX_ROUNDS = 10;
    private static int currentRound;
    private static String askedWord;
    private  Dictionary dictionary;


    public static GameSingleton instance;
    private GameSingleton(Dictionary input){
        this.dictionary = input;

    }
    public static GameSingleton getInstance(Dictionary input){
        if (instance==null){
            instance = new GameSingleton(input);
        }
        return instance;
    }

    @Override
    public void start() {
        currentRound = 0;
        askedWord = dictionary.getWordFromDictionary();
//        System.out.println("Game started. Asked word = " + askedWord);
    }

//    @Override
//    public boolean checkWord(String input) {
//        System.out.println("Asked word = " + askedWord + "; Input = "+input +"; Result = "+(input==askedWord));
//        return input==askedWord;
//    }

    @Override
    public void nextRound() {

    }

    @Override
    public void winGame() {

    }

    @Override
    public void loosGame() {

    }

    @Override
    public void exitGame() {

    }
}
