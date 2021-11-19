class Solution {
    public int hammingDistance(int x, int y) {
        int mask = 1;
        int count = 0;
        
        for(int i = 0; i < 32; i++){
            if(((x & mask) ^ (y & mask)) != 0)
                count++;
            mask <<= 1;
        }
        
        return count;
    }
}