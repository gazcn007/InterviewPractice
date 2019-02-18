class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)
        totalSum = 0
        for i in range(0, len(nums), 2):
            totalSum += nums[i]
        return totalSum

a = [1,2,3,4]
print(len(a))
