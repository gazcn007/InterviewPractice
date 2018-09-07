### Q1 [Leetcode 238] [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self)
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:
```
Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).
```
Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

### Q2 [Leetcode 273] [Integer to English Words](https://leetcode.com/problems/integer-to-english-words)

Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2³¹ - 1.

Example 1:
```
Input: 123
Output: "One Hundred Twenty Three"
```
Example 2:
```
Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
```
Example 3:
```
Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
```
Example 4:
```
Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
```

### Q3 [Leetcode 2] [Add Two Numbers](https://leetcode.com/problems/add-two-numbers)

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

### Q4 [Leetcode 160] [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists)

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:
```
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
```
begin to intersect at node c1.


Notes:

* If the two linked lists have no intersection at all, return null.
* The linked lists must retain their original structure after the function returns.
* You may assume there are no cycles anywhere in the entire linked structure.
* Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.

### Q5 [Leetcode 23] [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists)

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
```
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

### Q6 [Leetcode 129] [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers)

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:
```
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
```
Example 2:
```
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
```

### Q7 [Leetcode 654] [Maximum Binary Tree](https://leetcode.com/problems/maximum-binary-tree)
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

1. The root is the maximum number in the array.
2. The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
3. The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.

Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
```
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    /
     2  0   
       \
        1
```
Note:
The size of the given array will be in the range [1,1000].

### Q8 [Leetcode 653] [Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst)
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
```
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
```
Example 2:
```
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
```
