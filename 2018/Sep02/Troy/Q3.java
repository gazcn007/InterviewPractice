class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int len = nums.length;
        LinkedList<Integer> result = new LinkedList<>();
        int start = 0;
        int end = len - 1;
        while(start + 1 < end) {
            int middle = (end + start) / 2;
            if (nums[middle] == x) {
                start = middle;
                end = start + 1;
            } else if (nums[middle] < x) {
                if (Math.abs(nums[middle] - x) > Math.abs(nums[middle + 1] - x)){
                    start = middle + 1;
                } else {
                    start = middle;
                    end = start + 1;
                }
            } else if (nums[middle] > x) {
                end = middle;
            }
        }
        for(int i = 0; i < k; i++) {
            if (start == -1) {
                result.add(nums[end]);
                end++;
            } else if (end == len) {
                result.addFirst(nums[start]);
                start--;
            } else {
                int s = nums[start];
                int e = nums[end];
                if (Math.abs(s - x) <= Math.abs(e - x)) {
                    result.addFirst(s);
                    start--;
                } else {
                    result.add(e);
                    end++;
                }
            }

        }
        return result;
    }
}
