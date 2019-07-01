
class ListNode{
	int val;
	ListNode next;
	ListNode(){}
	ListNode(int x) {
		val = x;
		next = null;
	}
	void print(){
		if(this.next!=null){
			System.out.print(this.val+",");
			this.next.print();
		} else {
			System.out.print(this.val);
			System.out.println();
		}
	}
}

public class Q5{

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		// head.next.next.next = new ListNode(4);
		// head.next.next.next.next = new ListNode(3);
		// head.next.next.next.next.next = new ListNode(1);
		// head.next.next.next.next.next.next = new ListNode(1);
		// head.print();
		boolean isPalindrome = isPalindrome(head);
		System.out.println(isPalindrome);
		head.print();
	}

	/* 
	case odd -> fastPointer.next == null:
		reverse slowPointer + 1 to the end of the list
		compare reversed with first to slowpointer - 1
	case even -> fastPointer.next != null && fastPointer.next.next == null
		reverse slowerPointer + 1 ...
		compare reversed with first to slowPointer
	*/ 

	public static boolean isPalindrome(ListNode node){
		if(node==null||node.next==null){
			return true;
		} else if (node.next.next==null){
			return node.val == node.next.val;
		}

		ListNode slowPointer = node;
		ListNode fastPointer = node;
		// find the middle value
		while(true){
			if(fastPointer.next == null || fastPointer.next.next == null){
				slowPointer = slowPointer.next;
				break;
			}
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		//reverse
		ListNode reversedNode = new ListNode(slowPointer.val);
		ListNode reversedHead = reversedNode;
		while(slowPointer.next!=null){
			slowPointer = slowPointer.next;
			reversedHead = new ListNode(slowPointer.val);
			reversedHead.next = reversedNode;
			reversedNode = reversedHead;
		}

		reversedNode = reversedHead;
		slowPointer = node;
		//compare
		while(reversedNode!=null){
			if(reversedNode.val!=slowPointer.val){
				return false;
			}
			reversedNode = reversedNode.next;
			slowPointer = slowPointer.next;
		}

		return true;
	}
}