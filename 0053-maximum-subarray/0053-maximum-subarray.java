class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0, ans = Integer.MIN_VALUE, i = 0;
        while (i < nums.length) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                ans = Math.max(maxSum, ans);
                maxSum = Integer.MIN_VALUE;
                sum = 0;
            }
            i++;
        }
        ans = Math.max(maxSum, ans);
        return ans;
    }
}