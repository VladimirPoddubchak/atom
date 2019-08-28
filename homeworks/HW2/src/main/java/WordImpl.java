public class WordImpl implements Word{
    public final char[] word;

    public WordImpl(char[] word) {
        this.word = word;
    }


    int checkBulls(char[] input){
        int bulls = 0;
        for (int index = 0; index<word.length;index++) {
            if (word[index]==input[index]){
                bulls++;
            }
        }
        return bulls;
    };

    int checkCows(char[] input){
        int cows = 0;
        for (int index = 0; index<word.length;index++) {
            if (input[index]!=word[index]
                    &word.toString().contains(String.valueOf(input[index]))){
                cows++;
            }
        }

        return cows;
    };

    @Override
    public boolean checkWord(String askedWord,String input) {
        System.out.println("Asked word = " + askedWord + "; Input = "+input +"; Result = "+(input==askedWord));
        return askedWord==input;
    }

    @Override
    public int checkBulls(String input) {
        return 0;
    }

    @Override
    public int checkCows(String input) {
        return 0;
    }


}
