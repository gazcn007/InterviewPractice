class Solution:
    def merge_arr(self, array):
        sum = 1
        for i in range(len(array)):
            sum = array[i] * sum
        return [sum/e for e in array]


S = Solution()
print(S.merge_arr([1, 2, 3, 4]))
print(S.merge_arr([]))
print(S.merge_arr([-1, -2, -3, -4]))
print(S.merge_arr([1]))
