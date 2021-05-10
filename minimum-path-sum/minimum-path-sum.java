class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] minPaths = new int[m][n];
        minPaths[m - 1][n - 1] = grid[m - 1][n - 1];
        
       for(int i = m + n - 3; i >= 0; i--){
           for(int r = 0; r < m; r++){
               int c = i - r;
               if(c >= n || c < 0)
                   continue;
               
               minPaths[r][c] = Integer.MAX_VALUE;
               if(r < m - 1)
                   minPaths[r][c] = minPaths[r + 1][c] + grid[r][c];
               if(c < n - 1)
                   minPaths[r][c] = Math.min(minPaths[r][c], minPaths[r][c + 1] + grid[r][c]);
            }
        }
        
        return minPaths[0][0];
    }
}