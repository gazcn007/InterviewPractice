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

public class Q2{

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        // l1.next = new ListNode(2);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(4);
        // head.next.next.next.next.next = new ListNode(5);
        // l1.print();
        // l2.print();
        ListNode head2 = addTwoNumbers(l1, l2);
        head2.print();
    }

    public static void tricky(ListNode arg1, ListNode arg2){
        arg1.val = 100;
        ListNode head = new ListNode(2), temp = head;
        head.print();
        temp.print();
        head = new ListNode(3);
        head.print();
        temp.print();
        arg2 = temp;
        arg1 = arg1.next;
    }

    public static ListNode temp(ListNode h){
        ListNode prev = null;
        ListNode current = h;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0), current = result; //@重点：永远先declare head，current point to head，head保持静止
        int val1, val2, sum, carry=0; 

        while(true){
            val1 = (l1==null) ? 0 : l1.val;
            val2 = (l2==null) ? 0 : l2.val;
            sum = val1+val2+carry;
            if(sum>=10){
                carry = 1;
                current.val = sum%10;
            } else {
                carry = 0;
                current.val = sum;
            }
            l1 = l1==null ? null:l1.next;
            l2 = l2==null ? null:l2.next;
            if(l1!=null||l2!=null){
                current.next = new ListNode(0);
                current = current.next;
            } else {
                break;
            }
        }
        if(carry!=0){
            current.next = new ListNode(1);
        }
        return result;
    }

}