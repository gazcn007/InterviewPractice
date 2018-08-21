class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> intersection = new HashMap<>();
        for (int i : nums1) {
            if (!intersection.containsKey(i)) intersection.put(i, 1);
        }

        for (int j : nums2) {
            if (intersection.containsKey(j)) intersection.put(j, 2);
        }

        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : intersection.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 2) resultList.add(key);
        }
        int [] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) result[i] = resultList.get(i);
        return result;
    }
}
