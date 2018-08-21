class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> intersection = new HashMap<>();
        for (int i : nums1) {
            if (!intersection.containsKey(i)) {
                intersection.put(i, 1);
            } else {
                intersection.put(i, intersection.get(i) + 1);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int j : nums2) {
            if (intersection.containsKey(j) && intersection.get(j) > 0) {
                resultList.add(j);
                intersection.put(j, intersection.get(j) - 1);
            }
        }


        int [] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) result[i] = resultList.get(i);
        return result;
    }
}
