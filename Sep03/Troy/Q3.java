class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long p = n < 0 ? -(long)n : (long)n;

        double result = x;
        double tmp = 1;
        while(p > 1) {
            boolean even = p % 2 == 0;
            tmp = even ? tmp : tmp * result;
            result *= result;
            p /= 2;
        }
        result *= tmp;

        if (n < 0) result = 1 / result;
        return result;
    }
}
