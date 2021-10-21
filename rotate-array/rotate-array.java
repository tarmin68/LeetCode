class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        
        int count = 0;
        for(int start = 0; count < nums.length; start++){
            int current = start;
            int prev = nums[current];
            
            do{
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                current = next;
                prev = temp;
                count++;
            } while(current != start);
        }
    }
}