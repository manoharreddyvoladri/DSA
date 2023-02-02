class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index1 = -1;
        int index2=-1;
        int[] newArr = new int[2];
        for (int k=0;k<nums.length;k++){
            if (nums[k]==target && index1==-1){
               index1 = k;
                break;
            }
        }
            for (int k=nums.length-1;k>=0;k--){
                if (nums[k]==target && index2==-1){
                    index2 =k;
                    break;
                }
            }
         newArr[0]=index1;
        newArr[1]=index2;  
        return newArr;  
    }
}