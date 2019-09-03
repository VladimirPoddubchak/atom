public class GameOutputImpl implements GameOutput {
    @Override
    public void intro() {
        System.out.println("BULLS AND COWS GAME");
    }

    @Override
    public void startGame(String askedWord) {
        System.out.println("Asked word length is "+ askedWord.length());
    }

    @Override
    public void roundGame(int round) {
        System.out.println("Round " +round+ ".");
    }

    @Override
    public void roundResult(int bulls, int cows) {
        System.out.println("Bulls = "+bulls+ "  Cows = "+cows);
    }

    @Override
    public void winGame() {
        System.out.println("You win!!!");
    }

    @Override
    public void loosGame(String askedWord) {
        System.out.println("You loose. Asked word is: "+ askedWord.toUpperCase());
    }

    @Override
    public void newGame() {
        System.out.println("Do you want to play? Y/N");
    }

    @Override
    public void exitGame() {
        System.out.print("Exit game? Y/N:");
    }

    @Override
    public void errorGame() {
        System.out.println("Error. Wrong word length. Try again.");
    }
}
