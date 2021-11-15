class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, ArrayList<Integer>> numMap = new HashMap();
        List<Integer> res = new ArrayList();
        
        for(int i = 0; i < nums.length; i++){
            ArrayList<Integer> currList = new ArrayList();
            for(int j = 1; j * j <= nums[i]; j++){
                if(nums[i] % j == 0){
                    if(numMap.get(j) != null){
                        ArrayList<Integer> prevList = numMap.get(j);
                        if(prevList.size() > currList.size()){
                            currList = prevList;
                        }
                    }
                    if(numMap.get(nums[i] / j) != null){
                        ArrayList<Integer> prevList = numMap.get(nums[i] / j);
                        if(prevList.size() > currList.size()){
                            currList = prevList;
                        }
                    }
                }
            }
            numMap.put(nums[i], new ArrayList<Integer>(currList));
            numMap.get(nums[i]).add(nums[i]);
            if(currList.size() + 1 > res.size()){
                res = numMap.get(nums[i]);
            }
        }
        
        return res;
    }
}