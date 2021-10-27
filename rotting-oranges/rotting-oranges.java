class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)
                    freshCount++;
            }
        }
        
        for(int k = 0; k < m * n; k++){
            if(freshCount == 0)
                return k;
            
            int[][] temp = new int[m][n];
            for(int i = 0; i < m; i++){
                temp[i] = grid[i].clone();
            }
            
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1){
                        if(i > 0 && grid[i - 1][j] == 2)
                            temp[i][j] = 2;
                        if(j > 0 && grid[i][j - 1] == 2)
                            temp[i][j] = 2;
                        if(i < m - 1 && grid[i + 1][j] == 2)
                            temp[i][j] = 2;
                        if(j < n - 1 && grid[i][j + 1] == 2)
                            temp[i][j] = 2;
                        if(temp[i][j] == 2)
                            freshCount--;
                    }
                }
            }
            grid = new int[m][n];
            for(int i = 0; i < m; i++){
                grid[i] = temp[i].clone();
            }
        }
        
        return -1;
    }
}