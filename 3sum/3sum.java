class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> usedPair = new HashMap<>();
        
        int zeroFreq = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) zeroFreq++;
            if(usedPair.get(nums[i]) == null){
                usedPair.put(nums[i], new ArrayList<Integer>());
                usedPair.get(nums[i]).add(nums[i]);
            }
            else{
                usedPair.get(nums[i]).remove(new Integer(nums[i]));
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        if(zeroFreq > 2){
            res.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
            usedPair.get(0).add(0);
        }
        else if(zeroFreq > 0){
            usedPair.get(0).add(0);
        }
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(!usedPair.get(nums[i]).contains(nums[j])){
                    int third = 0 - nums[i] - nums[j];
                    if(!usedPair.get(nums[i]).contains(third) && !usedPair.get(nums[j]).contains(third) && usedPair.get(third) != null){
                        ArrayList<Integer> currList = new ArrayList<>();
                        currList.add(nums[i]);
                        currList.add(nums[j]);
                        currList.add(third);
                        res.add(currList);
                        usedPair.get(nums[i]).add(nums[j]);
                        usedPair.get(nums[i]).add(third);
                        usedPair.get(nums[j]).add(nums[i]);
                        usedPair.get(nums[j]).add(third);
                        usedPair.get(third).add(nums[i]);
                        usedPair.get(third).add(nums[j]);
                    }
                }
            }
        }
        
        return res;
    }
}