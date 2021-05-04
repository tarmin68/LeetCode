class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean modified = false;
        
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                if(modified)
                    return false;
                else if(i == 0 || i == nums.length - 2 || nums[i + 1] >= nums[i - 1])
                    modified = true;
                else{
                    modified = true;
                    nums[i + 1] = nums[i];
                }
            }
        }
        
        return true;
    }
}