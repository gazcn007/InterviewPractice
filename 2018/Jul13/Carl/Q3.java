/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Q3{

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		print(head);
		head = solution(head, 5);
		print(head);
	}

	// Case 1 : first element has the same value as num, delete head
	// Case 2 : middle elements have the same vlaues as num, delete them by connecting prev.next = current.next;
	// Case 3 :

	public static ListNode solution(ListNode node, int num){
		ListNode prev = null;
		ListNode newHead = node;
		ListNode current = node;
		while(current!=null){
			if(current.val==num&&prev==null){ // case 1
				newHead=newHead.next;
			} else if (current.val==num&&prev!=null){
				prev.next = current.next;
			} else {
				prev = current;
			}
			current = current.next;
		}
		return newHead;
	}

	public static void print(ListNode head){
		ListNode current = head;
		while(current!=null){
			System.out.println(current.val);
			current = current.next;
		}
	}

}