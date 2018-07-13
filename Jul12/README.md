## Leetcode linked list:
Let's start with a classic problem:

```Given a linked list, determine if it has a cycle in it.```

You might have come up with the solution using the hash table. But there is a more efficient solution using the two-pointer technique. Try to think it over by yourself before reading the remaining content.

Imagine there are two runners with different speed. If they are running on a straight path, the fast runner will first arrive at the destination. However, if they are running on a circular track, the fast runner will catch up with the slow runner if they keep running.

That's exactly what we will come across using two pointers with different speed in a linked list:

```If there is no cycle, the fast pointer will stop at the end of the linked list.```

```If there is a cycle, the fast pointer will eventually meet with the slow pointer.```

So the only remaining problem is:

```What should be the proper speed for the two pointers?```

It is a safe choice to move the slow pointer one step at a time while moving the fast pointer two steps at a time. For each iteration, the fast pointer will move one extra step. If the length of the cycle is M, after M iterations, the fast pointer will definitely move one more cycle and catch up with the slow pointer.

```What about other choices? Do they work? Would they be more efficient?```

## Q1
Given a linked list, determine if it has a cycle in it.

## Q2

Given a linked list, return the node where the cycle begins. If there is no cycle, return `null`.

## Q3

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

- If the two linked lists have no intersection at all, return null.
- The linked lists must retain their original structure after the function returns.
- You may assume there are no cycles anywhere in the entire linked structure.
- Your code should preferably run in O(n) time and use only O(1) memory.
