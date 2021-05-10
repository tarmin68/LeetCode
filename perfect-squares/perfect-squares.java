class Solution {
    int[] sqNums;
    public int numSquares(int n) {
        sqNums = new int[n + 1];
        
        return getNumSq(n);
    }
    
    public int getNumSq(int n){
        if(n <= 1)
            return n;
        
        if(sqNums[n] != 0)
            return sqNums[n];
        
        int sqRoot = (int) Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= sqRoot; i++){
            min = Math.min(min, 1 + getNumSq(n - i * i));
        }
        
        sqNums[n] = min;
        return min;
    }
}