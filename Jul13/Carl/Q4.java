
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

public class Q4{

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		// head.next.next.next = new ListNode(4);
		// head.next.next.next.next = new ListNode(5);
		// head.next.next.next.next.next = new ListNode(6);
		// head.next.next.next.next.next.next = new ListNode(7);
		head.print();
		head = solution(head);
		head.print();
		// print(head);
	}

	// nextOdd -> always points to the next odd number
	// evenOdd -> always points to the next even number == the previous node of nextOdd
	// temp -> used to do the swap

	// [1,2,3,4] -> [1,3,2,4]
	public static ListNode solution_complicated(ListNode node){
		if(node==null||node.next==null){
			return node;
		}
		ListNode current = node; //1
		ListNode nextEven = node.next;//2
		ListNode nextOdd = node.next.next;//3
		ListNode temp = new ListNode();
		ListNode prevTemp = new ListNode();

		while(nextOdd!=null){
			// cache saves current
			temp = nextOdd; // 3
			prevTemp = nextEven; // 2

			if(nextOdd.next!=null&&nextOdd.next.next!=null){
				nextOdd=nextOdd.next.next;
				nextEven=nextEven.next.next;
			} else {
				nextOdd = null;
			}

			// pop nextOdd
			prevTemp.next = temp.next; //2->4

			// insert nextOdd
			temp.next = current.next; // 3->2
			current.next = temp; // 1->3

			current=current.next;
			
		}
		return node;
	}

	public static ListNode solution(ListNode node){
		if(node==null||node.next==null){
			return node;
		}
		ListNode odd = node, even = odd.next, evenHead = even;
		while(even!=null&&even.next!=null){
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return node;
	}
}