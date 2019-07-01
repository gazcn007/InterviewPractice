/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder tmp = new StringBuilder();
        if (root == null) return "null";
        tmp.append("[ ");
        tmp.append(Integer.toString(root.val));
        tmp.append(" ");
        tmp.append(serialize(root.left));
        tmp.append(" ");
        tmp.append(serialize(root.right));
        tmp.append(" ]");
        return tmp.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0 || data.equals("null")) return null;
        String[] split = data.split(" ");
        int val = Integer.parseInt(split[1]);
        TreeNode node = new TreeNode(val);
        int start = 2;
        int end = 3;
        if (!split[2].equals("null")) {
            Stack<String> stack = new Stack<>();
            stack.push(split[2]);
            for(; end < split.length; end++) {
                if (stack.size() == 0) break;
                if (split[end].equals("]")) {
                    stack.pop();
                } else if (split[end].equals("[")) {
                    stack.push("[");
                }
            }
        }
        node.left = deserialize(String.join(" ", Arrays.copyOfRange(split, start, end)));
        start = end;
        node.right = deserialize(String.join(" ", Arrays.copyOfRange(split, start, split.length - 1)));
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
