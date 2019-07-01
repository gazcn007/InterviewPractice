class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char [] sArray = s.toCharArray();
        int len = sArray.length;
        for(int i = 0; i < len; i++) {
            if (stack.empty()) {
                stack.push(sArray[i]);
            } else {
                char cur = sArray[i];
                char last = stack.pop();
                if (last == '(' && cur == ')') continue;
                if (last == '[' && cur == ']') continue;
                if (last == '{' && cur == '}') continue;
                stack.push(last);
                stack.push(cur);
            }
        }
        return stack.empty();
    }
}
