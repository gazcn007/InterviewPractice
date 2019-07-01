class Solution {
    // Brute force
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, S, 0);
    }

    public int helper(int[] nums, int S, int idx) {
        int len = nums.length;
        if (idx == len) return S == 0 ? 1 : 0;
        int p = helper(nums, S + nums[idx], idx + 1);
        int n = helper(nums, S - nums[idx], idx + 1);
        return p + n;
    }
}

class Solution {
    // DP solution
    // Key observation:
    // combination of "+", "-" can be divided into
    // two sets: positive, negative. what we need is:
    // sum(negative) + sum(positive) = s
    // sum(negative) = s - sum(positive)
    // -sum(nums) = s - 2sum(positive)
    // sum(positive) = (s + sum(nums)) / 2
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum < s || (s + sum) % 2 != 0) return 0;

        return helper (nums, (s + sum) / 2);
    }

    public int helper(int[] nums, int s) {
        int[] table = new int[s + 1];
        table[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                table[i] += table[i - n];
        return table[s];
    }
}
