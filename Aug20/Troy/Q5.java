class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], 2);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) result = key;
        }
        return result;
    }
}

// Solution without extra space, key idea is to use
// XOR operation for numbers in array nums. Duplicate
// numbers will be canceled and only the single number
// remains in the end.
class Solution {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            result ^= nums[i];
        }
        return result;
    }
}
