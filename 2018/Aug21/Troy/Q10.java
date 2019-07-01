class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> columnMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> blockMap = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int row = i;
                    int column = j;
                    int block = (j / 3) + 3 * (i / 3);
                    int value = board[i][j] - '0';
                    if (!rowMap.containsKey(row)) rowMap.put(row, new HashSet<>());
                    if (!columnMap.containsKey(column)) columnMap.put(column, new HashSet<>());
                    if (!blockMap.containsKey(block)) blockMap.put(block, new HashSet<>());

                    if (rowMap.get(row).contains(value)) return false;
                    if (columnMap.get(column).contains(value)) return false;
                    if (blockMap.get(block).contains(value)) return false;

                    rowMap.get(row).add(value);
                    columnMap.get(column).add(value);
                    blockMap.get(block).add(value);
                }
            }
        }
        return true;
    }
}
