class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int count =0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(low <= (nums[i] ^ nums[j]) && (nums[i] ^ nums[j])<= high)  count++;
            }
        }
        return count;
    }
}