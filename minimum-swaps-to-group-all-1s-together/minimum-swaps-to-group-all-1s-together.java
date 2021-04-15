class Solution {
    public int minSwaps(int[] data) {
        int ones = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] == 1)
                ones++;
        }
        
        int zeros = 0;
        for(int i = 0; i < ones; i++){
            if(data[i] == 0)
                zeros++;
        }
        
        int minSwap = zeros;
        for(int i = 1; i + ones <= data.length; i++){
            if(data[i - 1] == 0)
                zeros--;
            if(data[i + ones - 1] == 0)
                zeros++;
            minSwap = Math.min(minSwap, zeros);
        }
        
        return minSwap;
    }
}