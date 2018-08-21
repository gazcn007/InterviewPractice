class Solution {
    public String decodeString(String s) {
        // Need optimization
        Stack<String> stack =new Stack<>();
        char[] sArray = s.toCharArray();

        for(int i = 0; i < sArray.length; i++) {
            char cur = sArray[i];
            if (cur >= '0' && cur <= '9') {
                int j = i + 1;
                while (j < sArray.length && sArray[j] >= '0' && sArray[j] <= '9' ) {
                    j++;
                }
                stack.push(s.substring(i, j));
                i = j - 1;
            } else if (Character.isLetter(cur)) {
                int j = i + 1;
                while (j < sArray.length && Character.isLetter(sArray[j])) {
                    j++;
                }
                stack.push(s.substring(i, j));
                i = j - 1;
            } else if (cur == '[') {
                stack.push("[");
            } else {
                stack.push("]");
            }
        }
        Stack<String> braceStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        while(stack.size() > 0) {
            String cur = stack.pop();
            if (cur.equals("]")) {
                braceStack.push("]");
            } else {
                if (stack.size() == 0) {
                    resultStack.add(cur);
                    break;
                }
                if (stack.peek().equals("[")) {
                    stack.pop();
                    int num = Integer.parseInt(stack.pop());
                    String tmp = new String(new char[num]).replace("\0", cur);
                    if (braceStack.size() > 0) braceStack.pop();
                    if (braceStack.size() > 0 && !braceStack.peek().equals("]")) {
                            tmp += braceStack.pop();
                    }
                    stack.push(tmp);
                } else if (stack.peek().equals("]")) {
                    if (braceStack.size() == 0) {
                        resultStack.push(cur);
                    } else {
                        braceStack.push(cur);
                    }
                } else {
                    String last = stack.pop();
                    stack.push(last + cur);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        while(resultStack.size() > 0) {
            result.append(resultStack.pop());
        }
        return result.toString();
    }
}

// Better solution from others.
public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
