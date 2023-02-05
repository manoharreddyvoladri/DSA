class Solution {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0, fastIndex = 0;
        while(fastIndex < nums.length){
            if(nums[fastIndex] == val){
                fastIndex++;
                continue;
            }
            nums[slowIndex] = nums[fastIndex];
            slowIndex++;
            fastIndex++;
        }
        return slowIndex;
    }
}