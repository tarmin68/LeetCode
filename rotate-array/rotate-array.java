class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = nums.clone();
        
        k = k % n;
        for(int i = 0; i < n; i++){
            nums[i] = res[(i + (n - k)) % n];
        }
    }
}