class Solution {
    public int pivotIndex(int[] nums) {
            int sumRHS = sumArray(nums);
            int sumLHS = 0;
            for(int i = 0; i < nums.length; i++) {
                if (sumLHS == (sumRHS - nums[i])) {
                    return i;
                }
                sumLHS += nums[i];
                sumRHS -= nums[i];
            }
        return -1;
    }
    public int sumArray(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        return result;
    }
}
