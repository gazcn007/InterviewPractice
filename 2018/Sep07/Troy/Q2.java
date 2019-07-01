class Solution {
    String[] data1 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                                 "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                                 "Seventeen", "Eighteen", "Nineteen"};
    String[] data2 = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] data3 = new String[]{"", "One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred",
                      "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred"};
    public String numberToWords(int num) {
        Stack<Integer> stack = new Stack<>();
        if (num == 0) stack.push(0);
        while(num > 0) {
            stack.push(num % 1000);
            num /= 1000;
        }
        StringBuilder result = new StringBuilder();
        while(stack.size() > 0) {
            int unitNumber = stack.size();
            String unit = new String("");
            if (unitNumber == 2) {
                unit = "Thousand";
            } else if (unitNumber == 3) {
                unit = "Million";
            } else if (unitNumber == 4) {
                unit = "Billion";
            }
            int tmp = stack.pop();
            Stack<Integer> stack2 = new Stack<>();
            if (tmp >= 0 && tmp < 20) {
                stack2.push(tmp);
                if (tmp == 0) unit = new String("");
            } else if (tmp < 100) {
                stack2.push(tmp % 10);
                tmp /= 10;
                stack2.push(tmp % 10);
            } else {
                int tmp2 = tmp % 100;
                if (tmp2 >= 10 && tmp2 < 20) {
                    stack2.push(tmp2);
                    stack2.push(0);
                    stack2.push(tmp / 100);
                } else {
                    stack2.push(tmp % 10);
                    tmp /= 10;
                    stack2.push(tmp % 10);
                    tmp /= 10;
                    stack2.push(tmp % 10);
                }
            }
            while(stack2.size() > 0) {
                if (result.length() > 0 && stack2.peek() != 0) result.append(" ");
                if (stack2.size() == 3) {
                    result.append(data3[stack2.pop()]);
                } else if (stack2.size() == 2) {
                    result.append(data2[stack2.pop()]);
                } else if (stack2.size() == 1) {
                    if (result.length() == 0 && stack2.peek() == 0) {
                        result.append("Zero");
                    } else {
                        result.append(data1[stack2.pop()]);
                    }
                }
            }
            if (!unit.equals("")) result.append(" ");
            result.append(unit);
        }
        return result.toString();
    }
}
