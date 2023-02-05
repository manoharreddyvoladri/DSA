class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum(int[] arr, int target) {
         answer = new ArrayList<>();
       
        helper(arr, new ArrayList<>(),0,target,0);

        return answer;
    }

    public void helper(int arr[], ArrayList<Integer> temp, int currentSum, int requiredSum, int index){

        if(currentSum==requiredSum){
            answer.add(temp);
            return;
        }

        if(index>=arr.length || currentSum>requiredSum)
            return;


       // if the current digit + choosen digit sum is less than or equal to target sum, you have 2 options
        // 1. take it 2. don't take it

        // else don't take it


            ArrayList<Integer> a = new ArrayList<>(temp);
            if(currentSum+arr[index]<=requiredSum){
                // 2 choices, add it or dont
                a.add(arr[index]);
                helper(arr,a, currentSum+arr[index],requiredSum,index);

                helper(arr,temp, currentSum, requiredSum,index+1);
            }else
            
            helper(arr,temp, currentSum, requiredSum,index+1);


    }


}
