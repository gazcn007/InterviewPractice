### Q1 [Leetcode 325] [Maximum Size Subarray Sum Equals k](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k)
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
```
Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
```
Example 2:
```
Input: nums = [-2, -1, 2, 1], k = 1
Output: 2
Explanation: The subarray [-1, 2] sums to 1 and is the longest.
```
Follow Up:
Can you do it in O(n) time?

### Q2 [Leetcode 165] [Compare Version Numbers](https://leetcode.com/problems/compare-version-numbers)
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Example 1:
```
Input: version1 = "0.1", version2 = "1.1"
Output: -1
```
Example 2:
```
Input: version1 = "1.0.1", version2 = "1"
Output: 1
```
Example 3:
```
Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
```

### Q3 [Leetcode 5] [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
```
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```
Example 2:
```
Input: "cbbd"
Output: "bb"
```
