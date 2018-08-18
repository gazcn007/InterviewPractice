class Solution(object):
    def findDiagonalOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        lenY = len(matrix)
        if(lenY==0):
        	return []
        lenX = len(matrix[0])
        currentX = 0
        currentY = 0
        oddDiagonal = True  # while True, we go up right currentX+1 currentY-1
        # while False, we go down left currentX-1, currentY+1
        arrayOfDiagonals = []
        while True:
            print(currentY, currentX)
            arrayOfDiagonals.append(matrix[currentY][currentX])
            # base case
            if currentX + 1 == lenX and currentY + 1 == lenY:
                break
            if oddDiagonal:
                if currentY == 0 or currentX + 1 == lenX:  # if reaches boundary
                    oddDiagonal = False
                    if currentX + 1 != lenX:
                        currentX += 1
                    elif currentY + 1 != lenY:
                        currentY += 1
                    else:
                        break
                else:
                    currentX += 1
                    currentY -= 1
            elif not oddDiagonal:
                if currentX == 0 or currentY + 1 == lenY:
                    oddDiagonal = True
                    if currentY + 1 != lenY:
                        currentY += 1
                    elif currentX + 1 != lenX:
                        currentX += 1
                    else:
                        break
                else:
                    currentX -= 1
                    currentY += 1
        return arrayOfDiagonals


s = Solution()
m1 = [[1, 2],
      [3, 4],
      [5, 6]]
m2 = [[1, 2, 3],
      [4, 5, 6]]
m3 = [[1, 2, 3],
      [4, 5, 6],
      [7, 8, 9]]
m4 = [[1, 2, 3, 4, 5],
      [4, 5, 6, 4, 6],
      [7, 8, 9, 4, 5]]
m5 = []
print(s.findDiagonalOrder(m1))
