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
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		print(head);
		head = solution(head);
		print(head);
	}


	public static ListNode solution(ListNode node){
		ListNode prev = null;
		ListNode current = node;
		ListNode nextNode = new ListNode(0);
		while(current!=null){
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode; 
		}
		return prev;
	}

	public static void print(ListNode head){
		ListNode current = head;
		while(current!=null){
			System.out.println(current.val);
			current = current.next;
		}
	}

}