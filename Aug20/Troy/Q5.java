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

// Failed attempt to a solution without extra space usage ...

// class Solution {
//     public int singleNumber(int[] nums) {
//         int len = nums.length;
//         int result = 0;
//         for(int i = 0; i < len; i++) {
//             int cur = nums[i];
//             if (cur == Integer.MAX_VALUE || hashFunction(len ,cur) == i) continue;
//
//             while(true && cur != 0) {
//                 int hash = hashFunction(len, cur);
//                 int tmp = nums[hash];
//                 if (tmp == cur) {
//                     nums[hash] = Integer.MAX_VALUE;
//                     break;
//                 } else {
//                     nums[hash] = cur;
//                 }
//                 cur = tmp;
//             }
//         }
//
//         for (int i = 0; i < len; i++) {
//             if (nums[i] != Integer.MAX_VALUE && hashFunction(len, nums[i]) == i) result = nums[i];
//         }
//         return result;
//     }
//
//     public int hashFunction(int len, int num) {
//         int p = 179432233;
//         return Math.floorMod(num, len);
//     }
// }
