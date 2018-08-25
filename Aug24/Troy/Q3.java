class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
        String word;
    }
    TrieNode root;
    public List<List<String>> wordSquares(String[] words) {
        root = new TrieNode();
        for(String s: words) {
            char[] charArray = s.toCharArray();
            TrieNode cur = root;
            for(int i = 0; i < charArray.length; i++) {
                if (!cur.map.containsKey(charArray[i])) cur.map.put(charArray[i], new TrieNode());
                cur = cur.map.get(charArray[i]);
            }
            cur.isWord = true;
            cur.word = s;
        }

        return dfs(new ArrayList<>());
    }

    public List<List<String>> dfs(List<String> wordSquares) {
        List<List<String>> result = new ArrayList<>();
        TrieNode cur = root;
        if (wordSquares.size() > 0) {
            char[] charArray = wordSquares.get(0).toCharArray();
            if (wordSquares.size() == charArray.length) {
                result.add(new ArrayList<>(wordSquares));
                return result;
            } else {
                // System.out.println(wordSquares);

                for(int i = 0; i < wordSquares.size(); i++){
                    charArray = wordSquares.get(i).toCharArray();
                    char c = charArray[wordSquares.size()];
                    // System.out.println(c);
                    if (!cur.map.containsKey(c)) return result;
                    cur = cur.map.get(c);
                }
                // System.out.println(possibleNextWords(cur));
            }
        }


        List<String> nextWords = possibleNextWords(cur);
        // System.out.println(wordSquares);
        for (String w : nextWords) {
            wordSquares.add(w);
            result.addAll(dfs(wordSquares));
            wordSquares.remove(wordSquares.size() - 1);
        }
        return result;
    }

    public List<String> possibleNextWords(TrieNode pointer) {
        Stack<TrieNode> stack = new Stack<>();
        stack.push(pointer);
        List<String> result = new ArrayList<>();
        while(stack.size() > 0) {
            TrieNode cur = stack.pop();
            if (cur.isWord) result.add(cur.word);
            for(TrieNode t: cur.map.values()) {
                stack.add(t);
            }
        }
        return result;
    }
}
