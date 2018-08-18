class Solution {
    public void rotate(int[] nums, int k) {
        // space complexity O(1)
        // messy code, maybe improve this tommorrow.
        // beat 100% other submissions though hh
        int len = nums.length;
        k = k % len;
        if (len > 0 && k > 0) {
            int iterations = len - 1;
            int i = 0;
            while (iterations > 0) {
                int old_idx = i;
                int new_idx = (old_idx + k) % len;
                int temp = nums[old_idx];
                int start_idx = old_idx;
                i++;
                while (start_idx != new_idx && iterations > 0) {
                    int temp2 = nums[new_idx];
                    nums[new_idx] = temp;
                    iterations--;
                    temp = temp2;
                    old_idx = new_idx;
                    new_idx = (old_idx + k) % len;
                    if (start_idx == new_idx) {
                        nums[new_idx] = temp;
                        iterations--;
                    }
                }
            }
        }
    }
}
