class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        if len(digits) == 0:
            return []
        Carry = 1  # by default we add one
        Sum = 0
        for i in range(len(digits)-1, -1, -1):
            Sum = digits[i] + Carry
            if Sum >= 10:
                digits[i] = Sum % 10
                Carry = 1
            else:
                digits[i] = Sum
                Carry = 0
        if Carry == 1:
            return [1]+digits
        else:
            return digits


s = Solution()
print(s.plusOne([1, 2, 3, 4]))
print(s.plusOne([9, 9, 9, 9]))
print(s.plusOne([1, 9]))
print(s.plusOne([1]))
print(s.plusOne([]))
