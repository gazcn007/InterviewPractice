class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
      HashSet<String> visitedSet = new HashSet<>();
      Queue<String> queue = new LinkedList();
      queue.add("0000");
      int result = 0;
      while(queue.size() > 0) {
          int size = queue.size();
          while(size > 0) {
              String cur = queue.poll();
              if (cur.equals(target)) return result;
              size--;
              if (deadendSet.contains(cur) || visitedSet.contains(cur)) continue;

              for(int i = 0; i < 4; i++) {
                  char[] curArray = cur.toCharArray();
                  curArray[i] = curArray[i] < '9' ? ++curArray[i] : '0';
                  queue.add(new String(curArray));

                  curArray = cur.toCharArray();
                  curArray[i] = curArray[i] > '0' ? --curArray[i] : '9';
                  queue.add(new String(curArray));
                  curArray = cur.toCharArray();
              }
              visitedSet.add(cur);
          }

          result++;
      }
      return -1;
    }
}
