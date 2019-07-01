class Solution {
    // This one comes from yesterday and the mistake I made was
    // overlooked the limited optimization that can be brought
    // by using Trie. I thought after optimization, time complexity
    // can be reduced to less than O(n^2), but it seems
    // Leetcode does not care about O(n^2) time complexity and
    // can accept it if the constant term is small.
    class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
        int idx = 0;
    }

    TrieNode reverseRoot;
    public List<List<Integer>> palindromePairs(String[] words) {
        reverseRoot = new TrieNode();
        // Construct the Trie
        for(int j = 0; j < words.length; j++) {
            String s = words[j];
            char[] charArray = s.toCharArray();
            TrieNode reverseCur = reverseRoot;
            for(int i = charArray.length - 1; i >= 0; i--) {
                if (!reverseCur.map.containsKey(charArray[i])) reverseCur.map.put(charArray[i], new TrieNode());
                reverseCur = reverseCur.map.get(charArray[i]);
            }
            reverseCur.isWord = true;
            reverseCur.idx = j;
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            char[] charArray = words[i].toCharArray();
            TrieNode cur = reverseRoot;
            // Using Trie to eliminate impossible word pairs
            HashSet<Integer> possibleIdxs = new HashSet<>();
            for(int j = 0; j < charArray.length; j++) {
                if (cur.isWord) possibleIdxs.add(cur.idx);
                if (cur.map.containsKey(charArray[j]) ) {
                    cur = cur.map.get(charArray[j]);
                } else {
                    break;
                }
            }
            possibleIdxs.addAll(possibleIdxs(cur));
            for(int idx : possibleIdxs) {
                // Here we only look at possibleIdxs, but in
                // worst case possibleIdxs may be all idexes. 
                if (idx != i && isPalindrome(words[i] + words[idx])){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(idx);
                    result.add(tmp);
                }
            }
        }
        return result;
    }

    public List<Integer> possibleIdxs(TrieNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TrieNode> stack = new Stack<>();
        stack.add(node);
        while(stack.size() > 0) {
            TrieNode cur = stack.pop();
            if (cur.isWord) result.add(cur.idx);
            for(TrieNode t : cur.map.values()) {
                stack.add(t);
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        StringBuilder tmp = new StringBuilder(s);
        return tmp.reverse().toString().equals(s);
    }
}
