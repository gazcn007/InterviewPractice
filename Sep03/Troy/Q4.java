class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num < 1000000 ? num : 1000000;
        while(start < end) {
            int middle = (start + end) / 2;
            long tmp = (long)middle * middle;
            if (tmp == num) {
                return true;
            } else if (tmp < num) {
                start = middle + 1;
            } else if (tmp > num) {
                end = middle - 1;
            }
        }
        if (start * start == num) return true;
        return false;
    }
}
