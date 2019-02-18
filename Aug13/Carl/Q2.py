class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        lenY = len(matrix)
        if lenY == 0:
            return []
        lenX = len(matrix[0])
        border = 0
        curX = 0
        curY = 0
        arrayToRet = []
        flag = False
        while True:
            # ->
            for x in range(border, lenX - border):  # 1, 2
                arrayToRet.append(matrix[curY][x])
                flag = True
            # down
            if flag:
                curX = lenX - border - 1
                flag = False
            for y in range(border + 1, lenY - border):
                arrayToRet.append(matrix[y][curX])
                flag = True
            # <-
            if flag:
                curY = lenY - border - 1
                flag = False
                for xrev in range(lenX - border - 2, border-1, -1):
                    arrayToRet.append(matrix[curY][xrev])
                    flag = True
            # up
            if flag:
                curX = border
                flag = False
                for yrev in range(lenY - border - 2, border, -1):
                    arrayToRet.append(matrix[yrev][curX])
                    flag = True
            if flag:
                curY = border + 1
            border += 1
            if curX + 1 < lenX - border and flag:
                curX += 1
                flag = False
            else:
                return arrayToRet
                break


s = Solution()
m1 = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
m2 = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12]
]
m4 = [
    [1, 2],
    [5, 6],
    [9, 10]
]
m5 = [
    [1, 2, 3],
    [5, 6, 4],
    [9, 10, 5],
    [2, 4, 3]
]
m6 = [[6, 9, 7]]
m7 = [[6], [9], [7]]
m8 = [[2, 5, 8], [4, 0, -1]]
print(s.spiralOrder(m1))
print(s.spiralOrder(m2))
print(s.spiralOrder(m4))
print(s.spiralOrder(m5))
print(s.spiralOrder(m6))
print(s.spiralOrder(m7))
print(s.spiralOrder(m8))
