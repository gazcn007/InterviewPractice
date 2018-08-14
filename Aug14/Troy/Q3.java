class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        StringBuilder result = new StringBuilder();
        if (len <= 0) return result.toString();
        for(int i = 0; ; i++) {
            char temp = 'a';
            for(int j = 0; j < len; j++) {
                if (strs[j].length() <= i) return result.toString();
                if (j == 0) {
                    temp = strs[j].charAt(i);
                } else if (temp != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(temp);
        }
    }
}
