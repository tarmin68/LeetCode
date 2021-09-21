class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        boolean[][] isVisited = new boolean[image.length][image[0].length];
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        
        q.add(new Pair(sr, sc));
        
        while(!q.isEmpty()){
            Pair<Integer, Integer> currCell = q.poll();
            int currRow = currCell.getKey();
            int currCol = currCell.getValue();
            image[currRow][currCol] = newColor;
            isVisited[currRow][currCol] = true;
            
            if(currRow - 1 >= 0 && !isVisited[currRow - 1][currCol] && image[currRow - 1][currCol] == oldColor){
                q.add(new Pair(currRow - 1, currCol));
            } 
            if(currRow + 1 < image.length && !isVisited[currRow + 1][currCol] && image[currRow + 1][currCol] == oldColor){
                q.add(new Pair(currRow + 1, currCol));
            }
            if(currCol - 1 >= 0 && !isVisited[currRow][currCol - 1] && image[currRow][currCol - 1] == oldColor){
                q.add(new Pair(currRow, currCol - 1));
            }
            if(currCol + 1 < image[0].length && !isVisited[currRow][currCol + 1] && image[currRow][currCol + 1] == oldColor){
                q.add(new Pair(currRow, currCol + 1));
            }
        }
        
        return image;
    }
}