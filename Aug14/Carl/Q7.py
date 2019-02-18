class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        i_new = 0
        for i_old in range(0, len(nums)):
            if(nums[i_old]!=val):
                nums[i_new] = nums[i_old]
                i_new += 1
        return i_new


s = Solution()
arr = [1,2,3,4,5,5,6]
print(s.removeElement(arr, 5))
print(arr)
