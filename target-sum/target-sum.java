class Solution {
    HashMap<Pair<Integer, Integer>, Integer> myMap;
    public int findTargetSumWays(int[] nums, int target) {
        myMap = new HashMap();
        
        return getCount(nums, 0, target);
    }
    
    public int getCount(int[] nums, int idx, int target){
        if(idx == nums.length && target == 0)
            return 1;
        else if(idx == nums.length)
            return 0;
        
        if(myMap.get(new Pair(idx, target)) != null)
            return myMap.get(new Pair(idx, target));
        
        int count = 0;
        count += getCount(nums, idx + 1, target - nums[idx]);
        count += getCount(nums, idx + 1, target + nums[idx]);
        
        myMap.put(new Pair(idx, target), count);
        
        return count;
    }
}