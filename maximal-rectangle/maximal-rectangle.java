class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] sumVer = new int[rows][cols];
        for(int i = 0; i < cols; i++){
            sumVer[0][i] = matrix[0][i] - '0';
        }
        for(int i = 1; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    sumVer[i][j] = sumVer[i - 1][j] + 1;
                }
            }
        }
        
        int[][][] rangeMinVer = new int[rows][cols][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                rangeMinVer[i][j][j] = sumVer[i][j];
                for(int k = j - 1; k >= 0; k--){
                    rangeMinVer[i][j][k] = Math.min(rangeMinVer[i][j][k + 1], sumVer[i][k]);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                for(int k = 0; k <= j; k++){
                    int area = Math.min(sumVer[i][j], rangeMinVer[i][j][k]) * (j - k + 1);
                    max = Math.max(max, area);
                }
            }
        }
        
        return max;
    }
}