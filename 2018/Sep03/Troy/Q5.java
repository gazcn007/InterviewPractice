class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while(start < end) {
            int middle = (start + end) / 2;
            if (letters[middle] == target) {
                start = middle + 1;
            } else if (letters[middle] < target) {
                start = middle + 1;
            } else if (letters[middle] > target) {
                end = middle;
            }
        }
        if (letters[end] > target) return letters[end];
        return letters[0];
    }
}
