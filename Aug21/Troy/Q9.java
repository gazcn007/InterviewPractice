class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strings) {
            String shifted = new String(shift(s.toCharArray()));
            if (!map.containsKey(shifted)) {
                map.put(shifted, new ArrayList<>());
            }
            map.get(shifted).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
    public char[] shift(char[] charArray) {
        int shiftNumber = 0;
        for(int i = 0; i < charArray.length; i++) {
            if (i == 0) {
                shiftNumber = charArray[i] - 'a';
            }
            if (charArray[i] - shiftNumber < 'a') {
                charArray[i] = (char)('z' - (shiftNumber - (int)(charArray[i] - 'a') - 1));
            } else {
                charArray[i] -= shiftNumber;
            }

        }
        return charArray;
    }
}
