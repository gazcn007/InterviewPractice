/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode{
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Q2{
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = head;
	}

	public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while(true){
        	if(slowPointer == fastPointer){
        		return slowPointer;
        	}
        	if(slowPointer.next!=null&&fastPointer.next!=null&&fastPointer.next.next!=null){
        		slowPointer = slowPointer.next;
        		fastPointer = fastPointer.next.next;
        	} else {
        		return null; 
        	}
        }
    }
}