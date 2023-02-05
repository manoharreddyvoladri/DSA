class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int max = Integer.MAX_VALUE;
        int ans = max;
            for(int j = 0; j < nums.length - 2; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while(k < l) {
                    int sum = nums[j] + nums[k] + nums[l];
                    if(sum == target)
                        return sum;
                    if(Math.abs(target-sum)<max){
                        max = Math.abs(target-sum);
                        ans = sum;
                    }
                    if(sum < target)
                        k++;
                    else
                        l--;
                }
            }
        return ans;
    }
}