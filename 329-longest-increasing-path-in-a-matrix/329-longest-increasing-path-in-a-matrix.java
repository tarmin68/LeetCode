class Solution {
    int[][] longests;
    
    public int longestIncreasingPath(int[][] matrix) {
        longests = new int[matrix.length][matrix[0].length];
        
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                max = Math.max(max, getLongest(matrix, i, j));
            }
        }
        
        return max;
    }
    
    public int getLongest(int[][] matrix, int r, int c){
        if(longests[r][c] != 0)
            return longests[r][c];
        
        int up = 1;
        int dn = 1;
        int lf = 1;
        int rt = 1;
        
        if(r > 0 && matrix[r - 1][c] > matrix[r][c])
            up += getLongest(matrix, r - 1, c);
        if(r < matrix.length - 1 && matrix[r + 1][c] > matrix[r][c])
            dn += getLongest(matrix, r + 1, c);
        if(c > 0 && matrix[r][c - 1] > matrix[r][c])
            lf += getLongest(matrix, r, c - 1);
        if(c < matrix[0].length - 1 && matrix[r][c + 1] > matrix[r][c])
            rt += getLongest(matrix, r, c + 1);
        
        return longests[r][c] = Math.max(Math.max(up, dn), Math.max(rt, lf));
    }
}