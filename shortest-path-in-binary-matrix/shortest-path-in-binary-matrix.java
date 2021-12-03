class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        
        int n = grid.length;
        boolean[][] isVisited = new boolean[n][n];
        PriorityQueue<Path> pq = new PriorityQueue();
        pq.add(new Path(0, 0, 1));
        
        while(!pq.isEmpty()){
            Path currPath = pq.remove();
            int r = currPath.currRow;
            int c = currPath.currCol;
            int l = currPath.length;
            
            if(r < 0 || r >= n || c < 0 || c >= n || isVisited[r][c] || grid[r][c] == 1)
                continue;
            if(r == n - 1 && c == n - 1)
                return l;
            
            pq.add(new Path(r - 1, c - 1, l + 1));
            pq.add(new Path(r - 1, c, l + 1));
            pq.add(new Path(r - 1, c + 1, l + 1));
            pq.add(new Path(r, c - 1, l + 1));
            pq.add(new Path(r, c + 1, l + 1));
            pq.add(new Path(r + 1, c - 1, l + 1));
            pq.add(new Path(r + 1, c, l + 1));
            pq.add(new Path(r + 1, c + 1, l + 1));
            
            isVisited[r][c] = true;
        }
        
        return -1;
    }
    
    class Path implements Comparable<Path>{
        int currRow;
        int currCol;
        int length;
        
        public Path(int r, int c, int l){
            currRow = r;
            currCol = c;
            length = l;
        }
        
        @Override
        public int compareTo(Path p) {
            return Integer.compare(this.length, p.length);
        }
    }
}