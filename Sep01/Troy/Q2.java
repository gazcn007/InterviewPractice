class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        int start = 0;
        int end = len - 1;
        while(start <= end) {
            int middle = (end - start) / 2 + start;
            if (nums[middle] == target) return middle;
            if (nums[middle] > target) end = middle - 1;
            if (nums[middle] < target) start = middle + 1;
        }
        return -1;
    }
}
