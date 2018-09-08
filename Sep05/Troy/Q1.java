class Solution {
  // O(n) solution, similar to LC142
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int slow2 = 0;
        while (slow2 != slow) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow2;
    }
}


class Solution {
    // O(nlogn) solution
    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        while(start < end) {
            int middle = start + (end - start) / 2;
            int countLess = 0;
            int countSelf = 0;
            int countLarge = 0;
            for(int n : nums) {
                if (n < middle) {
                    countLess++;
                } else if (n == middle) {
                    countSelf++;
                } else if (n > middle) {
                    countLarge++;
                }
            }
            if (countSelf > 1) return middle;
            if (countLess >= middle) {
                end = middle - 1;
            } else if (countLarge >= (end - middle)) {
                start = middle + 1;
            }
        }
        return start;
    }
}
