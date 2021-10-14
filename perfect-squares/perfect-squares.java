class Solution {
    Integer[] nums;
    public int numSquares(int n) {
        nums = new Integer[n + 1];
        return getNumSquares(n);
    }
    
    public int getNumSquares(int n){
        if(n == 0 || n == 1)
            return n;
        
        if(nums[n] != null)
            return nums[n];
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++){
            min = Math.min(min, 1 + getNumSquares(n - i * i));
        }
        
        nums[n] = min;
        return nums[n];
    }
}