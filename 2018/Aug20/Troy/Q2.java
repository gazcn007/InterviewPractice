class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) continue;
                    int distance = 0;
                    Queue<int []> queue = new LinkedList<>();
                    HashSet<int []> visited = new HashSet<>();
                    queue.add(new int[]{i, j});
                    while(queue.size() > 0) {
                        int tmp = queue.size();
                        while(tmp > 0) {
                            int[] coordinate = queue.poll();
                            if (visited.contains(coordinate)) break;
                            int y = coordinate[0];
                            int x = coordinate[1];
                            if (matrix[y][x] == 0) {
                                matrix[i][j] = distance;
                                queue.clear();
                                break;
                            } else {
                                if (y + 1 < m) queue.add(new int[]{y + 1, x});
                                if (y - 1 >= 0) queue.add(new int[]{y - 1, x});
                                if (x + 1 < n) queue.add(new int[]{y, x + 1});
                                if (x - 1 >= 0) queue.add(new int[]{y,x - 1});
                            }
                            visited.add(coordinate);
                            tmp--;
                        }
                        distance++;
                    }
                }
            }
        }
        return matrix;
    }
}
