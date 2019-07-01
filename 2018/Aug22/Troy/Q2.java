class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        char[] charArray = J.toCharArray();
        for(char j : charArray) {
            jewels.add(j);
        }

        int result = 0;
        charArray = S.toCharArray();
        for(char s : charArray) {
            if (jewels.contains(s)) result += 1;
        }
        return result;
    }
}
