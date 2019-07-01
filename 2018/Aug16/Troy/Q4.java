class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int new_idx = 0;
        for(int old_idx = 1; old_idx < len; old_idx++ ) {
            if (nums[old_idx] != nums[new_idx]) {
                new_idx++;
                nums[new_idx] = nums[old_idx];
            }
        }
        return new_idx + 1;
    }
}
