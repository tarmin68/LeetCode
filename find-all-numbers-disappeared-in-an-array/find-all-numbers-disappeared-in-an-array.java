class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> s = new HashSet();
        
        for(int i = 0; i < nums.length; i++){
            s.add(nums[i]);
        }
        
        List<Integer> res = new ArrayList();
        for(int i = 1; i <= nums.length; i++){
            if(!s.contains(i))
                res.add(i);
        }
        
        return res;
    }
}