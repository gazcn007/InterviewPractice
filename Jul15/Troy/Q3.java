class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            carry = val >= 10 ? 1 : 0;
            digits[i] = val - carry * 10;
        }
        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 1; i < digits.length; i ++) {
                result[i] = digits[i];
            }
            digits = result;
        }
        return digits;
    }
}
