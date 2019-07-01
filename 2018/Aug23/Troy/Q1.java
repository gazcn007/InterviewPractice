class Trie {
    // My solution
    private HashMap<Character, Trie> map;
    boolean isWord;
    /** Initialize your data structure here. */
    public Trie() {
        map = new HashMap<>();
        isWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.equals("")) {
            isWord = true;
        } else {
            if (!map.containsKey(word.charAt(0))) {
                map.put(word.charAt(0), new Trie());
            }
            map.get(word.charAt(0)).insert(word.substring(1));
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.equals("")) return isWord;
        if (!map.containsKey(word.charAt(0))) return false;

        return map.get(word.charAt(0)).search(word.substring(1));
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.equals("")) return true;
        if (!map.containsKey(prefix.charAt(0))) return false;

        return map.get(prefix.charAt(0)).startsWith(prefix.substring(1));
    }
}


class Trie {
    // Given solution
    class TrieNode {
        public boolean isWord;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null){
                // insert a new node if the path does not exist
                cur.childrenMap.put(c, new TrieNode());
            }
            cur = cur.childrenMap.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0;i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return true;
    }
}
