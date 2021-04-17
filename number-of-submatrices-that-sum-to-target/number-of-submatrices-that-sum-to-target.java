class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] sums = new int[matrix.length + 1][matrix[0].length + 1];
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
            }
        }

        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix.length; j++){
                for(int k = 0; k < matrix[0].length; k++){
                    for(int l = k; l < matrix[0].length; l++){
                        int sum = (sums[j + 1][l + 1] - sums[j + 1][k]) - (sums[i][l + 1] - sums[i][k]);
                        
                        if(sum == target)
                            count++;
                    }
                }
            }
        }
        
        return count;
    }
}