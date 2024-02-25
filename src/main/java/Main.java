import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static final String DICT_URL = "https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt";
    private static final int NUM_OF_LETTERS = 9;
    public static void main(String[] args) {

        Set<String> dictionary = new HashSet<>();
        try {
            dictionary = UrlToHashSet.readUrlToHashSet(DICT_URL);
        } catch (IOException e) {
            System.out.println("Error during the reading of the dictionary: " + e.getMessage());
        }
        List <String> outputWords = new ArrayList<>();
        WordChecker wordChecker = new WordChecker(dictionary);

        for (String element : dictionary) {
            if (element.length()==NUM_OF_LETTERS){
                String result = wordChecker.findValidWord(element);
                if (result!= null){
                    outputWords.add(result);
                }
            }
        }
        System.out.println(outputWords);
    }
}