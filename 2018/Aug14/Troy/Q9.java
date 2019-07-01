class Solution {
    // O(n) solution
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int temp_count = 0;
        int result = Integer.MAX_VALUE;
        int start = 0;
        for (int end = 0; end < len; end++) {
            temp_count += nums[end];
            if (temp_count >= s) {
                if (result > (end - start + 1)) {
                    result = end - start + 1;
                }
                temp_count -= nums[start];
                temp_count -= nums[end];
                start++;
                end--;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
