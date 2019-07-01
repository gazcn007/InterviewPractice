class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int result = 0;
        if (m > 0) {
            int n = grid[0].length;
            Queue<int []> queue = new LinkedList();
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        result++;
                        queue.add(new int[]{i, j});
                        while(queue.size() > 0) {
                            int[] element = queue.poll();
                            int y = element[0];
                            int x = element[1];
                            if (grid[y][x] == 'x') continue;
                            grid[y][x] = 'x';
                            if (y - 1 >= 0 && grid[y-1][x] == '1') {
                                queue.add(new int[] {y - 1, x});
                            }
                            if (y + 1 < m && grid[y+1][x] == '1') {
                                queue.add(new int[] {y + 1, x});
                            }
                            if (x + 1 < n && grid[y][x+1] == '1') {
                                queue.add(new int[] {y, x + 1});
                            }
                            if (x - 1 >= 0 && grid[y][x-1] == '1') {
                                queue.add(new int[] {y, x - 1});
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
