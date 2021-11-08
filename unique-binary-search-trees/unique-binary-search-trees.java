class Solution {
    Integer[] counts;
    
    public int numTrees(int n) {
        counts = new Integer[n + 1];
        counts[0] = 1;
        counts[1] = 1;
        
        return getCounts(n);
    }
    
    public int getCounts(int num){
        if(counts[num] != null)
            return counts[num];
        
        int res = 0;
        for(int i = 1; i <= num; i++){
            res += (getCounts(i - 1) * getCounts(num - i));
        }
        
        return counts[num] = res;
    }
}