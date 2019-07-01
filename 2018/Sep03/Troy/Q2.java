class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 10000 - reader.get(0);
        while(start < end) {
            int middle = (end + start) / 2;
            if (reader.get(middle) == target) {
                return middle;
            } else if (reader.get(middle) > target) {
                end = middle - 1;
            } else if (reader.get(middle) < target) {
                start = middle + 1;
            }
        }
        if (reader.get(start) == target) return start;
        return -1;
    }
}
