class Solution {
    // Slightly different from the provided solution
    public int splitArray(int[] nums, int m) {
        long start = 0;
        long end = sum(nums);
        long largest = end;
        while(start < end) {

            long middle = (start + end) / 2;
            int tmpCount = 0;
            long tmpSum = 0;
            boolean possible = false;
            for(int i = 0; i < nums.length; i++) {
                if (tmpSum > middle) {
                    break;
                }
                tmpSum += nums[i];
                if (tmpSum > middle) {
                    tmpCount++;
                    tmpSum = nums[i];
                } else if (tmpSum == middle) {
                    tmpCount++;
                    tmpSum = 0;
                    possible = true;
                }
            }
            if (tmpSum != 0) {
                if (tmpSum == middle) {
                    tmpCount++;
                    possible = true;
                } else if (tmpSum > middle) {
                    tmpCount = m + 1;
                } else if (tmpSum < middle) {
                    tmpCount++;
                }
            }
            if (tmpCount <= m) {
                end = middle;
                if (middle < largest && possible) largest = middle;
            } else if (tmpCount > m) {
                start = middle + 1;
            }
        }
        return (int)largest;
    }

    public long sum(int [] nums) {
        long result = 0;
        for(int n : nums) {
            result += n;
        }
        return result;
    }
}

class Solution {
    // Provided solution
    public int splitArray(int[] nums, int m) {
        long l = 0;
        long r = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            r += nums[i];
            if (l < nums[i]) {
                l = nums[i];
            }
        }
        long ans = r;
        while (l <= r) {
            long mid = (l + r) >> 1;
            long sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt ++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (cnt <= m) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }
}
