class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)
                    freshCount++;
                if(grid[i][j] == 2)
                    q.offer(new Pair(i, j));
            }
        }
        
        int level = 0;
        while(!q.isEmpty()){
            if(freshCount == 0)
                return level;
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair<Integer, Integer> curr = q.poll();
                int r = curr.getKey();
                int c = curr.getValue();
                if(r > 0 && grid[r - 1][c] == 1){
                    grid[r - 1][c] = 2;
                    freshCount--;
                    q.offer(new Pair(r - 1, c));
                }
                if(r < m - 1 && grid[r + 1][c] == 1){
                    grid[r + 1][c] = 2;
                    freshCount--;
                    q.offer(new Pair(r + 1, c));
                }
                if(c > 0 && grid[r][c - 1] == 1){
                    grid[r][c - 1] = 2;
                    freshCount--;
                    q.offer(new Pair(r, c - 1));
                }
                if(c < n - 1 && grid[r][c + 1] == 1){
                    grid[r][c + 1] = 2;
                    freshCount--;
                    q.offer(new Pair(r, c + 1));
                }
            }
            level++;
        }
        
        if(freshCount == 0)
            return level;
        return -1;
    }
}