class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int i = num.length-1;
        int carry = 0;
        
        //Using Linkedist we dont need to reverse it afterward
        LinkedList<Integer> ans = new  LinkedList<>();


        /*We always start computing from array's last element and k's last digit and will 
		compute sum and carry. */
        /* Loop will execute untill both the array n k digit traversed fully*/
        while(k!=0 || i>=0){
            int  sum = carry;
            //Here computing array element and adding to sum
            if(i >= 0){
                sum += num[i];
                i--;
            }

            //Using digit extraction and adding current element to sum
            if(k>0){
            int d = k%10;
             sum+= d;
            k = k/10;
            }
            
            /*
            Remainder will give the one's place digit of sum which we add to list 
            And quotient will give ten's place digit which will be carry for next iteration
            */
            ans.addFirst(sum % 10);
            carry = sum/10;
        }
        
        /*If there is some carry still remaining at last then add it*/
        if(carry!=0)
        ans.addFirst(carry);

        
        return ans;
        
    }
}