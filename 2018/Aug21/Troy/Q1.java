class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int []result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                result = new int[]{i, map.get(target - nums[i])};
                break;
            }
        }
        return result;
    }
}
