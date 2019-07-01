class MapSum {
    class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        int val = 0;
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        char[] charArray = key.toCharArray();

        for(int i = 0; i < charArray.length; i++) {
            if (!cur.map.containsKey(charArray[i])) {
                cur.map.put(charArray[i], new TrieNode());
            }
            cur = cur.map.get(charArray[i]);
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        // Or we can do the calculation inside insert.
        TrieNode cur = root;
        char[] charArray = prefix.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if (!cur.map.containsKey(charArray[i])) {
                return 0;
            } else {
                cur = cur.map.get(charArray[i]);
            }
        }
        int result = 0;
        Stack<TrieNode> stack = new Stack<>();
        stack.add(cur);
        while(stack.size() > 0) {
            cur = stack.pop();
            result += cur.val;
            for(TrieNode tmp : cur.map.values()) {
                stack.add(tmp);
            }
        }
        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
