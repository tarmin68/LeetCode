class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] moves = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};
        double[][][] probs = new double[n][n][k + 1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                probs[i][j][0] = 1.0;
            }
        }
        
        for(int i = 1; i <= k; i++){
            for(int j = 0; j < n; j++){
                for(int g = 0; g < n; g++){
                    double res = 0;
                    for(int l = 0; l < moves.length; l++){
                        if(0 <= j + moves[l][0] && j + moves[l][0] < n && 
                           0 <= g + moves[l][1] && g + moves[l][1] < n){
                            res += probs[j + moves[l][0]][g + moves[l][1]][i - 1];
                        }
                    }
                    probs[j][g][i] = res / 8.0;
                }
            }
        }
        
        return probs[row][column][k];
    }
}