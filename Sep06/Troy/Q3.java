class Solution {
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();

        if (charArray.length > 0) {
            int longestLen = 1;
            String result = Character.toString(charArray[0]);
            for(int i = 0; i < charArray.length; i++) {
                for(int j = i + 1; j < charArray.length; j++) {
                    if (charArray[i] == charArray[j]) {
                        int len = j - i + 1;
                        if (len > longestLen) {
                            String tmp = new String(Arrays.copyOfRange(charArray, i, j + 1));
                            StringBuilder builder = new StringBuilder(tmp);
                            String reverse = builder.reverse().toString();
                            if (tmp.equals(reverse)) {
                                longestLen = len;
                                result = reverse;
                            }
                        }
                    }
                }
            }
            return result;
        }
        return s;
    }
}
