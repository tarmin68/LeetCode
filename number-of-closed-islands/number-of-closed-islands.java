class Solution {
    boolean isVisited[][];
    public int closedIsland(int[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!isVisited[i][j] && grid[i][j] == 0 && isClosedIsland(i, j, grid)){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public boolean isClosedIsland(int i, int j, int[][] grid){
        boolean isValid = true;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(i, j));
        isVisited[i][j] = true;
        
        while(!q.isEmpty()){
            Pair<Integer, Integer> currCell = q.poll();
            int x = currCell.getKey();
            int y = currCell.getValue();
            if(x == 0 || x == isVisited.length - 1
              || y == 0 || y == isVisited[0].length - 1)
                isValid = false;
            
            if(x > 0 && grid[x - 1][y] == 0 && !isVisited[x - 1][y]){
                q.add(new Pair<>(x - 1, y));
                isVisited[x - 1][y] = true;
            }
            if(x < isVisited.length - 1 && grid[x + 1][y] == 0 && !isVisited[x + 1][y]){
                q.add(new Pair<>(x + 1, y));
                isVisited[x + 1][y] = true;
            }
            if(y > 0 && grid[x][y - 1] == 0 && !isVisited[x][y - 1]){
                q.add(new Pair<>(x, y - 1));
                isVisited[x][y - 1] = true;
            }
            if(y < isVisited[0].length - 1 && grid[x][y + 1] == 0 && !isVisited[x][y + 1]){
                q.add(new Pair<>(x, y + 1));
                isVisited[x][y + 1] = true;
            }
        }
        
        return isValid;
    }
}