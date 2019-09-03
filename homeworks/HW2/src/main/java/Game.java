public interface Game {
    void startGame();
    void newGame();
    void wantToPlay();
    boolean checkWord(String input);
    int checkBulls(String input);
    int checkCows(String input);
    void nextRound();
    void winGame();
    void loosGame();

    void exitGame();
}
