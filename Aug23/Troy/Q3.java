class Solution {
    class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
        String word = new String("");
    }

    TrieNode root;
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for(String s : dict) {
            TrieNode cur = root;
            char[] charArray = s.toCharArray();
            for(int i = 0; i < charArray.length; i++) {
                if (!cur.map.containsKey(charArray[i])) {
                    cur.map.put(charArray[i], new TrieNode());
                }
                cur = cur.map.get(charArray[i]);
            }
            cur.isWord = true;
            cur.word = s;
        }

        String[] senArray = sentence.split("\\s+");
        for(int i = 0 ; i < senArray.length; i++) {
            TrieNode cur = root;
            char[] charArray = senArray[i].toCharArray();

            boolean found = false;
            for(int j = 0; j < charArray.length; j++) {
                if (cur.isWord){
                    found = true;
                    break;
                } else if (!cur.map.containsKey(charArray[j])) {
                    break;
                } else {
                    cur = cur.map.get(charArray[j]);
                }
            }
            if (found) senArray[i] = cur.word;
        }

        return String.join(" ", senArray);
    }
}
