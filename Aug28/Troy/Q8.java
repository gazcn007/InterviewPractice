/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // Iterasive solution
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size > 0) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    level.add(null);
                } else {
                    level.add(cur.val);
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
                size--;
            }
            List<Integer> reverse = new ArrayList<>();
            for(int i = level.size() - 1; i >= 0; i--) {
                reverse.add(level.get(i));
            }
            if (!level.equals(reverse)) return false;
        }
        return true;
    }
}

class Solution {
    // Recursive solution
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }
}
