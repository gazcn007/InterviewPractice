class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // O(n) solution
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();
        int len = temperatures.length;
        for (int i = len - 1; i >= 0; i--) {
            while (stack.size() > 0 && temperatures[i] >= temperatures[stack.peek()]) {
                // We only want to keep the idx of warmer temperatures
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
