public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int mask = 1;
        int res = 0;
        for(int i = 0; i < 32; i++){
            if((n & mask) != 0){
                res |= (1 << (31 - i));
            }
            mask <<= 1;
        }
        
        return res;
    }
}