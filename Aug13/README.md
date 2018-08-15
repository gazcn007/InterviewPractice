## Leetcode Array and String (2/3) [Jul15, Aug13, Aug14]

Similar to a `one-dimensional` array, a `two-dimensional` array also consists of a sequence of elements. But the elements can be laid out in a rectangular grid rather than a line.

In some languages, the multidimensional array is actually implemented internally as a one-dimensional array while in some other languages, there is actually no multidimensional array at all.

1. C++ stores the two-dimensional array as a one-dimensional array. So actually A[i][j] equals to A[i * N + j] if we defined A as a one-dimensional array which also contains M * N elements.

2. In Java, the two-dimensional array is actually a one-dimensional array which contains M elements, each of which is an array of N integers.

### Q1

Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
```
Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
```

### Q2
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
```
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
```
Example 2:
```
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

### Q3
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

![Alt Text](Q3.gif)

In Pascal's triangle, each number is the sum of the two numbers directly above it.
Example:
```
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```
