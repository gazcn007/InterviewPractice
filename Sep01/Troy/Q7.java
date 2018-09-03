class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int middle1 = start + (end - start) / 2;
            int middle2 = middle1 + 1;
            if (nums[middle1] < nums[middle2]) {
                start = middle2;
            } else {
                end = middle1;
            }
        }
        return end;
    }
}
