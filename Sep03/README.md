## LeetCode Binary Search [3/3] (Sep 01, Sep 02, Sep 03)

### Binary Search Template Analysis
Template Explanation:
```
99% of binary search problems that you see online will fall into 1 of these 3 templates. Some problems can be implemented using multiple templates, but as you practice more, you will notice that some templates are more suited for certain problems than others.
```
Note: The templates and their differences have been colored coded below.

![img](./Troy/Template_Diagram.png)

These 3 templates differ by their:

* left, mid, right index assignments
* loop or recursive termination condition
* necessity of post-processing

Template 1 and 3 are the most commonly used and almost all binary search problems can be easily implemented in one of them. Template 2 is a bit more advanced and used for certain types of problems.

Each of these 3 provided templates provide a specific use case:

Template #1 `(left <= right)`:

* Most basic and elementary form of Binary Search
* Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
* No post-processing required because at each step, you are checking to see if the element has been found. If you reach the end, then you know the element is not found


Template #2 `(left < right)`:

* An advanced way to implement Binary Search.
* Search Condition needs to access element's immediate right neighbor
* Use element's right neighbor to determine if condition is met and decide whether to go left or right
* Gurantees Search Space is at least 2 in size at each step
* Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining element meets the condition.


Template #3 `(left + 1 < right)`:

An alternative way to implement Binary Search
Search Condition needs to access element's immediate left and right neighbors
Use element's neighbors to determine if condition is met and decide whether to go left or right
Gurantees Search Space is at least 3 in size at each step
Post-processing required. Loop/Recursion ends when you have 2 elements left. Need to assess if the remaining elements meet the condition.


Time and Space Complexity:

Runtime: O(log n) -- Logorithmic Time

Because Binary Search operates by applying a condition to the value in the middle of our search space and thus cutting the search space in half, in the worse case, we will have to make O(log n) comparisons, where n is the number of elements in our collection.
```
Why log n?

Binary search is performed by dividing the existing array in half.
So every time you a call the subroutine ( or complete one iteration ) the size reduced to half of the existing part.
First N become N/2, then it become N/4 and go on till it find the element or size become 1.
The maximum no of iterations is log N (base 2).
```

Space: O(1) -- Constant Space

Although, Binary Search does require keeping track of 3 indicies, the iterative solution does not typically require any other additional space and can be applied directly on the collection itself, therefore warrants O(1) or constant space.



Other Types of Binary Search:

Below, we have provided another type of Binary Search for practice.

Binary Search With 2 Arrays -- In this problem, we need to compare values from 2 arrays to determine our search space: LC #4: Median of Two Sorted Arrays

### Q1 [Leetcode 270] [Closest Binary Search Tree Value](https://leetcode.com/problems/closest-binary-search-tree-value)

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

* Given target value is a floating point.
* You are guaranteed to have only one unique value in the BST that is closest to the target.

Example:
```
Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
```

### Q2 [Leetcode 702] [Search in a Sorted Array of Unknown Size](https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size)

Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).

You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.



Example 1:
```
Input: array = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```
Example 2:
```
Input: array = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

Note:

* You may assume that all elements in the array are unique.
* The value of each element in the array will be in the range [-9999, 9999].

### Q3 [Leetcode 50] [Pow(x, n)](https://leetcode.com/problems/powx-n)
Implement pow(x, n), which calculates x raised to the power n (xⁿ).

Example 1:
```
Input: 2.00000, 10
Output: 1024.00000
```
Example 2:
```
Input: 2.10000, 3
Output: 9.26100
```
Example 3:
```
Input: 2.00000, -2
Output: 0.25000
Explanation: 2⁻² = 1/2² = 1/4 = 0.25
```
Note:

* -100.0 < x < 100.0
* n is a 32-bit signed integer, within the range [−2³¹, 2³¹ − 1]

### Q4 [Leetcode 367] [Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square)

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
```
Input: 16
Output: true
```
Example 2:
```
Input: 14
Output: false
```

### Q5 [Leetcode 744] [Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target)

Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
```
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
```

Note:
* letters has a length in range [2, 10000].
* letters consists of lowercase letters, and contains at least 2 unique letters.
* target is a lowercase letter.

### Q6 [Leetcode 154] [Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:
```
Input: [1,3,5]
Output: 1
```
Example 2:
```
Input: [2,2,2,0,1]
Output: 0
```
Note:

* This is a follow up problem to [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/).
* Would allow duplicates affect the run-time complexity? How and why?

### Q7 [Leetcode 167] [Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted)

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

* Your returned answers (both index1 and index2) are not zero-based.
* You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:
```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```
