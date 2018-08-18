class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        boolean direction = true; // True for up, False for down
        int[] result = new int[0];
        int M = matrix.length;
        int idx = 0;
        if (M > 0) {
            int N = matrix[0].length;
            result = new int[M * N];
            int i = 0;
            int j = 0;
            while((i < M - 1) || (j < N - 1)) {
                result[idx] = matrix[i][j];
                idx++;
                if (!direction) {
                    if (i + 1 >= M || j - 1 < 0) {
                        direction = !direction;
                        if (i + 1 >= M) {
                            j++;
                        } else {
                            i++;
                        }
                        continue;
                    }
                    i++;
                    j--;
                } else {
                    if (i - 1 < 0 || j + 1 >= N) {
                        direction = !direction;
                        if (j + 1 >= N) {
                            i++;
                        } else {
                            j++;
                        }
                        continue;
                    }
                    i--;
                    j++;
                }
            }
            result[idx] = matrix[i][j];
        }
        return result;
    }
}
