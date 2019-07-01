class Solution {
    public String addBinary(String a, String b) {
        int len_a = a.length() - 1;
        int len_b = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while(len_a >= 0 || len_b >= 0) {
            int a_i = Character.getNumericValue(len_a >= 0 ? a.charAt(len_a) : '0');
            int b_i = Character.getNumericValue(len_b >= 0 ? b.charAt(len_b) : '0');
            int temp = a_i + b_i + carry;
            result.append(temp % 2 == 0 ? '0' : '1');
            carry = temp >= 2 ? 1 : 0;

            len_a--;
            len_b--;
        }
        if (carry > 0) result.append('1');
        return result.reverse().toString();
    }
}
