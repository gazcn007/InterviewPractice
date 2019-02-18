class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) == 0:
            return 0
        left = 0
        right = len(height) - 1 
        maxArea = 0 
        while left != right:
            maxArea = max(maxArea, (right-left)*min(height[right], height[left]))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return maxArea

S = Solution()
print(S.maxArea([1,2]))