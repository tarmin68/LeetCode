class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    public void bfs(char[][] grid, int r, int c){
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        q.add(new Pair(r, c));
        grid[r][c] = '0';
        
        while(!q.isEmpty()){
            Pair<Integer, Integer> currCell = q.remove();
            int row = currCell.getKey();
            int col = currCell.getValue();
            if(row > 0 && grid[row - 1][col] == '1'){
                q.add(new Pair(row - 1, col));
                grid[row - 1][col] = '0';
            }
            if(row < grid.length - 1 && grid[row + 1][col] == '1'){
                q.add(new Pair(row + 1, col));
                grid[row + 1][col] = '0';
            }
            if(col > 0 && grid[row][col - 1] == '1'){
                q.add(new Pair(row, col - 1));
                grid[row][col - 1] = '0';
            }
            if(col < grid[0].length - 1 && grid[row][col + 1] == '1'){
                q.add(new Pair(row, col + 1));
                grid[row][col + 1] = '0';
            }
        }
    }
}