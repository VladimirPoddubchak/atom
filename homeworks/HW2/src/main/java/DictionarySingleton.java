import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
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

    public static Set<String> getFromFile(String path){
        Set<String> dictionary = new HashSet<>();
        Path dictionaryFile = Paths.get(path);

        try {
            Files.lines(dictionaryFile).forEach(dictionary::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }


}
