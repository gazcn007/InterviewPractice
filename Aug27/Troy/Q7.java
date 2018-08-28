/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    // Iterative solution
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        HashSet<Node> visited = new HashSet<>();
        stack.push(root);
        while(stack.size() > 0) {
            Node cur = stack.peek();
            if (cur != null) {
               if (cur.children == null || cur.children.size() == 0 || visited.contains(cur)) {
                    result.add(cur.val);
                    stack.pop();
                } else {
                    for(int i = cur.children.size() - 1; i >= 0; i--) {
                        stack.add(cur.children.get(i));
                    }
                   visited.add(cur);
                }
            } else {
                break;
            }
        }
        return result;
    }
}
