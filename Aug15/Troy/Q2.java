class Solution {
    // A truly weired solution
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> levelCut = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        temp.add(beginWord);
        boolean possible = false;
        while(wordList.size() > 0) {
            List<String> negs = new ArrayList<String>();
            for(int i = 0; i < temp.size(); i++) {
                String tempW = temp.get(i);
                List<List<String>> processedWL = neighbours(tempW, wordList);
                negs.addAll(processedWL.get(0));
                wordList = processedWL.get(1);
            }
            if (negs.size() == 0) {
               break;
            }
            levelCut.add(negs);
            temp = negs;
            if (negs.indexOf(endWord) != -1) {
                possible = true;
                break;
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        if (possible) {
            List<String> startSequence = new ArrayList<String>();
            List<String> endSequence = new ArrayList<String>();
            startSequence.add(beginWord);
            endSequence.add(endWord);
            result.add(endSequence);
            levelCut.add(0, startSequence);
            for(int i = levelCut.size() - 1 - 1; i >= 0; i--) {
                List<String> cut = levelCut.get(i);
                List<List<String>> tempResult = new ArrayList<List<String>>();

                for(int j = 0; j < cut.size(); j++) {
                    String word = cut.get(j);
                    for (int p = 0; p < result.size(); p++) {
                        List<String> sequence = new ArrayList<>(result.get(p));
                        if (isNeighbour(word, sequence.get(0))) {
                            sequence.add(0, word);
                            tempResult.add(sequence);
                        }
                    }
                }
                result = tempResult;
            }
        }
        return result;
    }
    public List<List<String>> neighbours(String word, List<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> negs = new ArrayList<String>();
        List<String> complement = new ArrayList<String>();
        for(int i = 0; i < wordList.size(); i++) {
            if (isNeighbour(word, wordList.get(i))) {
                negs.add(wordList.get(i));
            } else if (word.compareTo(wordList.get(i)) != 0) { // prevent circle
                complement.add(wordList.get(i));
            }
        }
        result.add(negs);
        result.add(complement);
        return result;
    }

    public boolean isNeighbour(String word, String neg) {
        int len = word.length();
        int difference = 0;
        for(int i = 0; i < len; i++) {
            if (word.charAt(i) != neg.charAt(i)) difference++;
            if (difference > 1) return false;
        }
        return difference == 1;
    }

}
