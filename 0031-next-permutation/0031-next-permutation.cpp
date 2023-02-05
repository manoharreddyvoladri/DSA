class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        // int n = nums.size();
        // if(n==1) // if only one element is present simply return it...
        //     return;
        // int i=1;
        // int lastInc = -1;
        // while(i<n){    // through this we get rightmost peak value
        //     if(nums[i]>nums[i-1])
        //         lastInc = i;
        //     i++;
        // }

        // if(lastInc==-1){  // if the order is descending then sorting the full array
        //     for(int i=0; i<n/2;i++){
        //         swap(nums[i],nums[n-i-1]);
        //     }
        //     return;
        // }

        // // Find element in the range (nums[lastInc-1] to nums[lastInc]) to the right
        // int mn = nums[lastInc];
        // int index = lastInc;
        // for(int i =lastInc; i<n;i++){
        //     if(nums[i]>nums[lastInc-1] && nums[i]<nums[index])
        //         index = i;
        // }
        // swap(nums[lastInc-1],nums[index]);
        // sort(nums.begin()+lastInc,nums.end());


           // Another method 
        int infpt=0; int n = nums.size(); // infpt - infection point
        for(int i=n-1; i>0;i--){
            if(nums[i]>nums[i-1]){  // infpt condition
                infpt = i;
                break;
            }
            
        }
        if(infpt==0){  // if there is no infpt
            sort(nums.begin(),nums.end());
        }
        else{
            int toswap = nums[infpt-1];   // element to the left of infpt
            int min = INT_MAX;
            for(int j=infpt;j<n;j++){ // checking the range of all elements to the right of infpt
                if(nums[j]-toswap>0 && nums[j]-toswap<min){ // swapping toswap with its next next highest elements to its right range
                    int temp = nums[j];
                    nums[j]=nums[infpt-1];
                    nums[infpt-1] = temp;
                }
            }
            sort(nums.begin()+infpt,nums.end()); // sorting all the elements to the right of infpt including infpt
        }
        

    }
};