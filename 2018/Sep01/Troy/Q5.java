class Solution {
    // Solution finding the idx of smallest value
    public int search(int A[], int n, int target) {
        int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
};

class Solution {
    // Messy solution without finding idx of smallest value.
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while(start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) return middle;
            if (nums[start] <= nums[middle] && nums[middle] <= nums[end]) {
                if (nums[middle] < target) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else if (nums[start] <= nums[middle] && nums[middle] >= nums[end]) {
                if (nums[middle] < target) {
                    start = middle + 1;
                } else if (nums[middle] > target) {
                    if (nums[start] > target) {
                        start = middle + 1;
                    } else if (nums[start] < target) {
                        end = middle - 1;
                    } else {
                        return start;
                    }
                }
            } else if (nums[start] >= nums[middle] && nums[middle] <= nums[end]) {
                if (nums[middle] < target) {
                    if (nums[end] > target) {
                        start = middle + 1;
                    } else if (nums[end] < target) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                } else if (nums[middle] > target) {
                    if (nums[end] > target) {
                        end = middle - 1;
                    } else if (nums[end] < target) {
                        start = middle + 1;
                    } else {
                        return end;
                    }
                }
            }
        }
        return -1;
    }
}
