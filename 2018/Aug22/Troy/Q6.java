class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // Can also try quickselect, may spend tommorw on reviewsing
        // various sort algorithms. 
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : map.keySet()) {
            if (bucket[map.get(num)] == null) bucket[map.get(num)] = new ArrayList<>();
            bucket[map.get(num)].add(num);
        }

        int tmp = k;
        List<Integer> result = new ArrayList<>();
        for(int i = nums.length ; i >= 0 && tmp > 0; i--) {
            if (bucket[i] != null) {
                for(int j = 0; j < bucket[i].size() && tmp > 0; j++) {
                    result.add(bucket[i].get(j));
                    tmp--;
                }
            }
        }
        return result;

    }
}
