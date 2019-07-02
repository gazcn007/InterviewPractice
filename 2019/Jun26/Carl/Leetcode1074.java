public class Leetcode1074 {
    public static void main(String[] args) {
        /*
        [[1 , 2, 3]
         [-2,-1, 3]
		 [1 , 1, 2]
        */

		 /* 
		 target = 0
		 i=0,
		 j=0, 
		 {0: 1}, 
		 cur =0, 
		 k=1, 
		 res=0
        [[1 , 2, 3]
         [-2,-3, 0]
		 [1 , 2, 4]]
        */
    }

    public int numSubmatrixSumTarget(int[][] A, int target) {
        int m = A.length, n = A[0].length; // m = 3, n = 3
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                A[i][j] += A[i][j - 1];
        int res = 0;
        /*
    	A = [[1 , 2, 3]
         	 [-2,-3, 0]
		 	 [1 , 2, 4]]
		 */
        for (int i = 0; i < n; i++) { // i = 0
            for (int j = i; j < n; j++) { // j = 0
                Map<Integer, Integer> counter = new HashMap<>();
                counter.put(0, 1); // counter {0: 1, 1: 1}
                int cur = 0; 
                for (int k = 0; k < m; k++) { // k = 1
                    cur += A[k][j] - (i > 0 ? A[k][i - 1] : 0); // cur = -1
                    res += counter.getOrDefault(cur - target, 0); //res = 0
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}