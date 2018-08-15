## Leetcode Array and String (3/3) [Jul15, Aug13, Aug14]

A string is actually an array of unicode characters. You can perform almost all the operations we used in an array. You can try it out by yourself.

However, there are some differences. In this article, we will go through some of them which you should be aware of when dealing with a string. These features might vary a lot from one language to another.

### Compare Function
String has its own compare function (we will show you the usage of compare function in the code below).

However, there is a problem:

```
Can we use "==" to compare two strings?
```

It depends on the answer to the question:

```
Does the language support operator overloading?
```

If the answer is yes (like C++), we may use "==" to compare two strings.
If the answer is no (like Java), we may not use "==" to compare two strings. When we use "==", it actually compares whether these two objects are the same object.

### Mutable and Immutable
Immutable means that you can't change the content of the string once it's initialized.

In some languages (like C++), the string is mutable. That is to say, you can modify the string just like what you did in an array.
In some other languages (like Java), the string is immutable. This feature will bring several problems. We will illustrate the problems and solutions in the next article.

You can determine whether the string in your favorite language is immutable or mutable by testing the `modification operation`.

### Extra Operations
Compare to an array, there are some extra operations we can perform on a string

You should be aware of the time complexity of these built-in operations.

For instance, if the length of the string is N, the time complexity of both finding operation and substring operation is O(N).

Also, in languages which the string is immutable, you should be careful with the concatenation operation (we will explain this in next article as well).

Never forget to take the time complexity of built-in operations into consideration when you compute the time complexity for your solution.

### Immutable String - Problems & Solutions

Obviously, an immutable string cannot be modified. If you want to modify just one of the characters, you have to create a new string.

You should be very careful with `string concatenation` in Java. Let's look at an example when we do string concatenation repeatedly in a for loop:

```
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String s = "";
        int n = 10000;
        for (int i = 0; i < n; i++) {
            s += "hello";
        }
    }
}
```
It takes 272ms to finish this loop in Java while C++ takes less than 1ms. In Java, since the string is immutable, concatenation works by first allocating enough space for the new string, copy the contents from the old string and append to the new string.

Therefore, the time complexity in total will be:
```
   5 + 5 × 2 + 5 × 3 + … + 5 × n
= 5 × (1 + 2 + 3 + … + n)
= 5 × n × (n + 1) / 2,
```
which is O(n^2).

Solutions:

1. If you did want your string to be mutable, you can convert it to a char array.
```
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String s = "Hello World";
        char[] str = s.toCharArray();
        str[5] = ',';
        System.out.println(str);
    }
}
```

2.  If you have to concatenate strings often, it will be better to use some other data structures like `StringBuilder`. The below code runs in `O(n)` complexity.
```
// "static void main" must be defined in a public class.
public class Main {
      public static void main(String[] args) {
        int n = 10000;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append("hello");
        }
        String s = str.toString();
      }
}
```

### Q1
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
```
Input: a = "11", b = "1"
Output: "100"
```
Example 2:
```
Input: a = "1010", b = "1011"
Output: "10101"
```

### Q2
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
```
Input: haystack = "hello", needle = "ll"
Output: 2
```
Example 2:
```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```
Clarification:

What should we return when `needle` is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when `needle` is an empty string. This is consistent to C's strstr() and Java's indexOf().

### Q3

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
```
Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```
Note:

All given inputs are in lowercase letters `a-z`.

## Two-pointer Technique - Scenario I

In the previous chapter, we solve some problems by iterating the array. Typically, we only use one pointer starting from the first element and ending at the last one to do iteration. However, sometimes, we might need to use `two pointers at the same time` to do the iteration.

### An Example
Let's start with a classic problem:

```
Reverse the elements in an array.
```

The idea is to swap the first element with the end, advance to the next element and swapping repeatedly until it reaches the middle position.

We can use two pointers at the same time to do the iteration: one starts from the first element and another starts from the last element. Continue swapping the elements until the two pointers meet each other.

### Q4
Write a function that takes a string as input and returns the string reversed.

Example 1:
```
Input: "hello"
Output: "olleh"
```
Example 2:
```
Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"
```

### Q5
Given an array of `2n` integers, your task is to group these integers into `n` pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
```
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
```
Note:
1. `n` is a positive integer, which is in the range of [1, 10000].
2. All the integers in the array will be in the range of [-10000, 10000].

### Q6
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

## Two-pointer Technique - Scenario II

Sometimes, we can use two pointers with `different steps` to solve problems.

### An Example
Let's start with another classic problem:
```
Given an array and a value, remove all instances of that value in-place and return the new length.
```
If we don't have the limitation of space complexity, it will be easier. We can initialize a new array to store the answer. Iterate the original array and add the element to the new array if the element is not equal to the given target value.

Actually, it is equivalent to using two pointers, one is used for the iteration of the original array and another one always points at the last position of the new array.

This is a very common scenario of using the two-pointer technique when you need:
```
One slow-runner and one fast-runner at the same time.
```
The key to solving this kind of problems is to
```
Determine the movement strategy for both pointers.
```
Similar to the previous scenario, you might sometimes need to sort the array before using the two-pointer technique. And you might need a greedy thought to determine your movement strategy.

### Q7
Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:
```
Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
```

Example 2:
```
Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
```
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:
```
// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```

### Q8
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
```
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
    ```
Note:

* The input array will only contain 0 and 1.
* The length of input array is a positive integer and will not exceed 10,000

### Q9
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:
```
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
```
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

## Q10 [Leetcode 4] Median of Two Sorted Arrays
[link](https://leetcode.com/problems/median-of-two-sorted-arrays/description/)


## Q11 [Leetcode 11] Container With Most Water
[link](https://leetcode.com/problems/container-with-most-water/description/)


## Q12 [Leetcode 561] Array Partition I

This one is same as Q5.
[link](https://leetcode.com/problems/array-partition-i/description/)

## Q13 [Leetcode 53] Maximum Subarray

[link](https://leetcode.com/problems/maximum-subarray/description/)

## Q14 [Leetcode 126] Today's challenge - Word Ladder

[link](https://leetcode.com/problems/word-ladder-ii/description/)
