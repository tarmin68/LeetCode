class Solution {
    boolean isVisited[][];
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0) return 0;
        
        int maxArea = 0;
        isVisited = new boolean[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int currArea = getArea(i, j, grid);
                maxArea = Math.max(maxArea, currArea);
            }
        }
        
        return maxArea;
    }
    
    public int getArea(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || isVisited[i][j])
            return 0;
        
        isVisited[i][j] = true;
        return 1 + getArea(i - 1, j, grid) + getArea(i + 1, j, grid) + getArea(i, j - 1, grid) + getArea(i, j + 1, grid);
    }
}