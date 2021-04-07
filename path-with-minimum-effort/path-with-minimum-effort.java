class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Cell> q = new PriorityQueue();
        boolean[][] isVisited = new boolean[heights.length][heights[0].length];
        
        q.add(new Cell(0, 0, 0));
        int min = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            Cell currCell = q.poll();
            int row = currCell.row;
            int column = currCell.column;
            isVisited[row][column] = true;
            if(row == heights.length - 1 && column == heights[0].length - 1){
                min = Math.min(min, currCell.effort);
                continue;
            }
            
            if(row > 0 && !isVisited[row - 1][column]){
                q.add(new Cell(row - 1, column, Math.max(currCell.effort, Math.abs(heights[row - 1][column] - heights[row][column]))));
            }
            if(column > 0 && !isVisited[row][column - 1]){
                q.add(new Cell(row, column - 1, Math.max(currCell.effort, Math.abs(heights[row][column - 1] - heights[row][column]))));
            }
            if(row < heights.length - 1 && !isVisited[row + 1][column]){
                q.add(new Cell(row + 1, column, Math.max(currCell.effort, Math.abs(heights[row + 1][column] - heights[row][column]))));
            }
            if(column < heights[0].length - 1 && !isVisited[row][column + 1]){
                q.add(new Cell(row, column + 1, Math.max(currCell.effort, Math.abs(heights[row][column + 1] - heights[row][column]))));
            }
        }
        
        return min;
    }
    
    public class Cell implements Comparable<Cell>{
        int row;
        int column;
        int effort;
        
        public Cell(int row, int column, int effort){
            this.row = row;
            this.column = column;
            this.effort = effort;
        }
        
        @Override
        public int compareTo(Cell c){
            return Integer.compare(this.effort, c.effort);
        }
        
        public String toString(){
            return row + " " + column + " " + effort;
        }
    }
}