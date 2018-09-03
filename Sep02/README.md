## LeetCode Binary Search [2/2] (Sep 01, Sep 02)

### Q1 [Leetcode 153] [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,1,2,4,5,6,7]` might become  `[4,5,6,7,0,1,2]`).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
```
Input: [3,4,5,1,2]
Output: 1
```
Example 2:
```
Input: [4,5,6,7,0,1,2]
Output: 0
```

### Binary Search Template III

```java
int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)
        return -1;

    int left = 0, right = nums.length - 1;
    while (left + 1 < right){
        // Prevent (left + right) overflow
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }

    // Post-processing:
    // End Condition: left + 1 == right
    if(nums[left] == target) return left;
    if(nums[right] == target) return right;
    return -1;
}
```

Template #3 is another unique form of Binary Search. It is used to search for an element or condition which requires accessing the current index and its immediate left and right neighbor's index in the array.

Key Attributes:

* An alternative way to implement Binary Search
* Search Condition needs to access element's immediate left and right neighbors
* Use element's neighbors to determine if condition is met and decide whether to go left or right
* Gurantees Search Space is at least 3 in size at each step
* Post-processing required. Loop/Recursion ends when you have 2 elements left.
* Need to assess if the remaining elements meet the condition.

Distinguishing Syntax:

* Initial Condition: `left = 0, right = length-1`
* Termination: `left + 1 == right`
* Searching Left: `right = mid`
* Searching Right: `left = mid`

### Q2 [Not Found] [Search for a Range](https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```
Example 2:
```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

### Q3 [Leetcode 658] [Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements)

Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
```
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
```
Example 2:
```
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
```
Note:
* The value k is positive and will always be smaller than the length of the sorted array.
* Length of the given array is positive and will not exceed 10⁴
* Absolute value of elements in the array and x will not exceed 10⁴

<span style="color:red">It seems at least one test case is problematic:</span>
```
Input: [0,1,2,3,4,4,4,5,5,5,6,7,9,9,10,10,11,11,12,13,14,14,15,17,19,19,22,24,24,25,25,27,27,29,30,32,32,33,33,35,36,38,39,41,42,43,44,44,46,47,48,49,52,53,53,54,54,57,57,58,59,59,59,60,60,60,61,61,62,64,66,68,68,70,72,72,74,74,74,75,76,76,77,77,80,80,82,83,85,86,87,87,92,93,94,96,96,97,98,99]
k = 25
x = 90
Output:
[72,72,74,74,74,75,76,76,77,77,80,80,82,83,85,86,87,87,92,93,94,96,96,97,98]
Expected:
[72,74,74,74,75,76,76,77,77,80,80,82,83,85,86,87,87,92,93,94,96,96,97,98,99]
```
Since the problem said `If there is a tie, the smaller elements are always preferred.`, the expected output is incorrect.
