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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(stack.size() > 0) {
            Node cur = stack.pop();
            if (cur != null) {
                result.add(cur.val);
                for(int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
        }
        return result;
    }
}
