// Given solution, which is similar idea of my solution but
// with cleaner code.
class TreeNode {
    int val;
    int count;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; count = 1;}
}

public class KthLargest {

    private TreeNode root;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int d : nums) root = insertIntoBST(root, d);
    }

    public int add(int val) {
        root = insertIntoBST(root, val);
        return searchKth(root, k);
    }

    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        else if (val < root.val)
            root.left  = insertIntoBST(root.left,  val);
        else if (val > root.val)
            root.right = insertIntoBST(root.right, val);

        root.count++;
        return root;
    }

    private int searchKth(TreeNode node, int cnt) {
        int leftCnt  = (node.left  == null) ? 0 : node.left.count;
        int rightCnt = (node.right == null) ? 0 : node.right.count;
        int duplicate = node.count - leftCnt - rightCnt;

        if (cnt <= rightCnt)
            return searchKth(node.right, cnt);
        else if (cnt <= duplicate + rightCnt)
            return node.val;
        else
            return searchKth(node.left, cnt - (duplicate + rightCnt));
    }
}
