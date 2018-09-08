class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int product = 1;
        for(int i = len - 1; i >= 0; i--) {
            result[i] = product;
            product *= nums[i];
        }
        product = 1;
        for(int i = 0; i <= len - 1; i++) {
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }
}
