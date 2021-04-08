class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] count = new int[1001];
        
        for(int i = 0; i < A.length; i++){
            count[A[i]]++;
        }
        
        for(int i = 1000; i >= 0; i--){
            if(count[i] == 1)
                return i;
        }
        
        return -1;
    }
}