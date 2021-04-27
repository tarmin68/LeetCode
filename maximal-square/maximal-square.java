class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] ones = new int[matrix.length][matrix[0].length];
        
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i == 0 || j == 0){
                    ones[i][j] = matrix[i][j] - '0';
                }
                else if(matrix[i][j] == '1'){
                    int min = Math.min(ones[i - 1][j], ones[i][j - 1]);
                    min = Math.min(min, ones[i - 1][j - 1]);
                    ones[i][j] = min + 1;
                }
                max = Math.max(max, ones[i][j]);
            }
        }
        
        return max * max;
    }
}