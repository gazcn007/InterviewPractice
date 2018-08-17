class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int numOfZeros = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                numOfZeros++;
            } else {
                nums[i - numOfZeros] = nums[i];
            }

        }

        for (int j = len - 1; j >= len - numOfZeros; j--) {
            nums[j] = 0;
        }
    }
}
