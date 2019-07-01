class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return result;

        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int middle = (end + start) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle;
            } else if (nums[middle] == target) {
                end = middle;
            }
        }

        if (nums[start] == target) {
            result[0] = start;
        } else {
            return result;
        }

        start = 0;
        end = nums.length - 1;
        while(start < end) {
            int middle = (end + start) / 2 + 1;
            if (nums[middle] < target) {
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] == target) {
                start = middle;
            }
        }

        if (nums[start] == target) {
            result[1] = start;
        }

        return result;
    }
}
