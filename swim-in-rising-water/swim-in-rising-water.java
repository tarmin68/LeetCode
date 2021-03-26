class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        PriorityQueue<Cell> q = new PriorityQueue();
        boolean[][] isVisited = new boolean[N][N];
        
        q.add(new Cell(grid[0][0], 0, 0));
        isVisited[0][0] = true;
        int maxElev = 0;
        while(!q.isEmpty()){
            Cell currCell = q.poll();
            int i = currCell.i;
            int j = currCell.j;
            maxElev = Math.max(maxElev, currCell.elev);
            if(i == N - 1 && j == N - 1)
                return maxElev;
            if(i > 0 && !isVisited[i - 1][j]){
                q.add(new Cell(grid[i - 1][j], i - 1, j));
                isVisited[i - 1][j] = true;
            }
            if(i < N - 1 && !isVisited[i + 1][j]){
                q.add(new Cell(grid[i + 1][j], i + 1, j));
                isVisited[i + 1][j] = true;
            }
            if(j > 0 && !isVisited[i][j - 1]){
                q.add(new Cell(grid[i][j - 1], i, j - 1));
                isVisited[i][j - 1] = true;
            }
            if(j < N - 1 && !isVisited[i][j + 1]){
                q.add(new Cell(grid[i][j + 1], i, j + 1));
                isVisited[i][j + 1] = true;
            }
        }
        
        return maxElev;
    }
    
    public class Cell implements Comparable<Cell>{
        int elev;
        int i;
        int j;
        
        public Cell(int elev, int i, int j){
            this.elev = elev;
            this.i = i;
            this.j = j;
        }
        
        @Override
        public int compareTo(Cell c){
            return Integer.compare(this.elev, c.elev);
        }
    }
}