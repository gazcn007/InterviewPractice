class WordDictionary {
    class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
        String word = new String();
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        char[] charArray = word.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if (!cur.map.containsKey(charArray[i])) cur.map.put(charArray[i], new TrieNode());
            cur = cur.map.get(charArray[i]);
        }
        cur.isWord = true;
        cur.word = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

        char[] charArray = word.toCharArray();
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i = 0; i < charArray.length; i++) {
            int tmp = queue.size();
            while(tmp > 0) {
                TrieNode cur = queue.poll();
                if (charArray[i] == '.') {
                    for(TrieNode t : cur.map.values()) {
                        queue.add(t);
                    }
                } else if (cur.map.containsKey(charArray[i])) {
                    queue.add(cur.map.get(charArray[i]));
                }
                tmp--;
            }
        }
        while(queue.size() > 0) {
            TrieNode t = queue.poll();
            if (t.isWord) return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
