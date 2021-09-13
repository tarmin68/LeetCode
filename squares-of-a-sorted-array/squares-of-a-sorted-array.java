class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        int l = 0; 
        int r = n - 1;
        int i = n - 1;
        while(i >= 0){
            if(nums[r] * nums[r] > nums[l] * nums[l]){
                res[i] = nums[r] * nums[r];
                i--;
                r--;
            }
            else{
                res[i] = nums[l] * nums[l];
                i--;
                l++;
            }
        }
        
        return res;
    }
    
    public int[] sortAllPos(int[] nums){
        int[] res = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            res[i] = nums[i] * nums[i];
        }
        
        return res;
    }
    
    public int[] sortAllNeg(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        
        for(int i = 0; i < n; i++){
            res[i] = nums[n - 1 - i] * nums[n - 1 - i];
        }
        
        return res;
    }
    
}