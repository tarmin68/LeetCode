class Solution {
    Integer [][] maxes;
    int[] sums;
    
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        
        maxes = new Integer[n][m + 1];
        sums = new int[n + 1];
        
        for(int i = 0; i < n; i++){
            sums[i + 1] = sums[i] + nums[i];
        }
        
        return getMax(nums, 0, m);
    }
    
    public int getMax(int[] nums, int l, int m){
        if(l >= nums.length)
            return Integer.MAX_VALUE;
        
        if(m == 1)
            return sums[nums.length] - sums[l];
        
        if(maxes[l][m] != null)
            return maxes[l][m];
        
        int min = Integer.MAX_VALUE;
        
        for(int i = l; i < nums.length; i++){
            int max = Math.max(getMax(nums, i + 1, m - 1), sums[i + 1] - sums[l]);
            min = Math.min(min, max);
        }
        
        return maxes[l][m] = min;
    }
}