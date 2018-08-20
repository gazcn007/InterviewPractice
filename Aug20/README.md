### Q1 [Leetcode 733] [Flood Fill](https://leetcode.com/problems/flood-fill)

An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
```
Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
```
Note:

* The length of image and image[0] will be in the range [1, 50].
* The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
* The value of each color in image[i][j] and newColor will be an integer in [0, 65535].

### Q2 [Leetcode 542] [01 Matrix](https://leetcode.com/problems/01-matrix)

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1:
```
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
```
Example 2:
```
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
```
Note:
* The number of elements of the given matrix will not exceed 10,000.
* There are at least one 0 in the given matrix.
* The cells are adjacent in only four directions: up, down, left and right.

### Q3 [Leetcode 841] [Keys and Rooms](https://leetcode.com/problems/keys-and-rooms)

There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:
```
Input: [[1],[2],[3],[]]
Output: true
Explanation:  
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
```
Example 2:
```
Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
```
Note:

* 1 <= rooms.length <= 1000
* 0 <= rooms[i].length <= 1000
* The number of keys in all rooms combined is at most 3000.

## LeetCode Hash Table [1/1] (Aug 20)

Hash Table is a data structure which organizes data using hash functions in order to support quick insertion and search.

There are two different kinds of hash tables: hash set and hash map.

* The `hash set` is one of the implementations of a set data structure to store no repeated values.
* The `hash map` is one of the implementations of a map data structure to store (key, value) pairs.
It is easy to use a hash table with the help of standard template libraries.

Most common languages such as Java, C++ and Python support both hash set and hash map.

By choosing a proper hash function, the hash table can achieve wonderful performance in both insertion and search.

### The Principle of Hash Table

As we mentioned in the introduction, `Hash Table` is a data structure which organizes data using hash functions in order to support `quick insertion and search`.

The key idea of Hash Table is to use a hash function to map keys to buckets. To be more specific,

1. When we insert a new key, the hash function will decide which bucket the key should be assigned and the key will be stored in the corresponding bucket;
2. When we want to search for a key, the hash table will use the same hash function to find the corresponding bucket and search only in the specific bucket.

An example:

![image](./Troy/hashfunction.png)
In the example, we use `y = x % 5` as our hash function. Let's go through the insertion and search strategies using this example:

1. Insertion: we parse the keys through the hash function to map them into the corresponding bucket.
  * e.g. 1987 is assigned to bucket 2 while 24 is assigned to bucket 4.
2. Search: we parse the keys through the same hash function and search only in the specific bucket.
  * e.g. if we search for 1987, we will use the same hash function to map 1987 to 2. So we search in bucket 2 and we successfully find out 1987 in that bucket.
  * e.g. if we search for 23, will map 23 to 3 and search in bucket 3. And We find out that 23 is not in bucket 3 which means 23 is not in the hash table.


Let's take a look at the operation "remove". After we find out the position of the element, we need to remove the element from the array list.

Let's assume that we are going to remove the ith element and the size of the array list is n.

The strategy used in the built-in function is to move all the elements after ith element one position forward. That is to say, you have to move n - i times. So the time complexity to remove an element from an array list will be O(n).

Consider different value of i. In average, we will move ((n - 1) + (n - 2) + ... + 1 + 0) / n = (n - 1) / 2 times.

Hopefully, there are two solutions to reduce the time complexity from O(n) to O(1).

1. Swap

There is a tricky strategy we can use. First, swap the element which we want to remove with the last element in the bucket. Then remove the last element. By this way, we successfully remove the element in O(1) time complexity.

2. Linked List

Another way to achieve this goal is to use a linked list instead of an array list. By this way, we can remove the element in O(1) time complexity without modifying the order in the list.

### Complexity Analysis
If there are `M` keys in total, we can achieve the space complexity of `O(M)` easily when using a hash table.

However, you might have noticed that the time complexity of hash table has a strong relationship with the design.

Most of us might have used an array in each bucket to store values in the same bucket. Ideally, the bucket size is small enough to be regarded as a constant. The time complexity of both insertion and search will be `O(1)`.

But in the worst case, the maximum bucket size will be `N`. And the time complexity will be `O(1)` for insertion but `O(N)` for search.

### The Principle of Built-in Hash Table

The typical design of built-in hash table is:

1. The key value can be any `hashable` type. And a value which belongs to a `hashable` type will have a `hashcode`. This code will be used in the mapping function to get the bucket index.
2. Each bucket contains an array to store all the values in the same bucket initially.
3. If there are too many values in the same bucket, these values will be maintained in a height-balanced binary search tree instead.

The average time complexity of both insertion and search is still `O(1)`. And the time complexity in the worst case is `O(logN)` for both insertion and search by using height-balanced BST. It is a trade-off between insertion and search.

### Q4 [Leetcode 217] [Contains Duplicate](https://leetcode.com/problems/contains-duplicate)

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:
```
Input: [1,2,3,1]
Output: true
```
Example 2:
```
Input: [1,2,3,4]
Output: false
```
Example 3:
```
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
```

### Q5 [Leetcode 136] [Single Number](https://leetcode.com/problems/single-number)

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
```
Input: [2,2,1]
Output: 1
```
Example 2:
```
Input: [4,1,2,1,2]
Output: 4
```
