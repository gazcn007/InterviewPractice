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
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for(Node n : root.children) {
            int childDepth = maxDepth(n);
            depth = childDepth > depth ? childDepth : depth;
        }
        return depth + 1;
    }
}
