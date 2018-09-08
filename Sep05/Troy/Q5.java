class Solution {
    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int times = charArray.length / 2;
        int start = 0;
        int end = charArray.length - 1;
        while(times > 0) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
            times--;
        }
        return new String(charArray);
    }
}
