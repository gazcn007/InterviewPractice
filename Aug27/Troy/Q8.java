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
    // Iteractive solution
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(queue.size() > 0) {
                int tmp = queue.size();
                List<Integer> level = new ArrayList<>();
                while(tmp > 0) {
                    Node cur = queue.poll();
                    level.add(cur.val);
                    for(Node n : cur.children) {
                        queue.add(n);
                    }
                    tmp--;
                }
                result.add(level);
            }
        }
        return result;
    }
}
