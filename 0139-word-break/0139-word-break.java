class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       // Create a HashSet to store the words in wordDict for efficient look up
        Set<String> wordSet = new HashSet<>(wordDict);
        // Create an array to store the subproblem results, where dp[i] represents if s[0:i] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        
        // Base case: an empty string can always be segmented
        dp[0] = true;
        
        // Iterate through the string
        for (int i = 1; i <= s.length(); i++) {
            // Check if current prefix can be segmented
            for (int j = 0; j < i; j++) {
                // If dp[j] is true (s[0:j] can be segmented) and s[j:i] is in wordSet
                // we mark dp[i] as true, indicating that s[0:i] can be segmented
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        // The last element of dp[] represents if the whole string s can be segmented
        return dp[s.length()];
    }
    

    
}