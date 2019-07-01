class Solution {
    // First accepted attempt
    // Tried to use inorderTracersal of subtree as a signature
    // of the subtree and use it to find duplicate subtrees.
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<List<Integer>, Integer> hashMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> result = new ArrayList<>();
        if (root != null) {
            TreeNode cur = root;
            while(stack.size() > 0 || cur != null) {
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                List<Integer> signature = inorderTraversal(cur);
                System.out.println(signature);
                if (hashMap.containsKey(signature) && hashMap.get(signature) == 1) {
                    result.add(cur);
                    hashMap.put(signature, 2);
                } else if (!hashMap.containsKey(signature)) {
                    hashMap.put(signature, 1);
                }
                cur = cur.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> branch = new Stack<>();
        if (root != null) {
            TreeNode cur = root;
            while(stack.size() > 0 || cur != null) {
                while(cur != null) {
                    stack.push(cur);
                    branch.push(-1);
                    cur = cur.left;
                }
                cur = stack.pop();
                result.add(branch.pop());
                result.add(cur.val);

                cur = cur.right;
                branch.push(1);
            }
        }

        return result;
    }
}


class Solution {
    // Far better solution, only traverse the tree once with
    // DFS encoding
    private HashMap<String, Integer> hashMap = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfsEncoding(root);
        return result;
    }

    public String dfsEncoding(TreeNode node) {
        if (node == null) return "";

        StringBuilder tmp = new StringBuilder();
        String left = dfsEncoding(node.left);
        String right = dfsEncoding(node.right);

        tmp.append(node.val).append("#").append(left).append("#").append(right);
        String encoding = tmp.toString();
        if (hashMap.containsKey(encoding) && hashMap.get(encoding) == 1) {
            result.add(node);
            hashMap.put(encoding, 2);
        } else if (!hashMap.containsKey(encoding)) {
            hashMap.put(encoding, 1);
        }
        return encoding;
    }
}
