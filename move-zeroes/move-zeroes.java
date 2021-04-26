class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && j == -1){
                j = i;
            }
            if(nums[i] != 0 && j != -1){
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }
}