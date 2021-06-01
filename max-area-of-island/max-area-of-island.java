class Solution {
    boolean[][] isVisited;
    int max = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        isVisited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !isVisited[i][j]){
                    getIslandArea(grid, i, j);
                }
            }
        }
        
        return max;
    }
    
    public void getIslandArea(int[][] grid, int i, int j){
        int count = 0;
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        q.add(new Pair(i, j));
        isVisited[i][j] = true;
        count++;
        
        while(!q.isEmpty()){
            Pair<Integer, Integer> currCell = q.poll();
            int row = currCell.getKey();
            int col = currCell.getValue();
            
            if(row > 0 && grid[row - 1][col] == 1 && !isVisited[row - 1][col]){
                q.add(new Pair(row - 1, col));
                isVisited[row - 1][col] = true;
                count++;
            }
            if(row < grid.length - 1 && grid[row + 1][col] == 1 && !isVisited[row + 1][col]){
                q.add(new Pair(row + 1, col));
                isVisited[row + 1][col] = true;
                count++;
            }
            if(col > 0 && grid[row][col - 1] == 1 && !isVisited[row][col - 1]){
                q.add(new Pair(row, col - 1));
                isVisited[row][col - 1] = true;
                count++;
            }
            if(col < grid[0].length - 1 && grid[row][col + 1] == 1 && !isVisited[row][col + 1]){
                q.add(new Pair(row, col + 1));
                isVisited[row][col + 1] = true;
                count++;
            }
        }
        
        max = Math.max(max, count);
    }
}