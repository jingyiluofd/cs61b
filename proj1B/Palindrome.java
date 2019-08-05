
public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> D = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++) {
            D.addLast(word.charAt(i));
        }
        return D;
    }

    private boolean ispalindromehelper(Deque B) {
        if (B.size() == 0 || B.size() == 1) {
            return true;
        }

        if (B.removeFirst() != B.removeLast()) {
            return false;
        }
        return ispalindromehelper(B);

    }

    public boolean isPalindrome(String word) {
        Deque A = wordToDeque(word);
        return ispalindromehelper(A);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (!cc.equalChars(word.charAt(left), word.charAt(right))) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

}