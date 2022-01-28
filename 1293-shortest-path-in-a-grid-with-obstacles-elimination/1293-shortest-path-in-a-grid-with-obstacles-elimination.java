class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][][] visited = new boolean[m][n][k + 1];
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new Integer[]{0, 0, 0, k});
        
        while(!pq.isEmpty()){
            Integer[] currCell = pq.remove();
            int r = currCell[0];
            int c = currCell[1];
            int d = currCell[2];
            int newK = currCell[3];
            
            if(r == m - 1 && c == n - 1)
                return d;
            
            if(r > 0){
                if(grid[r - 1][c] == 0 && !visited[r - 1][c][newK]){
                    pq.add(new Integer[]{r - 1, c, d + 1, newK});
                    visited[r - 1][c][newK] = true;
                }
                else if(newK > 0 && !visited[r - 1][c][newK - 1]){
                    pq.add(new Integer[]{r - 1, c, d + 1, newK - 1});
                    visited[r - 1][c][newK - 1] = true;
                }
            }
            if(r < m - 1){
                if(grid[r + 1][c] == 0 && !visited[r + 1][c][newK]){
                    pq.add(new Integer[]{r + 1, c, d + 1, newK});
                    visited[r + 1][c][newK] = true;
                }
                else if(newK > 0 && !visited[r + 1][c][newK - 1]){
                    pq.add(new Integer[]{r + 1, c, d + 1, newK - 1});
                    visited[r + 1][c][newK - 1] = true;
                }
            }
            if(c > 0){
                if(grid[r][c - 1] == 0  && !visited[r][c - 1][newK]){
                    pq.add(new Integer[]{r, c - 1, d + 1, newK});
                    visited[r][c - 1][newK] = true;
                }
                else if(newK > 0  && !visited[r][c - 1][newK - 1]){
                    pq.add(new Integer[]{r, c - 1, d + 1, newK - 1});
                     visited[r][c - 1][newK - 1] = true;
                }
            }
            if(c < n - 1){
                if(grid[r][c + 1] == 0 && !visited[r][c + 1][newK]){
                    pq.add(new Integer[]{r, c + 1, d + 1, newK});
                    visited[r][c + 1][newK] = true;
                }
                else if(newK > 0 && !visited[r][c + 1][newK - 1]){
                    pq.add(new Integer[]{r, c + 1, d + 1, newK - 1});
                    visited[r][c + 1][newK - 1] = true;
                }
            }
        }
        
        return -1;
    }
}