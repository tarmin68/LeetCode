class Solution {
    boolean[][] isVisited;
    
    public int maxAreaOfIsland(int[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !isVisited[i][j]){
                    int currMax = getMaxArea(grid, i, j);
                    max = Math.max(max, currMax);
                }
            }
        }
        
        return max;
    }
    
    public int getMaxArea(int[][] grid, int row, int col){
        isVisited[row][col] = true;
        int count = 1;
        
        if(row > 0 && grid[row - 1][col] == 1 && !isVisited[row - 1][col]){
            count += getMaxArea(grid, row - 1, col);
        }
        if(row + 1 < grid.length && grid[row + 1][col] == 1 && !isVisited[row + 1][col]){
            count += getMaxArea(grid, row + 1, col);
        }
        if(col > 0 && grid[row][col - 1] == 1 && !isVisited[row][col - 1]){
            count += getMaxArea(grid, row, col - 1);
        }
        if(col + 1 < grid[0].length && grid[row][col + 1] == 1 && !isVisited[row][col + 1]){
            count += getMaxArea(grid, row, col + 1);
        }
        
        return count;
    }
}