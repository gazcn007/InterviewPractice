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
    public int sumNumbers(TreeNode root) {
        int result = 0;
        if (root == null) return result;
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);
        Stack<List<Integer>> numberStack = new Stack<>();
        numberStack.push(new ArrayList<>());
        while(treeStack.size() > 0) {
            TreeNode cur = treeStack.pop();
            List<Integer> left = new ArrayList<>();
            left.addAll(numberStack.pop());
            left.add(cur.val);
            List<Integer> right = new ArrayList<>();
            right.addAll(left);
            if (cur.left != null && cur.right != null) {
                treeStack.add(cur.left);
                treeStack.add(cur.right);
                numberStack.add(left);
                numberStack.add(right);
            } else if (cur.left == null && cur.right != null) {
                treeStack.add(cur.right);
                numberStack.add(right);
            } else if (cur.left != null && cur.right == null) {
                treeStack.add(cur.left);
                numberStack.add(left);
            } else {
                result += parseInt(left);
            }
        }
        return result;
    }

    public int parseInt(List<Integer> list) {
        int result = 0;
        int digits = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            result += digits * list.get(i);
            digits *= 10;
        }
        return result;
    }
}
