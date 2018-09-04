class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int middle = (start + end) / 2;
            if (nums[middle] > nums[end]) {
                start = middle + 1;
            } else if (nums[middle] < nums[end]) {
                end = middle;
            } else if (nums[middle] == nums[end]){
                end -= 1;
            }
        }
        return nums[end];
    }
}
