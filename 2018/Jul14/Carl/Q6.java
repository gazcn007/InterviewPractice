/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
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


class Q6 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head = rotateRight(head, 2);
        head.print();
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0||head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        int length = 1;
        while(k>0){
            if(fast.next==null){
                fast = head;//fast = 1
                k = k%length;
            } else {
                fast = fast.next;
                length++;
            }
            k= k-1;
        }
        if(fast==slow) return head;
        while(fast.next!=null){
            fast = fast.next;//2
            slow = slow.next;//1
        }
        ListNode slowNext = slow.next;
        // slow will become our new head;
        // fast will link to the current head;
        fast.next = head;
        head = slowNext;
        slow.next = null;
        return head;
    }
}
