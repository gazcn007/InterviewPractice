class Solution {
    // O(1) space complexity solution
    // Note this question is repeated (Aug16 Q2)
    public void reverseWords(char[] str) {
        reverseString(str, 0, str.length - 1, str.length / 2);
        int prev = 0;
        for(int i = 0; i < str.length - 1; i++) {
            if (str[i] == ' ') {
                reverseString(str, prev, i - 1, (i - prev) / 2);
                prev = i + 1;
            }
        }
        reverseString(str, prev, str.length - 1, (str.length - prev) / 2);
    }

    public void reverseString(char[] charArray, int start, int end, int times) {
        while(times > 0) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
            times--;
        }
    }
}
