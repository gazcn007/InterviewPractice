## Leetcode linked list (two pointer technique) 2/2:

For the Q3 from yesterday (find intersection between two LL), I confused the concept of intersection with the concept of subset: specifically, the solution took advantage of the fact that if `A` intersects `B`, they have to share same end LL with each other (but not the case if `A` is a subset of `B`). Due to this property, we can be certain that using two pointer to counteract the difference between `A` and `B` by aligning their ends will give us the intersection node.

Pay more attention to the hidden assumptions in the question next time maybe.
### Q1
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
