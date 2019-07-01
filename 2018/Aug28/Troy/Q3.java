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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder tmp = new StringBuilder();
        if (root == null) return tmp.toString();
        if (root.children == null || root.children.size() == 0) return Integer.toString(root.val);
        tmp.append("[ ");
        tmp.append(Integer.toString(root.val));
        tmp.append(" [");
        for(Node n : root.children) {
            tmp.append(" ");
            tmp.append(serialize(n));
        }
        tmp.append(" ]");
        tmp.append(" ]");
        return tmp.toString();

    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.equals("")) return null;
        String[] ss = data.split(" ");
        if (ss.length == 1) return new Node(Integer.parseInt(ss[0]), new ArrayList<>());

        Node result = new Node(Integer.parseInt(ss[1]), new ArrayList<>());
        for(int i = 3; i < ss.length;i++) {
            if (ss[i].equals("[")) {
                int count = 1;
                for(int j = i + 1; j < ss.length; j++) {
                    if (ss[j].equals("]")) {
                        count--;
                    } else if (ss[j].equals("[")) {
                        count++;
                    }
                    if (count == 0) {
                        result.children.add(deserialize(String.join(" ", Arrays.copyOfRange(ss, i, j + 1))));
                        i = j;
                        break;
                    }
                }

            } else if (!ss[i].equals("]")) {
                result.children.add(new Node(Integer.parseInt(ss[i]), new ArrayList<>()));
            }
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
