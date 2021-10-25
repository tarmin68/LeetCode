class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor == newColor)
            return image;
            
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{sr, sc});
        
        while(!q.isEmpty()){
            int[] currCell = q.remove();
            int r = currCell[0];
            int c = currCell[1];
            if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor)
                continue;
            image[r][c] = newColor;
            q.add(new int[]{r + 1, c});
            q.add(new int[]{r - 1, c});
            q.add(new int[]{r, c + 1});
            q.add(new int[]{r, c - 1});
        }
        
        return image;
    }
}