import java.util.Set;

public class WordChecker {

    private final Set<String> dictionary;

    public WordChecker(Set<String> dictionary) {
        if (dictionary==null || dictionary.isEmpty()) {
            throw new IllegalArgumentException("empty dictionary!");
        }
        this.dictionary = dictionary;
    }

    public String findValidWord(String word) {
        String result = recursiveFindValidWord(word);
        if (result != null) {
            return word;
        }
        return null;
    }

    //recursively finds all the words that can come out of the given word with removing one letter a time
    //returns empty string if the given word can be split to valid one-letter word or null if it cant
    private String recursiveFindValidWord(String proposedWord) {
        if (!dictionary.contains(proposedWord) && proposedWord.length() != 1) {
            return null;
        }

        if (proposedWord.length() == 1) {
            if (proposedWord.equals("a") || proposedWord.equals("i")) {
                return "";
            }
            else {
                return null;
            }
        }

        for (int i = 0; i < proposedWord.length(); i++) {
            String nextProposedWord = new StringBuilder(proposedWord)
                    .deleteCharAt(i)
                    .toString();
            String finalStack = recursiveFindValidWord(nextProposedWord);
            if (finalStack != null) {
                return finalStack;
            }
        }

        return null;
    }
}