class Solution {
    int[] sums;

    public Solution(int[] w) {
        sums = new int[w.length];
        sums[0] = w[0];
        
        for(int i = 1; i < w.length; i++){
            sums[i] = w[i] + sums[i - 1];
        }
    }
    
    public int pickIndex() {
        double target = Math.random() * sums[sums.length - 1];
        
        int low = 0;
        int high = sums.length;
        
        while(low < high){
            int mid = low + (high - low) / 2;
            if(target > sums[mid]){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */