class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_1s = 0
        counter = 0
        for i in range(0, len(nums)):
            if nums[i] == 1:
                counter += 1
            else:
                if counter > max_1s:
                    max_1s = counter
                counter = 0
        if counter > max_1s:
            max_1s = counter
        return max_1s

s = Solution()
print(s.findMaxConsecutiveOnes([1,1,0,0,1,1,1]))