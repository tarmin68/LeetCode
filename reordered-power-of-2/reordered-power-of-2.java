class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[] numCounts = getCount(N);
        for(int i = 0; i < 31; i++){
            if(Arrays.equals(numCounts, getCount(1 << i))){
                return true;
            }
        }
        
        return false;
    }
    
    public int[] getCount(int num){
        int[] res = new int[10];
        
        while(num > 0){
            res[num%10]++;
            num /= 10;
        }
        
        return res;
    }
}