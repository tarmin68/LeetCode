class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> res = new ArrayList();
        int i = 0;
        int minDim = Math.min(m, n);
        while(i < (minDim + 1) / 2){
            int row = i; 
            for(int j = i; j < n - i; j++){
                res.add(matrix[row][j]);
            }
            int col = n - 1 - i;
            if(col >= 0){
                for(int j = i + 1; j < m - 1 - i; j++){
                    res.add(matrix[j][col]);
                }
            }
            if(m - 1 - i != i){
                row = m - 1 - i;
                for(int j = n - 1 - i; j >= i; j--){
                    res.add(matrix[row][j]);
                }
            }
            if(n - 1 - i != i && i < n){
                col = i;
                for(int j = m - 2 - i; j > i; j--){
                    res.add(matrix[j][col]);
                }
            }
            i++;
        }
        
        return res;
    }
}