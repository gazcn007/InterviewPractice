class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return -1
        elif len(nums) == 1:
            return 0
        maxValue = 0
        secMaxValue = 0
        maxIndex = 0
        secMaxIndex = 0
        for i, value in enumerate(nums):
            if value > maxValue:
                print(value)
                secMaxIndex = maxIndex
                secMaxValue = maxValue
                maxIndex = i
                maxValue = value
            elif value > secMaxValue:
                secMaxIndex = i
                secMaxValue = value
        print("mv: %d, smv: %d, mi: %d, smi: %d" %
              (maxValue, secMaxValue, maxIndex, secMaxIndex))
        if maxValue >= 2 * secMaxValue:
            return maxIndex
        elif secMaxValue >= 2 * maxValue:
            return secMaxIndex
        else:
            return -1


s = Solution()
print(s.dominantIndex([2, 0, 1, 1]))
