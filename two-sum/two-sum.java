class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap();
        int[] res = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            if(numMap.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = numMap.get(target - nums[i]);
                return res;
            }
            else{
                numMap.put(nums[i], i);
            }
        }
        
        return res;
    }
}