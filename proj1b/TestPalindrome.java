import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("level"));
    }

    @Test
    public void testisPalindromeOverload() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("ab", cc));
        assertFalse(palindrome.isPalindrome("lph", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
    }
}
