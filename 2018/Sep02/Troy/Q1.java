class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while(start < end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] > nums[end]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return nums[end];
    }
}
