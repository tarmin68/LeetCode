class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] minPaths = new int[m][n];
        
       for(int i = m - 1; i >= 0; i--){
           for(int j = n - 1; j >= 0; j--){
               minPaths[i][j] = Integer.MAX_VALUE;
               if(i < m - 1)
                    minPaths[i][j] = minPaths[i + 1][j] + grid[i][j];
               if(j < n - 1)
                    minPaths[i][j] = Math.min(minPaths[i][j], minPaths[i][j + 1] + grid[i][j]);
               if(i == m - 1 && j == n - 1)
                   minPaths[i][j] = grid[i][j];
           }
       }
        
        return minPaths[0][0];
    }
}