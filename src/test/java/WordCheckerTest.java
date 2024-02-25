
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class WordCheckerTest {

    @Test
    public void testValidWord() {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("hit");
        dictionary.add("hi");

        WordChecker wordChecker = new WordChecker(dictionary);

        assertEquals("hi", wordChecker.findValidWord("hi"));
        assertEquals("hit", wordChecker.findValidWord("hit"));
    }

    @Test
    public void testInvalidWord() {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("hello");
        dictionary.add("hi");

        WordChecker wordChecker = new WordChecker(dictionary);

        Assertions.assertNull(wordChecker.findValidWord("word"));
        Assertions.assertNull(wordChecker.findValidWord("test"));
    }

    @Test
    public void testEmptyDictionary() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new WordChecker(new HashSet<>()));
    }

    @Test
    public void testRecursiveFindValidWord() {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("bat");
        dictionary.add("at");
        dictionary.add("test");

        WordChecker wordChecker = new WordChecker(dictionary);

        assertEquals("bat", wordChecker.findValidWord("bat"));
        Assertions.assertNull(wordChecker.findValidWord("test"));
    }
}
