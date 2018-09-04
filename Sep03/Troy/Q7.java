class Solution {
    public int[] twoSum(int[] num, int target) {
        int[] result = new int[2];
        if (num == null || num.length < 2) return result;
        int start = 0;
        int end = num.length - 1;
        while (start < end) {
            int tmp = num[start] + num[end];
            if (tmp == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            } else if (tmp > target) {
                end --;
            } else {
                start ++;
            }
        }
        return result;
    }
}
