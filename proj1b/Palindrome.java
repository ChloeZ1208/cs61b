public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> D = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++) {
            char chari = word.charAt(i);
            D.addLast(chari);
        }
        return D;
    }
    public boolean isPalindrome(String word) {
        if(word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> d = wordToDeque(word);
        for(int i = 0; i < word.length()/2; i++) {
            if (d.removeLast().equals(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if(word.length() == 0 || word.length() == 1) {
            return true;
        }
        for(int i = 0; i < word.length()/2; i++) {
            if(cc.equalChars(word.charAt(i), word.charAt(word.length() - i - 1))) {
                return true;
            }
        }
        return false;
    }


}
