public class Application {
    public static void main(String[] args) {

        final String DICTIONARY_FILE = "dictionary.txt";

        GameInput gameInput = new GameInputImpl();
        GameOutput gameOutput = new GameOutputImpl();
        Dictionary dictionaryFromFile = DictionarySingleton.getInstance(DictionarySingleton.getFromFile(DICTIONARY_FILE));
        Game game = GameSingleton.getInstance(dictionaryFromFile,gameInput,gameOutput);
        game.startGame();

//        Dictionary newDictionary = DictionarySingleton.getInstance(DictionarySingleton.getFromFile(DICTIONARY_FILE));
//        for ( int i = 0; i<10; i++) {
//            System.out.println(newDictionary.getWordFromDictionary());
//        }
    }


}
