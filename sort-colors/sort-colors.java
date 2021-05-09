class Solution {
    public void sortColors(int[] nums) {
        int i = 0; 
        int j = nums.length - 1;
        
        for(int k = 0; k <= j; k++){
            if(nums[k] == 0){
                swap(nums, i++, k);
            }
            else if(nums[k] == 2){
                swap(nums, j--, k--);
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}