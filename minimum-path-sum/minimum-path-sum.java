class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<Cell> q = new PriorityQueue();
        q.add(new Cell(0, 0, grid[0][0]));
        
        while(!q.isEmpty()){
            Cell currCell = q.poll();
            if(currCell.r == m - 1 && currCell.c == n - 1)
                return currCell.pathSum;
            
            visited[currCell.r][currCell.c] = true;
            if(currCell.r < m - 1 && !visited[currCell.r + 1][currCell.c])
                q.add(new Cell(currCell.r + 1, currCell.c, 
                               currCell.pathSum + grid[currCell.r + 1][currCell.c]));
            if(currCell.c < n - 1  && !visited[currCell.r][currCell.c + 1])
                q.add(new Cell(currCell.r, currCell.c + 1,
                               currCell.pathSum + grid[currCell.r][currCell.c + 1]));
        }
        
        return -1;
    }
    
    public class Cell implements Comparable<Cell>{
        int r;
        int c;
        int pathSum;
        
        public Cell(int r, int c, int pathSum){
            this.r = r;
            this.c = c;
            this.pathSum = pathSum;
        }
        
        @Override
        public int compareTo(Cell ce){
            return Integer.compare(this.pathSum, ce.pathSum);
        }
    }
}

