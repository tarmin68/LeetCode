class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] zeroOnes = new int[strs.length + 1][m + 1][n + 1];
        
        for(int i = 1; i < strs.length + 1; i++){
            int[] counts = getCount(strs[i - 1]);
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    if(counts[0] <= j && counts[1] <= k){
                        zeroOnes[i][j][k] = Math.max(zeroOnes[i - 1][j][k], zeroOnes[i - 1][j - counts[0]][k - counts[1]] + 1);
                    }
                    else{
                        zeroOnes[i][j][k] = zeroOnes[i - 1][j][k];
                    }
                }
            }
            // for(int j = 0; j <= n; j++){
            //     if(counts[1] <= j){
            //         ones[i][j] = Math.max(ones[i - 1][j], ones[i - 1][j - counts[1]] + 1);
            //     }
            //     else{
            //         ones[i][j] = ones[i - 1][j];
            //     }
            // }
        }
        
        return zeroOnes[strs.length][m][n];
    }
    
    public int[] getCount(String s){
        int[] res = new int[2];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0')
                res[0]++;
            else
                res[1]++;
        }
        
        return res;
    }
}