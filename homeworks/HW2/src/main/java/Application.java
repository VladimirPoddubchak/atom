import java.util.Set;

public class Application {
    public static void main(String[] args) {
//        Word askedWord = new Word("12345678".toCharArray());
//        System.out.println("testword" + askedWord.checkBulls("testword".toCharArray()));
//        System.out.println("test1111" + askedWord.checkBulls("test1111".toCharArray()));
//        System.out.println("tes55555" + askedWord.checkBulls("tes55555".toCharArray()));
//        System.out.println("88888888" + askedWord.checkBulls("88888888".toCharArray()));
//
//        System.out.println("1111111e cows = " + askedWord.checkCows("1111111e".toCharArray()));
//        System.out.println("st2222tt cows = " + askedWord.checkCows("st2222tt".toCharArray()));
//        System.out.println("ord33333 cows = " + askedWord.checkCows("ord33333".toCharArray()));
//        System.out.println("4444test cows = " + askedWord.checkCows("4444test".toCharArray()));
//

        Dictionary dictionary = DictionarySingleton.getInstance(Set.of("one","two","three"));
        Game game = GameSingleton.getInstance(dictionary);

        for (int i =1; i<=100; i++){
            System.out.print(i + "   ");
            game.start();
            game.checkWord("two");
        }



    }




}
