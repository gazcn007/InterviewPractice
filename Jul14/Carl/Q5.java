/**
 * //Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
};

public class Q5 {
    public static void main(String[]args){
        RandomListNode head = new RandomListNode(1);
        head.next = head;
        while()
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode current = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while(current!=null){
            map.put(current, new RandomListNode(current.label));
            current = current.next;
        }
        current = head;
        while(current!=null){
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}
