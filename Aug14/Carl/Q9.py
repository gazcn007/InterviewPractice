import sys
class Solution(object):
    def minSubArrayLen(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        total_sum = 0
        minSubArrayLen = sys.maxsize
        start = 0 
        end = 0 
        while end < len(nums):
            total_sum += nums[end]
            end += 1
            while total_sum >= s:
                minSubArrayLen = min(minSubArrayLen, end-start)
                total_sum -= nums[start]
                start += 1
        if minSubArrayLen == sys.maxsize:
            return 0
        return minSubArrayLen

S = Solution()
print(S.minSubArrayLen(10, [1,3,6,2,4,10]))