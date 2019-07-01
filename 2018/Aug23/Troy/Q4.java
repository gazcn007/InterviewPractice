class AutocompleteSystem {
    class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        int freq = 0;
        boolean isString = false;
        String string = new String("");
    }
    TrieNode root;
    StringBuilder tmp = new StringBuilder();
    TrieNode pointer = root;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for(int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
        pointer = root;
    }


    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        List<TrieNode> mostFreqNode = new ArrayList<>();
        if (c == '#') {
            pointer.isString = true;
            pointer.freq += 1;
            pointer.string = tmp.toString();
            tmp.setLength(0);
            pointer = root;
            return result;
        } else {
            tmp.append(c);
            if (!pointer.map.containsKey(c)) {
                pointer.map.put(c, new TrieNode());
                pointer = pointer.map.get(c);
            } else {
                pointer = pointer.map.get(c);
                Stack<TrieNode> stack = new Stack<>();
                stack.add(pointer);

                while(stack.size() > 0) {
                    TrieNode tmpPointer = stack.pop();
                    if (tmpPointer.isString) {
                        mostFreqNode.add(tmpPointer);
                    }
                    for(TrieNode t : tmpPointer.map.values()){
                        stack.add(t);
                    }
                }
            }

        }
        result = selectThreeLargest(mostFreqNode);
        return result;
    }

    public List<String> selectThreeLargest(List<TrieNode> mostFreqNode) {
        List<String> result = new ArrayList<>();
        int upperLimit = Math.min(3, mostFreqNode.size());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> idxs = new ArrayList<>();
        for (int p = 0; p < upperLimit; ) {
            for(int i = 0; i < mostFreqNode.size(); i++) {
                String s = mostFreqNode.get(i).string;
                int freq = mostFreqNode.get(i).freq;
                if (freq <= min) {
                    if (freq > max && result.indexOf(s) == -1) {
                        idxs.clear();
                        idxs.add(i);
                        max = freq;
                    } else if (freq == max && result.indexOf(s) == -1) {
                        idxs.add(i);
                    }
                }
            }

            int numsToAdd = 0;
            if (idxs.size() >= upperLimit - p) {
                numsToAdd = upperLimit - p;
            } else {
                numsToAdd = idxs.size();
            }
            List<String> tmpStrings = new ArrayList<>();
            for(Integer idx : idxs) {
                tmpStrings.add(mostFreqNode.get(idx).string);
                min = mostFreqNode.get(idx).freq;
            }
            Collections.sort(tmpStrings);
            max = Integer.MIN_VALUE;
            result.addAll(tmpStrings.subList(0, numsToAdd));
            p += numsToAdd;
        }

        return result;

    }

    public void insert(String s, int freq) {
        char[] charArray = s.toCharArray();
        TrieNode cur = root;
        for(int j = 0; j < charArray.length; j++) {
            if (!cur.map.containsKey(charArray[j])) cur.map.put(charArray[j], new TrieNode());
            cur = cur.map.get(charArray[j]);
        }
        cur.freq += freq;
        cur.isString = true;
        cur.string = s;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
