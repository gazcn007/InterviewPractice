class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode result = null;
        while(stack.size() > 0 || cur != null) {
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (cur.val > p.val) {
                result = cur;
                break;
            }
            cur = cur.right;
        }
        return result;
    }
}
