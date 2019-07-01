from math import floor


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        length = len(nums)
        if length == 0:
            return -1
        start = 0
        end = length-1
        while(start <= end):
            mid = floor((start+end)/2)
            if nums[mid] == target:
                return mid
            elif target > nums[mid]:
                start = mid + 1
            else:
                end = mid - 1
        return -1


S = Solution()
print(S.search([1, 2, 3, 4, 5], 5))
