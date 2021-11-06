class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> numsSoFar = new HashSet();
        
        for(int i = 0; i < nums.length; i++){
            if(numsSoFar.contains(nums[i]))
                numsSoFar.remove(nums[i]);
            else
                numsSoFar.add(nums[i]);
        }
        
        int[] res = new int[2];
        int i = 0;
        for(Integer num : numsSoFar){
            res[i++] = num;
        }
        
        return res;
    }
}