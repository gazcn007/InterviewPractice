class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int result = 0;
        int start = 0;
        int end = len - 1;
        while (start < end) {
            int temp = (end - start) * Math.min(height[start], height[end]);
            if (temp > result) result = temp;
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
