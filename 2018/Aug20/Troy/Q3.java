class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int total = rooms.size();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> keys = new LinkedList<>();
        keys.add(0);
        while(keys.size() > 0) {
            int key = keys.poll();
            if (!visited.contains(key))  {
               total--;
                if (total == 0) return true;
                visited.add(key);
                List<Integer> listOfKeys = rooms.get(key);
                for(int k : listOfKeys) {
                    keys.add(k);
                }
            }

        }
        return total == 0;
    }
}
