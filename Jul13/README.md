## Leetcode linked list (two pointer technique) 2/2:

For the Q3 from yesterday (find intersection between two LL), I confused the concept of intersection with the concept of subset: specifically, the solution took advantage of the fact that if `A` intersects `B`, they have to share same end LL with each other (but not the case if `A` is a subset of `B`). Due to this property, we can be certain that using two pointer to counteract the difference between `A` and `B` by aligning their ends will give us the intersection node.

Pay more attention to the hidden assumptions in the question next time maybe.
### Q1
[link](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

Given a linked list, remove the n-th node from the end of list and return its head.

Example:
```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

Could you do this in one pass?

### Summary

It is similar to what we have learned in an array. But it can be trickier and error-prone. There are several things you should pay attention:

- Always examine if the node is null before you call the next field.

Getting the next node of a null node will cause the null-pointer error. For example, before we run fast = fast.next.next, we need to examine both fast and fast.next is not null.

- Carefully define the end conditions of your loop.

Run several examples to make sure your end conditions will not result in an endless loop. And you have to take our first tip into consideration when you define your end conditions.

## Classic Problems with LL

### Q2
[leetcode link](https://leetcode.com/problems/reverse-linked-list/description/)

Reverse a singly linked list.

Example:
```
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

_@Troy_这个可以inplace完成的, 参考[link](https://algorithms.tutorialhorizon.com/reverse-a-linked-list/)

### Q3

[leetcode link](https://leetcode.com/problems/remove-linked-list-elements/description/)

Remove all elements from a linked list of integers that have value val.

Example:
```
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
```


### Q4

[leetcode link](https://leetcode.com/problems/odd-even-linked-list/description/)

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:
```
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
```

Example 2:
```
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
```

Note:

- The relative order inside both the even and odd groups should remain as it was in the input.
- The first node is considered odd, the second node even and so on ...

### Q5

[leetcode list](https://leetcode.com/problems/palindrome-linked-list/)
Given a singly linked list, determine if it is a palindrome.

Example 1:
```
Input: 1->2
Output: false
```
Example 2:
```
Input: 1->2->2->1
Output: true
```
Could you do it in O(n) time and O(1) space?

### Summary

We have provided several exercises for you. You might have noticed the similarities between them. Here we provide some tips for you:



- Going through some test cases will save you time.

It is not easy to debug when using a linked list. Therefore, it is always useful to try several different examples on your own to validate your algorithm before writing code.



- Feel free to use several pointers at the same time.

Sometimes when you design an algorithm for a linked-list problem, there might be several nodes you want to track at the same time. You should keep in mind which nodes you need to track and feel free to use several different pointers to track these nodes at the same time.

If you use several pointers, it will be better to give them suitable names in case you have to debug or review your code in the future.



- In many cases, you need to track the previous node of the current node.

You are not able to trace back the previous node in a singly linked list. So you have to store not only the current node but also the previous node. This is different in a doubly linked list which we will cover in the later chapter.
