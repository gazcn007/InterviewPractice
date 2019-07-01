class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int len = numbers.length;
        for(int i = 0; i < len; i ++) {
            result[0] = i + 1;
            for (int j = i + 1; j < len; j++) {
                if (numbers[j] == target - numbers[i]) {
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }
}
