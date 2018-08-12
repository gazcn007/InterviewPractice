import java.util.Stack;
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val){ val = _val;}


    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
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
};


class Q3 {
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        head.next.next.child = new Node(7);
        head.next.next.child.next = new Node(8);
        head.next.next.child.next.child = new Node(11);
        head.next.next.child.next.child.next = new Node(12);
        head.next.next.child.next.next = new Node(9);
        head.next.next.child.next.next.next = new Node(10);

        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head = flatten(head);
        head.print();

        // @test to show the java pass by reference 
        // Stack<Integer> tail = new Stack<Integer>();
        // findTail(head, tail);
        // System.out.println("yes"+tail.pop()+tail.pop());
    }

    // if current node doesn't have child, moves on
    // if current node has child, flatten tha child linked list:
        // connect the flattened child list with current
        // grab the last of the flattened child list, and point that to the next element of current


    public static Node findTail(Node head, Stack<Integer> tail) {
        Node current = head;
        while(current!=null){
            tail.push(current.val);
            current = current.next;
        }
        return head;
    }

    public static Node flatten(Node head) {
        Node current = head;
        while(current!=null){
            Node nextOfCurrent = current.next;
            if(current.child!=null){
                Node returnedList = flatten(current.child);
                current.next = returnedList;
                returnedList.prev = current;
                Node iterator = current.next;
                while(iterator.next!=null){
                    iterator = iterator.next;
                }
                iterator.next = nextOfCurrent;
                if(nextOfCurrent!=null){
                    nextOfCurrent.prev = iterator;
                }
                current.child = null; //@坑 
            } 
            current = nextOfCurrent;
        }
        return head;
    }

}
