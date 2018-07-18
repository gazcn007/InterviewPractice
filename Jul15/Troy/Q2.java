class Solution {
    public int dominantIndex(int[] nums) {
        int max = maxInt(nums);
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                index = i;
            } else if ((2 * nums[i]) > max) {
                return -1;
            }
        }
        return index;
    }
    public int maxInt(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > result) result = nums[i];
        }
        return result;
    }
}
