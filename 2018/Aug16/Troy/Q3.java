class Solution {
    public String reverseWords(String s) {
        // Can also rely on native split & reverse methods
        // instead of manipulating indexes. But by manipulating
        // indexes, we can make updates in-place and have O(1) space
        // complexity in C / C++ (not in Java due to the immutable String
        // type).
        StringBuilder result = new StringBuilder();
        int len = s.length();

        int wordStart = 0;
        int wordEnd = 0;
        for(int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                if (wordStart == wordEnd) {
                    wordStart++;
                    wordEnd++;
                } else {
                    for(int j = wordEnd - 1; j >= wordStart; j--) {
                        result.append(s.charAt(j));
                    }
                    wordEnd++;
                    wordStart = wordEnd;
                }
                result.append(' ');
            } else {
                wordEnd++;
            }
        }

        if (wordEnd != wordStart) {
            for(int j = wordEnd - 1; j >= wordStart; j--) {
                result.append(s.charAt(j));
            }
        }
        return result.toString();
    }
}
