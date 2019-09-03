public class GameSingleton implements Game{
    private final int MAX_ROUNDS = 10;
    private static int currentRound;
    private static String askedWord;
    private static char[] askedWordToChars;
    private static String inputWord;
    private static char[] inputToChars;
    private int bulls;
    private int cows;
    private  Dictionary dictionary;
    private GameInput gameInput;
    private GameOutput gameOutput;


    public static GameSingleton instance;
    private GameSingleton(Dictionary input,GameInput gameInput, GameOutput gameOutput){
        this.dictionary = input;
        this.gameInput = gameInput;
        this.gameOutput = gameOutput;

    }
    public static GameSingleton getInstance(Dictionary input,GameInput gameInput, GameOutput gameOutput){
        if (instance==null){
            instance = new GameSingleton(input,gameInput,gameOutput);
        }
        return instance;
    }

    @Override
    public void startGame() {
        gameOutput.intro();
        wantToPlay();
    }

    @Override
    public void newGame() {
        askedWord = dictionary.getWordFromDictionary();
        askedWordToChars=askedWord.toCharArray();
        currentRound = 1;
        gameOutput.startGame(askedWord);
        nextRound();
    }

    @Override
    public void wantToPlay() {
        gameOutput.newGame();
        if (gameInput.inputYN()) {
            newGame();
        }else {
            exitGame();
        }
    }

    @Override
    public boolean checkWord(String input) {
        System.out.println("Asked word = " + askedWord + "; Input = "+input +"; Result = "+(input.equals(askedWord)));
        return input.toLowerCase().equals(askedWord);
    }

    @Override
    public int checkBulls(String input) {
        bulls = 0;
        inputToChars =input.toCharArray();

        for (int index = 0; index<askedWordToChars.length;index++) {
            if (askedWordToChars[index]==inputToChars[index]){
                bulls++;
            }
        }
        System.out.println("Bulls = "+ bulls);
        return bulls;
    }

    @Override
    public int checkCows(String input) {
        cows = 0;
        inputToChars =input.toCharArray();
        for (int index = 0; index<askedWordToChars.length;index++) {
            if (inputToChars[index]!=askedWordToChars[index]
                    &askedWord.contains(String.valueOf(inputToChars[index]))){
                cows++;
            }
        }
        System.out.println("Cows = " + cows);
        return cows;
    }


    @Override
    public void nextRound() {
        while (currentRound<=MAX_ROUNDS){
            gameOutput.roundGame(currentRound);
            inputWord = gameInput.inputWord();
            while (inputWord.length()!=askedWord.length()){
                gameOutput.errorGame();
                inputWord = gameInput.inputWord();
            }

            if (checkWord(inputWord)){
                winGame();
            }
            gameOutput.roundResult(checkBulls(inputWord),checkCows(inputWord));
            currentRound++;
        }
        loosGame();
    }

    @Override
    public void winGame() {
        gameOutput.winGame();
        wantToPlay();
    }

    @Override
    public void loosGame() {
        gameOutput.loosGame(askedWord);
        wantToPlay();
    }

    @Override
    public void exitGame() {
        gameOutput.exitGame();
        if (gameInput.inputYN()){
            System.exit(1);
        }else {
            wantToPlay();
        }

    }
}
