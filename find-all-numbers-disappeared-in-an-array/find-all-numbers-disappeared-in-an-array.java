class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> allNum = new HashSet();
        for(int i = 1; i <= nums.length; i++){
            allNum.add(i);
        }
        
        for(int i = 0; i < nums.length; i++){
            if(allNum.contains(nums[i]))
                allNum.remove(nums[i]);
        }
        
        return new ArrayList<Integer>(allNum);
    }
}