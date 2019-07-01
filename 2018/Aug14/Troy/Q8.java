class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int result = 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                if (temp > result) result = temp;
                temp = 0;
            } else {
                temp++;
            }
        }
        return Math.max(temp, result);
    }
}
