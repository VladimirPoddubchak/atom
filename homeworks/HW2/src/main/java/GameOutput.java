public interface GameOutput {
    void intro();
    void startGame(String askedWord);
    void roundGame(int round);
    void roundResult(int bulls, int cows);
    void winGame();
    void loosGame(String askedWord);
    void newGame();
    void exitGame();
    void errorGame();
}
