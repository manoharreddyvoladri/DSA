class Solution {
    public int climbStairs(int n) {
        // Map<Integer,Integer> storage = new HashMap<>();
        // if (n == 1) return 1;
        // if (n == 2) return 2;
        // if (null != storage.get(n)){
        //     return storage.get(n);
        // } else {
        //     int res = climbStairs(n - 1) + climbStairs(n - 2);
        //     storage.put(n, res);
        //     return res;
        // }

        if (n == 1) return 1;
        if (n == 2) return 2;
        int res = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++){
            res = pre + prepre;
            prepre = pre;
            pre = res;
        }
        return res;
    }
}