class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> allNums = new HashSet();
        HashSet<List<Integer>> allTriplets = new HashSet();
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int target = 0 - nums[i] - nums[j];
                if(allNums.contains(target)){
                    List<Integer> newTriplet = Arrays.asList(nums[i], nums[j], target);
                    Collections.sort(newTriplet);
                    allTriplets.add(newTriplet);
                }
            }
            allNums.add(nums[i]);
        }
        
        return new ArrayList<List<Integer>>(allTriplets);
    }
}