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
    
    public int getLongest(int[][] matrix, int i, int j){
        if(longests[i][j] != 0)
            return longests[i][j];
        
        int max = 1;
        if(i > 0 && matrix[i][j] > matrix[i - 1][j]){
            max = Math.max(max, getLongest(matrix, i - 1, j) + 1);
        }
        if(j > 0 && matrix[i][j] > matrix[i][j - 1]){
            max = Math.max(max, getLongest(matrix, i, j - 1) + 1);
        }
        if(i < matrix.length - 1 && matrix[i][j] > matrix[i + 1][j]){
            max = Math.max(max, getLongest(matrix, i + 1, j) + 1);
        }
        if(j < matrix[0].length - 1 && matrix[i][j] > matrix[i][j + 1]){
            max = Math.max(max, getLongest(matrix, i, j + 1) + 1);
        }
        
        longests[i][j] = max;
        return max;
    }
}