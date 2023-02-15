class Solution {
    List<List<Integer>> ans;
    HashSet<List<Integer>> hset;
    public List<List<Integer>> combine(int n, int k) {
        ans =new ArrayList<>();
        hset=new HashSet<>();
        List<Integer> temp=new ArrayList<>();
        for(int i=1;i<=n;i++){
         helper(i,n,k,temp);
        }
        return ans;
    }

    public void helper(int i,int n,int k,List<Integer> temp){

        if(temp.size()==k){
            List<Integer> temp1=new ArrayList<>(temp);
            if(!hset.contains(temp1)){
            ans.add(temp1);
            hset.add(temp1);
            }
            return;
        }

        while(i<=n){
        temp.add(i);
        helper(i+1,n,k,temp);
        temp.remove(temp.size()-1);
        i++;
        }
        
    }
}