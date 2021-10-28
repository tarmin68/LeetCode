class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<Pair<Integer, Integer>> allPairs = new HashSet();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            int l = i + 1;
            int r = nums.length - 1;
            
            while(l < r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    allPairs.add(new Pair(nums[i], nums[l]));
                    l++;
                    r--;
                }
                else if(nums[i] + nums[l] + nums[r] < 0)
                    l++;
                else
                    r--;
            }
        }
        
        List<List<Integer>> res = new ArrayList();
        for(Pair<Integer, Integer> currPair : allPairs){
            int first = currPair.getKey();
            int second = currPair.getValue();
            int third = 0 - first - second;
            List<Integer> currTriplet = Arrays.asList(new Integer[]{first, second, third});
            res.add(currTriplet);
        }
        
        return res;
    }
}