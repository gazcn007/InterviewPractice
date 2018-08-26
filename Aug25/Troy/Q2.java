class Solution {
    // First attempt
    private boolean valid = true;
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            dfs(root);
            System.out.println(valid);
            return valid;
        }
        return true;
    }

    public List<Integer> dfs(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node.left == null && node.right == null) {
            result.add(node.val);
            result.add(node.val);
            return result;
        } else if (node.right == null) {
            List<Integer> tmpLeft = dfs(node.left);
            int max = tmpLeft.get(0);
            int min = tmpLeft.get(1);
            if (max >= node.val) valid = false;
            result.add(node.val);
            result.add(min);
            return result;
        } else if (node.left == null) {
            List<Integer> tmpRight = dfs(node.right);
            int max = tmpRight.get(0);
            int min = tmpRight.get(1);
            if (min <= node.val) valid = false;
            result.add(max);
            result.add(node.val);
            return result;
        } else {
            List<Integer> tmpLeft = dfs(node.left);
            List<Integer> tmpRight = dfs(node.right);
            int maxLeft = tmpLeft.get(0);
            int minLeft = tmpLeft.get(1);
            int maxRight = tmpRight.get(0);
            int minRight = tmpRight.get(1);
            if (maxLeft >= node.val || minRight <= node.val) valid = false;
            result.add(maxRight);
            result.add(minLeft);
            return result;
        }

    }

}

class Solution {
    // Second attemp use LDR traverse which has cleaner code

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int lastSeenVal = Integer.MIN_VALUE;
        boolean start = true;
        while(stack.size() > 0 || cur != null) {
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            // System.out.println(cur.val);
            if (cur.val <= lastSeenVal && !start) return false;
            lastSeenVal = cur.val;
            cur = cur.right;
            start = false;
        }
        return true;
    }


}
