### Q1 [Leetcode 652] [Find Duplicate Subtrees](https://leetcode.com/problems/find-duplicate-subtrees)

Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:
```
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
```
The following are two duplicate subtrees:
```
      2
     /
    4
```
and
```
    4
```
Therefore, you need to return above trees' root in the form of a list.

### Q2 [Leetcode 771] [Jewels and Stones](https://leetcode.com/problems/jewels-and-stones)

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
```
Input: J = "aA", S = "aAAbbbb"
Output: 3
```
Example 2:
```
Input: J = "z", S = "ZZ"
Output: 0
```
Note:

* S and J will consist of letters and have length at most 50.
* The characters in J are distinct.

### Q3 [Leetcode 3] [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters)

Given a string, find the length of the longest substring without repeating characters.

Example 1:
```
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", which the length is 3.
```
Example 2:
```
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```
Example 3:
```
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

### Q4 [Leetcode 170] [Two Sum III - Data structure design](https://leetcode.com/problems/two-sum-iii-data-structure-design)

Design and implement a TwoSum class. It should support the following operations: add and find.

`add` - Add the number to an internal data structure.

`find` - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:
```
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
```
Example 2:
```
add(3); add(1); add(2);
find(3) -> true
find(6) -> false
```

### Q5 [Leetcode 454] [4Sum II](https://leetcode.com/problems/4sum-ii)

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most 2^31 - 1.

Example:
```
Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
```
