class Solution {
    public int numSquares(int n) {
        // BFS solution
        Queue<Integer> queue = new LinkedList();
        HashSet<Integer> visited = new HashSet<>();
        int result = 1;
        for(int i = 1; (i * i) <= n; i++) {
            if ((i * i) == n) return result;
            queue.add(i * i);
        }

        while (queue.size() > 0) {
            int len = queue.size();
            while(len > 0) {
                int cur = queue.poll();
                if (cur == n) return result;
                if (cur < n && !visited.contains(cur)) {
                    for(int i = 1; (i * i) <= n - cur; i++) {
                        queue.add(cur + i * i);
                    }
                    visited.add(cur);
                }
                len--;
            }
            result++;
        }
        return result;
    }
}

class Solution {
    // DP solution
    public int numSquares(int n) {
        int [] table= new int[n+1];
        table[0] = 0;
        table[1] = 1;
        for(int i = 2; i <= n; i++) {
            table[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                table[i] = Math.min(table[i], 1 + table[i - j * j]);
            }
        }
        return table[n];
    }
}
