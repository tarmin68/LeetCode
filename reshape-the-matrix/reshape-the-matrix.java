class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        
        if(n * m != r * c)
            return mat;
        
        int[][] res = new int[r][c];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int pos = i * m + j;
                int newR = pos / c;
                int newC = pos % c;
                res[newR][newC] = mat[i][j];
            }
        }
        
        return res;
    }
}