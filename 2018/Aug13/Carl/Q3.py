class Solution(object):
    def generate(self, numRows):  # 3
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        if numRows <= 0:
            return []
        pascal = [[1]]
        row = []
        if numRows == 1:
            return pascal
        for rowNum in range(1, numRows):  # 1, 2
            row.append(1)
            for rowIndex in range(1, rowNum):  # 1
                row.append(pascal[rowNum-1][rowIndex-1] +
                           pascal[rowNum-1][rowIndex])
            row.append(1)
            pascal.append(row)
            row = []
        return pascal


s = Solution()
print(s.generate(-1))
