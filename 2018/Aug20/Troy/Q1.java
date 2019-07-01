class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        if (m > 0) {
            int n = image[0].length;
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{sr, sc});
            while(stack.size() > 0) {
                int[] coordinate = stack.pop();
                int y = coordinate[0];
                int x = coordinate[1];
                if (image[y][x] == newColor) continue;
                int tmp = image[y][x];
                image[y][x] = newColor;

                if (y + 1 < m && image[y+1][x] == tmp) {
                    stack.push(new int[]{y+1, x});
                }
                if (y - 1 >= 0 && image[y-1][x] == tmp) {
                    stack.push(new int[]{y-1, x});
                }
                if (x + 1 < n && image[y][x+1] == tmp) {
                    stack.push(new int[]{y, x+1});
                }
                if (x - 1 >= 0 && image[y][x-1] == tmp) {
                    stack.push(new int[]{y, x-1});
                }
            }
        }
        return image;
    }
}
