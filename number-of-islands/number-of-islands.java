class Solution {
    boolean[][] connected;
    public int numIslands(char[][] grid) {
        connected = new boolean[grid.length][grid[0].length];
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !connected[i][j]){
                    count++;
                    bfs(i, j, grid);
                }
            }
        }
        
        return count;
    }
    
    public void bfs(int i, int j, char[][] grid){
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        
        q.add(new Pair(i, j));           
        connected[i][j] = true;
        
        while(!q.isEmpty()){
            Pair<Integer, Integer> currPair = q.poll();
            int r = currPair.getKey();
            int c = currPair.getValue();
            
            if(r > 0 && grid[r - 1][c] == '1' && !connected[r - 1][c]){
                q.add(new Pair(r - 1, c));
                connected[r - 1][c] = true;
            }
            if(c > 0 && grid[r][c - 1] == '1' && !connected[r][c - 1]){
                q.add(new Pair(r, c - 1));
                connected[r][c - 1] = true;
            }
            if(r < grid.length - 1 && grid[r + 1][c] == '1' && !connected[r + 1][c]){
                q.add(new Pair(r + 1, c));
                connected[r + 1][c] = true;
            }
            if(c < grid[0].length - 1 && grid[r][c + 1] == '1' && !connected[r][c + 1]){
                q.add(new Pair(r, c + 1));
                connected[r][c + 1] = true;
            }
        }
    }
}