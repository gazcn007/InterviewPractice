import java.util.Hashtable;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Q3{
	public static void main(String[] args){
		ListNode head = new ListNode(5);
		head.next = new ListNode(6);
		head.next.next = new ListNode(7);
        ListNode a1 = new ListNode(2);
        a1.next = new ListNode(3);
        a1.next.next = new ListNode(4);
        a1.next.next.next=head;
        ListNode b1 = new ListNode(1);
        b1.next = new ListNode(2);
        b1.next.next=head;

        System.out.println(new Q3().hasCycle(a1,b1).toString());
	}

	public ListNode hasCycle(ListNode a1, ListNode b1) {
        Hashtable<Integer, ListNode> ref = new Hashtable<Integer, ListNode>();
        ListNode current = a1;
        ListNode refInHash;
        while(current!=null){
            ref.put(current.hashCode(), current);
            current = current.next;
        }
        current = b1;
        while(current!=null){
            refInHash = ref.get(current.hashCode());
            if(refInHash!=null){
                return refInHash;
            }
            current = current.next;
        }
        return null; 
    }
}