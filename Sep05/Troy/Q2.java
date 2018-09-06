class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] shorterArray = nums1.length > nums2.length ? nums2 : nums1;
        int[] longerArray = nums1.length > nums2.length ? nums1 : nums2;
        int m = shorterArray.length;
        int n = longerArray.length;

        int start = 0;
        int end = m;
        boolean even = (m + n) % 2 == 0;
        while(start <= end) {
            int i = (start + end) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i > start && shorterArray[i - 1] > longerArray[j]) {
                end = i - 1;
            } else if (i < end && longerArray[j - 1] > shorterArray[i]) {
                start = i + 1;
            } else {
                int leftMax = 0;
                if (i == 0) {
                    leftMax = longerArray[j - 1];
                } else if (j == 0) {
                    leftMax = shorterArray[i - 1];
                } else {
                    leftMax = shorterArray[i - 1] > longerArray[j - 1] ? shorterArray[i - 1] : longerArray[j - 1];
                }
                if (!even) return leftMax;

                int rightMin = 0;
                if (i == m) {
                    rightMin = longerArray[j];
                } else if (j == n) {
                    rightMin = shorterArray[i];
                } else {
                    rightMin = shorterArray[i] > longerArray[j] ? longerArray[j] : shorterArray[i];
                }

                return (rightMin + leftMax) / 2.0;
            }
        }
        return 0.0;
    }
}
