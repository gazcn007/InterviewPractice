class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();

        int start = 0;
        for(int i = 0; i < charArray.length; i++) {
            int idx = start + s.substring(start, i).indexOf(charArray[i]);
            if (idx != start - 1) {
                result = Math.max(result, i - start);
                start = idx + 1;
            } else {
                result = Math.max(result, i - start + 1);
            }
        }

        return result;
    }
}


class Solution {
    // HashMap version, avoided using indexOf
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        for(int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i]) && map.get(charArray[i]) >= start) {
                result = Math.max(result, i - start);
                start = map.get(charArray[i]) + 1;
            } else {
               result = Math.max(result, i - start + 1);
            }
            map.put(charArray[i], i);
        }

        return result;
    }
}
