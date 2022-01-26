class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1)
                    count++;
            }
        }
        
        for(int i = 1; i < Math.min(m, n); i++){
            for(int j = i; j < m; j++){
                for(int k = i; k < n; k++){
                    if(matrix[j][k] >= i && matrix[j - 1][k] >= i && matrix[j][k - 1] >= i && matrix[j - 1][k - 1] >= i){
                        count++;
                        matrix[j][k] = i + 1;
                    }
                }
            }
        }
        
        return count;
    }
}