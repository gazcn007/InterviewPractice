class Solution {
    public int mySqrt(int x) {
        int seed = 0;
        while(true) {
            if ((long) seed * seed > x) {
                break;
            }
            seed++;
        }
        return seed - 1;
    }
}
