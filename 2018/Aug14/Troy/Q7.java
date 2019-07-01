class Solution {
    public int removeElement(int[] nums, int val) {
        int i_new = 0;
        int i_old = 0;
        int len = nums.length;
        for (; i_old < len; i_old++) {
            if (nums[i_old] != val) {
                nums[i_new] = nums[i_old];
                i_new++;
            }
        }
        return i_new;
    }
}
