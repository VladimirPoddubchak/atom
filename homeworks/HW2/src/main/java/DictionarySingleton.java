import java.util.Random;
import java.util.Set;

public class DictionarySingleton implements Dictionary {
    public final Set<String> dictionary;

    public static DictionarySingleton instance;

    private DictionarySingleton(Set<String> input){
        this.dictionary = input;
    }

    public static DictionarySingleton getInstance(Set<String> input){

        if (instance==null){
            instance = new DictionarySingleton(input);
        }
        return instance;
    }

    @Override
    public String getWordFromDictionary() {
        Random random = new Random();
        return (String) dictionary.toArray()[random.nextInt(dictionary.size())];
    }


}
