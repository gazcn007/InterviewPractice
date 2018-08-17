class Solution {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        int result = 0;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int right = Integer.parseInt(stack.pop());
                int left = Integer.parseInt(stack.pop());
                if (tokens[i].equals("+") ) stack.push(Integer.toString(left + right));
                if (tokens[i].equals("-") ) stack.push(Integer.toString(left - right));
                if (tokens[i].equals("*") ) stack.push(Integer.toString(left * right));
                if (tokens[i].equals("/") ) stack.push(Integer.toString(left / right));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
