public class Solution {
    public String reverseWords(String s) {
        // Thought about O(1) space solution:
        // reverse the string first
        // then reverse word back
        StringBuilder temp = new StringBuilder();
        int len = s.length();

        int wordEnd = len;
        int wordStart = len;
        for(int i = len - 1; i >= 0;i--) {
            if (s.charAt(i) == ' ') {
                if (wordEnd == wordStart) {
                    wordEnd--;
                    wordStart--;
                } else {
                    if (temp.length() > 0) temp.append(' ');
                    temp.append(s.substring(wordStart, wordEnd));
                    wordStart --;
                    wordEnd = wordStart;
                }
            } else {
                wordStart--;
            }
        }
        if (wordEnd != wordStart) {
            if (temp.length() > 0) temp.append(' ');
            temp.append(s.substring(wordStart, wordEnd));
        }
        return temp.toString();
    }
}
