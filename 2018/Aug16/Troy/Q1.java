class Solution {
    public List<Integer> getRow(int rowIndex) {
        // space complexity o(k)
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            if (result.size() == 0 || result.size() == 1) {
                result.add(1);
            } else {
                int temp = 1;
                for (int j = 1; j < result.size(); j++) {
                    int newInt = temp + result.get(j);
                    temp = result.get(j);
                    result.set(j, newInt);
                }
                result.add(1);
            }
        }
        return result;
    }
}
