class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> mapAB = new HashMap<>();
        HashMap<Integer, Integer> mapCD = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                mapAB.put(A[i]+B[j], mapAB.getOrDefault(A[i]+B[j], 0) + 1);
                mapCD.put(C[i]+D[j], mapCD.getOrDefault(C[i]+D[j], 0) + 1);
            }
        }
        int result = 0;
        for(Map.Entry<Integer, Integer> entry:mapAB.entrySet()){
            int target = 0 - entry.getKey();
            result += entry.getValue() * mapCD.getOrDefault(target, 0);
        }
        return result;
    }
}
