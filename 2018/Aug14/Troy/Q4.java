class Solution {
    public String reverseString(String s) {
        int start = 0;
        int end = s.length() - 1;
        StringBuilder result = new StringBuilder();
        result.append(s);
        while(start < end) {
            char temp = result.charAt(start);
            result.setCharAt(start, result.charAt(end));
            result.setCharAt(end, temp);
            start++;
            end--;
        }
        return result.toString();
    }
}
