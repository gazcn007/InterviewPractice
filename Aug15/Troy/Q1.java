class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int result = 0;
        if (len > 0) {
            result = nums[0];
            int temp = 0;
            for(int i = 0; i < len; i++) {
                temp += nums[i];
                if (temp > result) result = temp;
                if (temp < 0) temp = 0; // no help for futher addition so reset to zero
            }
        }
        return result;

    }
}
