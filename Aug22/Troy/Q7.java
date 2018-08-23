class ValidWordAbbr {
    private HashMap<String, HashSet<String>> hashMap = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary) {
            char[] charArray = s.toCharArray();
            String tmp = s;
            if (charArray.length > 2) {
                tmp = charArray[0] + Integer.toString(charArray.length - 2) + charArray[charArray.length - 1];
            }
            if (!hashMap.containsKey(tmp)) hashMap.put(tmp, new HashSet<>());
            hashMap.get(tmp).add(s);
        }
    }

    public boolean isUnique(String word) {
        char[] charArray = word.toCharArray();
        String tmp = word;
        if (charArray.length > 2) {
            tmp = charArray[0] + Integer.toString(charArray.length - 2) + charArray[charArray.length - 1];

        }

        if (hashMap.containsKey(tmp)) {
            return hashMap.get(tmp).size() == 1 && hashMap.get(tmp).contains(word);
        } else {
            return true;
        }

    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
