class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap();
        
        int max = 0;
        int max_num = 0;
        for(int i = 0; i < nums.length; i++){
            int currCount = counts.getOrDefault(nums[i], 0) + 1;
            counts.put(nums[i], currCount);
            if(currCount > max){
                max = currCount;
                max_num = nums[i];
            }
        }
        
        return max_num;
    }
}