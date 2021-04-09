class Solution {
    public int longestLine(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0)
            return 0;
        
        int m = M.length;
        int n = M[0].length;
        int[][] HCount = new int[m][n];
        int[][] VCount = new int[m][n];
        int[][] DCount = new int[m][n];
        int[][] ACount = new int[m][n];
        
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(M[i][j] == 1){
                    HCount[i][j]++;
                    VCount[i][j]++;
                    DCount[i][j]++;
                    ACount[i][j]++;
                    
                    if(i > 0){
                        VCount[i][j] += VCount[i - 1][j];
                    }
                    if(j > 0){
                        HCount[i][j] += HCount[i][j - 1];
                    }
                    if(i > 0 && j > 0){
                        DCount[i][j] += DCount[i - 1][j - 1];
                    }
                    if(i > 0 && j < n - 1){
                        ACount[i][j] += ACount[i - 1][j + 1];
                    }
                    
                    max = Math.max(max, VCount[i][j]);
                    max = Math.max(max, HCount[i][j]);
                    max = Math.max(max, DCount[i][j]);
                    max = Math.max(max, ACount[i][j]);
                }
            }
        }
        
        return max;
    }
}