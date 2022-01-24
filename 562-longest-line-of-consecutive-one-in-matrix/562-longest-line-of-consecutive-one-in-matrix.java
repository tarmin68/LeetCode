class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        //0 --> horizontal, 1 --> vertical, 2-->diagonal, 3-->anti-diagonal
        int[][][] counts = new int[m][n][4];
        int longest = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    if(j > 0){
                        counts[i][j][0] = counts[i][j - 1][0] + 1;
                    }
                    else{
                        counts[i][j][0] = 1;
                    }
                    longest = Math.max(longest, counts[i][j][0]);
                    if(i > 0){
                        counts[i][j][1] = counts[i - 1][j][1] + 1;
                    }
                    else{
                        counts[i][j][1] = 1;
                    }
                    longest = Math.max(longest, counts[i][j][1]);
                    if(i > 0 && j > 0){
                        counts[i][j][2] = counts[i - 1][j - 1][2] + 1;
                    }
                    else{
                        counts[i][j][2] = 1;
                    }
                    longest = Math.max(longest, counts[i][j][2]);
                    if(i > 0 && j < n - 1){
                        counts[i][j][3] = counts[i - 1][j + 1][3] + 1;
                    }
                    else{
                        counts[i][j][3] = 1;
                    }
                    longest = Math.max(longest, counts[i][j][3]);
                }
            }
        }
        
        return longest;
    }
}