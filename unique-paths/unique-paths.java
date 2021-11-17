class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int[] currCol = new int[n];
        for(int i = m - 2; i >= 0; i--){
            currCol[n - 1] = dp[n - 1];
            for(int j = n - 2; j >= 0; j--){
                currCol[j] = currCol [j + 1] + dp[j];
            }
            dp = currCol;
        }
        
        return dp[0];
    }
}