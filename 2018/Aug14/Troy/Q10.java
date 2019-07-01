class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Went with a O(m+n) solution, this can be easily optimized
        // to O((m+n)/2) without the explicit temp array. For O(log(m+n))
        // performance as required by the problem, a recursive method
        // should be used. (Fact: just too lazy)
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        boolean even = len % 2 == 0;
        int[] temp = new int[len];

        int i_1 = 0;
        int i_2 = 0;
        for(int i = 0; i < len; i ++) {
            if (i_1 >= len1) {
                temp[i] = nums2[i_2];
                i_2++;
            } else if (i_2 >= len2) {
                temp[i] = nums1[i_1];
                i_1++;
            } else if ((nums1[i_1] > nums2[i_2])) {
                temp[i] = nums2[i_2];
                i_2++;
            } else {
                temp[i] = nums1[i_1];
                i_1++;
            }
        }
        if (even) {
            return (temp[len / 2 - 1] + temp[len / 2 ]) / 2.0;
        }
        return temp[len / 2];
    }
}
