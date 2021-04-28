class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1 - obstacleGrid[m - 1][n - 1];
        for(int k = m + n - 3; k >= 0; k--){
            for(int i = m - 1; i >= 0; i--){
                int j = k - i;
                if(j >= 0 && j < n && obstacleGrid[i][j] == 0){
                    if(j < n - 1){
                        dp[i][j] += dp[i][j + 1];
                    }
                    if(i < m - 1){
                        dp[i][j] += dp[i + 1][j];
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}