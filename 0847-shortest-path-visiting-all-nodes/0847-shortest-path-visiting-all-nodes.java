class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> q = new LinkedList<>();
        List<Set<Integer>> dp = new ArrayList<>();
        for(int i = 0;i < n;i++)
            dp.add(new HashSet<>());
        int minPath = Integer.MAX_VALUE, targetBitMask = (int)Math.pow(2, n) - 1;
        for(int i = 0;i < n;i++){
            int bitMask = 1 << i;
            q.add(new int[]{i, bitMask, 0}); //node, bitmask, path length
            dp.get(i).add(bitMask);
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int src = cur[0], bitMask = cur[1], curPathLength = cur[2];
            if(bitMask == targetBitMask)
                minPath = Math.min(minPath, curPathLength);
            for(int dest : graph[src]){
                int newBitMask = bitMask | (1 << dest);
                if(dp.get(dest).contains(newBitMask))
                    continue;
                q.add(new int[]{dest, newBitMask, curPathLength + 1});
                dp.get(dest).add(newBitMask);
            }
        }
        return minPath;
    }
}