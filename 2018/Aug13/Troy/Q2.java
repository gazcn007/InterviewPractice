class Solution {
    // Here my solution relied on our ability to have special mark/symbol for
    // visted node (I used Integer.MAX_VALUE for this) and it just simpler to code
    // and understand. But if not, we can also solve this problem by processing row
    // and column indexes carefully.
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int M = matrix.length;
        if (M > 0) {
            int N = matrix[0].length;
            int direction = 0; // 0 for right, 1 for down, 2 for left, 3 for up
            int i = 0;
            int j = 0;
            boolean failTwice = false;
            while (true) {
                if (matrix[i][j] != Integer.MAX_VALUE ) {
                    result.add(matrix[i][j]);
                    matrix[i][j] = Integer.MAX_VALUE; // Use MAX_VALUE as a mark for visited node
                }
                int temp_i = i;
                int temp_j = j;
                if (direction == 0) {
                    temp_j ++;
                } else if (direction == 1) {
                    temp_i ++;
                } else if (direction == 2) {
                    temp_j --;
                } else if (direction == 3) {
                    temp_i --;
                }
                if (temp_i < 0 || temp_i >= M || temp_j < 0 || temp_j >= N || matrix[temp_i][temp_j] == Integer.MAX_VALUE) {
                    direction++;
                    direction = direction % 4;
                    if (failTwice) break;
                    failTwice = true;
                    continue;
                }
                failTwice = false;
                i = temp_i;
                j = temp_j;
            }
        }
        return result;
    }
}
