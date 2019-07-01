class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<>();
        while (true) {
            if (n == 1) return true;
            if (visited.contains(n)) return false;
            visited.add(n);
            int tmp = 0;
            while(n > 0) {
                int cur = n % 10;
                tmp += cur * cur;
                n = n / 10;
            }
            n = tmp;
        }
    }
}
