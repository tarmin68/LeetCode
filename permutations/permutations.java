class Solution {
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> permute(int[] nums) {
        getPermute(0, nums);
        return res;
    }
    
    public void getPermute(int idx, int[] nums){
        if(idx == nums.length - 1){
            add(nums);
        }
        
        for(int i = idx; i < nums.length; i++){
            swap(idx, i, nums);
            getPermute(idx + 1, nums);
            swap(idx, i, nums);
        }
    }
    
    public void add(int[] nums){
        List<Integer> currList = new ArrayList();
        for(int i = 0; i < nums.length; i++){
            currList.add(nums[i]);
        }
        
        res.add(currList);
    }
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}