class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return res;
    }
    
    public void permute(int[] nums, int idx){
        if(idx >= nums.length){
            List<Integer> newPerm = new ArrayList();
            for(int i = 0; i < nums.length; i++){
                newPerm.add(nums[i]);
            }
            res.add(newPerm);
        }
        
        for(int i = idx; i < nums.length; i++){
            swap(nums, idx, i);
            permute(nums, idx + 1);
            swap(nums, idx, i);
        }
    }
    
    public void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}