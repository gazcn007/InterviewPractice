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

public class Q1{

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		// head.next = new ListNode(2);
		// head.next.next = new ListNode(3);
		print(head);
		head = solution(head, 10);
		print(head);
	}

	//all cases
	// case 1: list has 1 element , num == 1, return null
	// case 2: list has > 1 element, 0 < num < length of the listNode - 1
	// case 3: list has > 1 element, num == length of the listNode -1
	// case 4: list has > 1 element, num >= length of the listNode

	public static ListNode solution(ListNode node, int num){
		ListNode slowPointer = node;
		ListNode fastPointer = node;
		while(num>0){
			fastPointer=fastPointer.next;
			num=num-1;
			if(fastPointer==null&&num==0){//base case: 1 element, num ==1
				return node.next;
			} else if (fastPointer==null&&num>0){ // case 3
				return node;
			}
		}
		//case 2
		while(fastPointer!=null){
			fastPointer = fastPointer.next;
			if(fastPointer==null){
				slowPointer.next = slowPointer.next.next;
				return node;
			}
			slowPointer = slowPointer.next;
		}
		return null;
	}

	// public static int solution_recursive(ListNode node, int num){ // returns you
	// 	if(node==null){
	// 		return 0; 
	// 	} else {
	// 		int count = solution(node.next, num);
	// 		if(count == num){
	// 			node.next = node.next.next;
	// 		} else {
	// 			return count+1;
	// 		}
	// 	}
	// 	return 0;
	// }

	// public static int solution_static_distance()

	public static void print(ListNode head){
		ListNode current = head;
		while(current!=null){
			System.out.println(current.val);
			current = current.next;
		}
	}

}