class Solution {
    int m;
    int n;
    int pathCount = 0;
    int emptyCount = 0;
    
    public int uniquePathsIII(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        emptyCount = m * n;
        Pair<Integer, Integer> start = new Pair(0,0);
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == -1)
                    emptyCount--;
                else if(grid[i][j] == 1)
                    start = new Pair(i, j);
            }
        }
        
        ArrayList<Pair<Integer, Integer>> visited = new ArrayList();
        getPaths(grid, start.getKey(), start.getValue(), visited);
        return pathCount;
    }
    
    public void getPaths(int[][] grid, int r, int c, ArrayList<Pair<Integer, Integer>> visited){
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == -1 || visited.contains(new Pair(r, c)))
            return;
        
        if(grid[r][c] == 2){
            if(visited.size() == emptyCount - 1)
                pathCount++;
            return;
        }
        
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1},  {0, -1}};
        
        for(int i = 0; i < dirs.length; i++){
            visited.add(new Pair(r, c));
            getPaths(grid, r + dirs[i][0], c + dirs[i][1], visited);
            visited.remove(new Pair(r, c));
        }
    }
}