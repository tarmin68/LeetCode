class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                max = Math.max(max, getMax(grid, i, j));
            }
        }
        
        return max;
    }
    
    public int getMax(int[][] grid, int sr, int sc){
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{sr, sc});
        int count = 0;
        
        while(!q.isEmpty()){
            int[] currCell = q.remove();
            int r = currCell[0];
            int c = currCell[1];
            
            if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
                continue;
            count++;
            grid[r][c] = 0;
            q.add(new int[]{r + 1, c});
            q.add(new int[]{r - 1, c});
            q.add(new int[]{r, c + 1});
            q.add(new int[]{r, c - 1});
        }
        
        return count;
    }
}