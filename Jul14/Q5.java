/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode resultList = new RandomListNode(head.label);
        RandomListNode resultHead = resultList;
        RandomListNode temp = head;
        // Detect cycle first
        RandomListNode cycleStart = detectCycle(head);
        boolean firstPass = true;
        while(head.next != null){
            if (cycleStart != null && head.next.label == cycleStart.label && !firstPass) {
                break;
            } else {
                resultHead.next = new RandomListNode(head.next.label);
                resultHead = resultHead.next;
                if (cycleStart != null && head.next.label == cycleStart.label) {
                    firstPass =false;
                }
                head = head.next;
            }
        }

        firstPass = true;
        head = temp;
        resultHead = resultList;
        while(head != null) {
            if (cycleStart != null && head.label == cycleStart.label && !firstPass) {
                break;
            } else {
                if (head.random != null) {
                    resultHead.random = getNodeWithLabel(resultList, head.random.label);
                } else {
                    resultHead.random = null;
                }
                resultHead = resultHead.next;
                if (cycleStart != null && head.label == cycleStart.label) {
                    firstPass =false;
                }
                head = head.next;
            }
        }
        return resultList;
    }

    public RandomListNode detectCycle(RandomListNode head) {
        RandomListNode slow = head;
        RandomListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                RandomListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    public RandomListNode getNodeWithLabel(RandomListNode head, int label) {
        while(head != null) {
            if (head.label == label) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
