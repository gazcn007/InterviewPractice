class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int row = 1; row <= numRows; row++ ){
            List<Integer> temp = new ArrayList<Integer>();
            for(int col = 1; col <= row; col++ ){
                if (row <= 2) {
                    temp.add(1);
                } else {
                    if (col == 1 || col == row) {
                        temp.add(1);
                    } else {
                        temp.add(result.get(row - 1 - 1).get(col - 1 - 1) + result.get(row - 1 - 1).get(col - 1));
                    }
                }
            }
            result.add(temp);
        }
        return result;
    }
}
