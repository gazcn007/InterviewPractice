class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        leftSum = 0
        rightSum = sum(nums)
        for i, value in enumerate(nums):
            rightSum -= value
            if(leftSum == rightSum):
                return i
            leftSum += value
        return -1


s = Solution()
print(s.pivotIndex([-1, -1, 0, 1, 1, -1]))
