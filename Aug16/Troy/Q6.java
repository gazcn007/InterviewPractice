class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m > 0) {
            int n = rooms[0].length;
            for(int i = 0; i < m ; i++) {
                for(int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) {
                        Queue<int[]> queue = new LinkedList();
                        queue.add(new int[]{i, j, 0});
                        while (queue.size() > 0) {
                            int[] element = queue.poll();
                            int y = element[0];
                            int x = element[1];
                            int distance = element[2] + 1;
                            if (y - 1 >= 0 && rooms[y-1][x] > distance) {
                                rooms[y-1][x] = distance;
                                queue.add(new int[] {y - 1, x, distance});
                            }
                            if (y + 1 < m && rooms[y+1][x] > distance) {
                                rooms[y+1][x] = distance;
                                queue.add(new int[] {y + 1, x, distance});
                            }
                            if (x + 1 < n && rooms[y][x+1] > distance) {
                                rooms[y][x+1] = distance;
                                queue.add(new int[] {y, x + 1, distance});
                            }
                            if (x - 1 >= 0 && rooms[y][x-1] > distance) {
                                rooms[y][x-1] = distance;
                                queue.add(new int[] {y, x - 1, distance});
                            }
                        }
                    }
                }
            }
        }
    }
}
