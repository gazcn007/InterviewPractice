class Solution {
    // Build the Trie first to store numbers in their
    // binary form. Then for each number, use the
    // trie to find its best match which acheives max
    // XOR value. Since the trie is of fixed height
    // (<= 32), this search only takes O(1) time. and
    // total cost is thus n * O(1) = O(n);
    class TrieNode {
        int val = 0;
        TrieNode zeroNode = null;
        TrieNode oneNode = null;
    }
    TrieNode root;
    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();
        List<String> binaryStrings = new ArrayList<>();

        for(int i : nums) {
            String bstring = String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0');
            binaryStrings.add(bstring);
        }


        for(String s : binaryStrings) {
            char[] ca = s.toCharArray();
            TrieNode cur = root;
            for(int i = 0; i < 32; i++) {
                int n = ca[i] - '0';
                if (n == 0) {
                    if (cur.zeroNode == null) cur.zeroNode = new TrieNode();
                    cur = cur.zeroNode;
                } else if (n == 1) {
                    if (cur.oneNode == null) cur.oneNode = new TrieNode();
                    cur = cur.oneNode;
                }
            }
            cur.val = Integer.parseInt(s, 2);
        }

        int result = Integer.MIN_VALUE;
        for(String s: binaryStrings) {
            char[] ca = s.toCharArray();
            StringBuilder tmp = new StringBuilder();
            TrieNode cur = root;
            for(int i = 0; i < 32; i++) {
                int n = ca[i] - '0';

                if (n == 0) {
                    if (cur.oneNode == null) {
                        cur = cur.zeroNode;
                        tmp.append('0');
                    } else {
                        cur = cur.oneNode;
                        tmp.append('1');
                    }
                } else if (n == 1) {
                    if (cur.zeroNode == null) {
                        cur = cur.oneNode;
                        tmp.append('0');
                    } else {
                        cur = cur.zeroNode;
                        tmp.append('1');
                    }
                }
            }

            int val = Integer.parseInt(tmp.toString(), 2);
            result = val > result ? val : result;
        }

        return result;
    }
}
