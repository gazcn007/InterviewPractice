class Solution {
    // My solution
    // Should find a better way to handle visted nodes.
    class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
        String word;
    }
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for(String s : words) {
            TrieNode cur = root;
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (!cur.map.containsKey(charArray[i])) cur.map.put(charArray[i], new TrieNode());
                cur = cur.map.get(charArray[i]);
            }
            cur.isWord = true;
            cur.word = s;
        }
        HashSet<String> result = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                Queue<TrieNode> nodeQueue = new LinkedList<>();
                Queue<int []> idxQueue = new LinkedList<>();
                Queue<HashSet<String>> visitedQueue = new LinkedList<>();
                nodeQueue.add(root);
                idxQueue.add(new int[]{i, j});
                visitedQueue.add(new HashSet<>());
                while(nodeQueue.size() > 0) {
                    TrieNode cur = nodeQueue.poll();
                    int[] idx = idxQueue.poll();
                    HashSet<String> visited = visitedQueue.poll();
                    if (!visited.contains(idx[0] + "," + idx[1])) {
                        char c = board[idx[0]][idx[1]];
                        if (cur.map.containsKey(c)) {
                            visited.add(idx[0] + "," + idx[1]);
                            if (idx[0] - 1 >= 0) {
                                nodeQueue.add(cur.map.get(c));
                                idxQueue.add(new int[]{idx[0] - 1, idx[1]});
                                visitedQueue.add((HashSet)visited.clone());
                            }

                            if (idx[0] + 1 < board.length) {
                                nodeQueue.add(cur.map.get(c));
                                idxQueue.add(new int[]{idx[0] + 1, idx[1]});
                                visitedQueue.add((HashSet)visited.clone());
                            }

                            if (idx[1] - 1 >= 0) {
                                nodeQueue.add(cur.map.get(c));
                                idxQueue.add(new int[]{idx[0], idx[1] - 1});
                                visitedQueue.add((HashSet)visited.clone());
                            }

                            if (idx[1] + 1 < board[0].length) {
                                nodeQueue.add(cur.map.get(c));
                                idxQueue.add(new int[]{idx[0], idx[1] + 1});
                                visitedQueue.add((HashSet)visited.clone());
                            }
                            if (cur.map.get(c).isWord) result.add(cur.map.get(c).word);

                        }
                    }

                }
            }
        }
        return new ArrayList<String>(result);
    }
}


class Solution {
    // Given solution
    // Do traverse with DFS instead of BFS without explicitly storing visted
    // nodes for each path;
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        // 'a' - 'a' = 0
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        // build trie
        // do dfs on the board with the help of the trie
        // add result
        List<String> result = new ArrayList<>();
        TrieNode head = buildTrie(words);

        // traveres the board
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(head, i , j, board, result, visited);
            }
        }
        return result;
    }

    private void dfs(TrieNode head, int i, int j, char[][] board, List<String> result, boolean[][] visited){

        // check boundary
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0) return;

        // check if exists on the trie and also visited already
        char cur = board[i][j];
        if(visited[i][j] || head.children[cur - 'a'] == null) return;

        // else , it exists on the trie , so arrive to this one
        head = head.children[cur - 'a'];
        if(head.word != null) {
            result.add(head.word);
            // set word as null , incase there are two or more paths with the same word
            head.word = null;
        }

        // since it exists,we make it as visited and do four directions traversal on it
        visited[i][j] = true;

        int[][] directions = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        for(int[] dir : directions){
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(head, x, y, board, result, visited);
        }
        visited[i][j] = false;

    }
    private TrieNode buildTrie(String[] words){
        TrieNode head = new TrieNode();
        for(String word : words){
            TrieNode cur = head;
            for(char ch : word.toCharArray()){
                int pos = ch - 'a';
                if(cur.children[pos] == null){
                    // create a  new node
                    cur.children[pos] = new TrieNode();
                    // going down
                }
                cur = cur.children[pos];// here , if the pefix exists already, still need to add more chars
            }
            cur.word = word;
        }
        return head;
    }
}
